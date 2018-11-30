package com.cts.fasttack.core.jms.processor;

import java.sql.Date;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.UUID;

import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.dict.PanSourceType;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.SimpleErrorCode;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.core.Constants;
import com.cts.fasttack.core.converter.JmsVtsDeviceInfoToDtoConverter;
import com.cts.fasttack.core.converter.TokenCreateNotificationToTokenInfoDtoConverter;
import com.cts.fasttack.core.converter.TokenNotificationDtoToTokenHistoryConverter;
import com.cts.fasttack.core.converter.TokenNotificationStatusToJmsDtoConverter;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.BinSetupDto;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.BinSetupService;
import com.cts.fasttack.core.service.DeviceInfoService;
import com.cts.fasttack.core.service.TokenHistoryService;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.jms.data.JmsMessage;
import com.cts.fasttack.jms.dto.BankJmsResponseDto;
import com.cts.fasttack.jms.dto.JmsExpirationDateDto;
import com.cts.fasttack.jms.dto.JmsTokenCreateNotificationDto;
import com.cts.fasttack.jms.dto.JmsTokenCreateNotificationResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenDetailsDto;
import com.cts.fasttack.jms.dto.JmsTokenInquiryDto;
import com.cts.fasttack.jms.dto.JmsTokenInquiryResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenNotificationDto;
import com.cts.fasttack.jms.dto.JmsTokenStatusUpdatedDto;
import com.cts.fasttack.jms.dto.JmsVtsDeviceInfo;
import com.cts.fasttack.jms.dto.TokenCreateNotificationJmsMessage;
import com.cts.fasttack.jms.dto.TokenInquiryJmsMessage;
import com.cts.fasttack.jms.dto.TokenNotificationJmsMessage;
import com.cts.fasttack.jms.dto.TokenNotificationJmsResponse;
import com.cts.fasttack.jms.dto.TokenStatusUpdatedJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;
import com.cts.fasttack.logging.service.CallingContext;
import org.apache.camel.Exchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenNotificationProcessor extends AbstractCamelProcessor<TokenNotificationJmsMessage, TokenNotificationJmsResponse> {

	private Logger logger = LogManager.getLogger(CardholderVerificationMethodsProcessor.class);

    @Value("${spring.notify.token.updated}")
    private boolean notifyTokenUpdated;

    @Autowired
    private TokenHistoryService tokenHistoryService;

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private TokenNotificationDtoToTokenHistoryConverter tokenNotificationDtoToTokenHistoryConverter;

    @Autowired
    private TokenNotificationStatusToJmsDtoConverter tokenNotificationStatusToJmsDtoConverter;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private AlertLogService alertLogService;

    @Autowired
    private BinSetupService binSetupService;

    @Autowired
    private TokenCreateNotificationToTokenInfoDtoConverter tokenCreateNotificationToTokenInfoDtoConverter;

    @Autowired
    private DeviceInfoService deviceInfoService;

    @Autowired
    private JmsVtsDeviceInfoToDtoConverter jmsVtsDeviceInfoToDtoConverter;

    @Value("${spring.binSetup.defaultSendCardTokenized}")
    private boolean defaultSendCardTokenized;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, TokenNotificationJmsMessage.class, request -> {
            JmsTokenNotificationDto tokenNotificationDto = request.getJmsTokenNotificationDto();

            TokenInfoDto tokenInfoDto = tokenInfoService.getOptional(new TokenInfoId(tokenNotificationDto.getTokenReferenceID(), tokenNotificationDto.getTokenRequestorID())).orElse(null);

            if (tokenInfoDto != null && tokenInfoDto.getTokenStatusUpdate() != null) {
                if (InternationalPaymentSystem.V.equals(tokenInfoDto.getIps())) {
                	if (tokenInfoDto.getTokenStatusUpdate() == null || tokenInfoDto.getTokenStatusUpdate().before(tokenNotificationDto.getDateTimeOfEvent())) {
                	    tokenInfoDto.setTokenStatus(TokenStatus.valueOf(String.valueOf(tokenNotificationDto.getEncryptedData().getTokenInfo().getTokenStatus().charAt(0))));
                	    tokenInfoDto.setTokenStatusUpdate(tokenNotificationDto.getDateTimeOfEvent());

                	    JmsExpirationDateDto jmsExpirationDateDto = tokenNotificationDto.getEncryptedData().getTokenInfo().getTokenExpirationDate();
                        tokenInfoDto.setTokenExpdate(Date.from(YearMonth.of(Integer.valueOf(jmsExpirationDateDto.getYear()), Integer.valueOf(jmsExpirationDateDto.getMonth())).atEndOfMonth().atStartOfDay(ZoneId.systemDefault()).toInstant()));

                        tokenInfoService.save(tokenInfoDto);

                        if (notifyTokenUpdated) {
                            JmsTokenStatusUpdatedDto jmsTokenStatusUpdatedDto = tokenNotificationStatusToJmsDtoConverter.convert(request);
                            jmsTokenStatusUpdatedDto.setPanInternalId(tokenInfoDto.getPanInternalId());
                            jmsTokenStatusUpdatedDto.setPanInternalGuid(tokenInfoDto.getPanInternalGuid());

                            JmsMessage jmsMessage = new TokenStatusUpdatedJmsMessage()
                                    .jmsTokenStatusUpdatedDto(jmsTokenStatusUpdatedDto)
                                    .originator(callingContext.getOriginator());
                            integrationBus.inOut(() -> Constants.ORIGINATOR, "notifyTokenUpdated", jmsMessage, BankJmsResponseDto.class);
                        }
                	} else {
                		log.info("Received Token Notification message but more recent notification has been processed before. " +
                				"Will not update TOKEN_INFO nor send notification to the bank. tokenReferenceId = " +
                				tokenNotificationDto.getTokenReferenceID());
                	}

                	TokenHistoryDto tokenHistoryDto = tokenNotificationDtoToTokenHistoryConverter.convert(request);
                    tokenHistoryDto.setTokenStatus(tokenInfoDto.getTokenStatus());
                    tokenHistoryDto.setTokenExpdate(tokenInfoDto.getTokenExpdate());
                    tokenHistoryService.save(tokenHistoryDto);
                } else {
                    AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                            .with(AlertLogDto::setEvent, "TOKEN_IPS_NOT_VALID")
                            .with(AlertLogDto::setOriginator, request.getOriginator())
                            .with(AlertLogDto::setData, "Token with tokenRefId = " + tokenInfoDto.getId().getTokenRefId()
                                    + " and tokenRequestorId = " + tokenInfoDto.getId().getTokenRequestorId()
                                    + " has invalid IPS " + tokenInfoDto.getIps().name() + " for this request")
                            .with(AlertLogDto::setDate, new java.util.Date())
                            .build();

                    alertLogService.save(alertLogDto);
					logger.info(alertLogDto.getData());
                }
            } else {
            	JmsTokenInquiryDto tokenInquiryRequestDto = new JmsTokenInquiryDto();

            	tokenInquiryRequestDto.setRequestID(UUID.randomUUID().toString().replace("-", ""));
            	tokenInquiryRequestDto.setTokenReferenceID(tokenNotificationDto.getTokenReferenceID());
            	tokenInquiryRequestDto.setTokenRequestorID(tokenNotificationDto.getTokenRequestorID());

            	JmsTokenInquiryResponseDto tokenInquiryResponseDto = integrationBus.inOut(() -> "VTS",
            			"tokenInquiry",
            			new TokenInquiryJmsMessage().tokenInquiryRequestDto(tokenInquiryRequestDto),
            			JmsTokenInquiryResponseDto.class);
            	
            	if ("00".equals(tokenInquiryResponseDto.getActionCode())) {
            	    if (!tokenInquiryResponseDto.getTokenDetails().isEmpty()) {
            		    JmsTokenDetailsDto tokenDetailsDto = tokenInquiryResponseDto.getTokenDetails().get(0);

                		log.info("Received Token Notification message but no Token Create Notification has been processed before. " +
                				"Will process this notification as token creation one. tokenReferenceId = " +
                				tokenNotificationDto.getTokenReferenceID());

                		JmsTokenCreateNotificationDto tokenCreateNotificationDto = constructFromNotificationAndTokenDetails(tokenNotificationDto, tokenDetailsDto);

            		    TokenCreateNotificationJmsMessage tokenCreateNotificationJmsMessage = (TokenCreateNotificationJmsMessage) new TokenCreateNotificationJmsMessage()
                                .jmsTokenCreateNotificationDto(tokenCreateNotificationDto)
                                .originator(Constants.ORIGINATOR).messageHistoryId(request.getMessageHistoryId());

                        if (tokenInfoDto != null) {
                    	    tokenCreateNotificationJmsMessage.setPanInternalId(tokenInfoDto.getPanInternalId());
                    	    tokenCreateNotificationJmsMessage.setPanInternalGuid(tokenInfoDto.getPanInternalGuid());
                        }

                        BinSetupDto binSetupDto = binSetupService.getSuitableBin(tokenNotificationDto.getEncryptedData().getCardholderInfo().getPrimaryAccountNumber()).orElse(null);
                    
                        boolean sendCardTokenized = defaultSendCardTokenized;
                        if(binSetupDto != null) {
                    	    sendCardTokenized = binSetupDto.isSendCardTokenized();
                        }            

                        tokenCreateNotificationJmsMessage.setCardTokenized(sendCardTokenized);
                    
                        JmsTokenCreateNotificationResponseDto tokenCreateNotificationResponseDto = integrationBus.inOut(() -> Constants.ORIGINATOR, "tokenCreateNotification",
                                tokenCreateNotificationJmsMessage, JmsTokenCreateNotificationResponseDto.class);

                        TokenInfoDto responseTokenInfoDto = tokenCreateNotificationToTokenInfoDtoConverter.convert(tokenCreateNotificationJmsMessage, tokenCreateNotificationResponseDto);

                        if (tokenInfoDto != null) {
                    	    if (responseTokenInfoDto.getPanInternalId() == null) {
                    		    responseTokenInfoDto.setPanInternalId(tokenInfoDto.getPanInternalId());
                    	    }
                    	    if (responseTokenInfoDto.getPanInternalGuid() == null) {
                    		    responseTokenInfoDto.setPanInternalGuid(tokenInfoDto.getPanInternalGuid());
                    	    }
                    	    if (responseTokenInfoDto.getCustomerId() == null) {
                    		    responseTokenInfoDto.setCustomerId(tokenInfoDto.getCustomerId());
                    	    }
                    	    if (responseTokenInfoDto.getCustomerPhone() == null) {
                    		    responseTokenInfoDto.setCustomerPhone(tokenInfoDto.getCustomerPhone());
                    	    }
                    	    responseTokenInfoDto.setLifecycleTraceId(tokenInfoDto.getLifecycleTraceId());
                        }

                        if (binSetupDto != null) {
                    	    responseTokenInfoDto.setBin(binSetupDto.getBin());
                        }

                        tokenInfoDto = tokenInfoService.save(responseTokenInfoDto);
            	
                        TokenHistoryDto tokenHistoryDto = tokenNotificationDtoToTokenHistoryConverter.convert(request);
                        tokenHistoryDto.setTokenStatus(tokenInfoDto.getTokenStatus());
                        tokenHistoryDto.setTokenExpdate(tokenInfoDto.getTokenExpdate());
                        tokenHistoryService.save(tokenHistoryDto);

                        if (tokenCreateNotificationDto.getDeviceInfo() != null) {
                        	deviceInfoService.save(jmsVtsDeviceInfoToDtoConverter.convert(tokenCreateNotificationDto.getDeviceInfo(), tokenInfoDto));
                        }
            	    } else {
            	    	throw new ServiceException(new SimpleErrorCode("Token info not found locally and no data received in Token Inquiry response from VTS"),
            	    			tokenNotificationDto.getTokenReferenceID(),
            	    			tokenNotificationDto.getTokenRequestorID());
            	    }
            	} else {
            		if ("VSE40000".equals(tokenInquiryResponseDto.getErrorCode()) ||
                            "VSE40001".equals(tokenInquiryResponseDto.getErrorCode()) ||
            				"VSE40003".equals(tokenInquiryResponseDto.getErrorCode())) {
            	    	throw new ServiceException(new SimpleErrorCode("Token info not found locally and " +
            				tokenInquiryResponseDto.getErrorCode() + " error received in Token Inquiry response from VTS"),
            	    			tokenNotificationDto.getTokenReferenceID(),
            	    			tokenNotificationDto.getTokenRequestorID());
            		} else {
            			throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
            		}
            	}
            }

            TokenNotificationJmsResponse response = new TokenNotificationJmsResponse();
            response.setMaskedPan(tokenInfoDto.getMaskedPan());
            response.setPanSource(tokenInfoDto.getPanSource() != null ? tokenInfoDto.getPanSource().name() : null);
            response.setPanInternalId(tokenInfoDto.getPanInternalId());
            response.setPanInternalGuid(tokenInfoDto.getPanInternalGuid());

            return response;
        });
    }

    private JmsTokenCreateNotificationDto constructFromNotificationAndTokenDetails(
    		JmsTokenNotificationDto tokenNotificationDto,
    		JmsTokenDetailsDto tokenDetailsDto) {
    	JmsTokenCreateNotificationDto result = new JmsTokenCreateNotificationDto();

    	result.setClientWalletAccountID(tokenDetailsDto.getWalletAccountID());
    	result.setDateTimeOfEvent(tokenNotificationDto.getDateTimeOfEvent());
    	result.setEncryptedData(tokenNotificationDto.getEncryptedData());
    	result.setEventID(tokenNotificationDto.getEventID());
    	result.setEventType("TOKEN_CREATED");
    	result.setMessageReason(tokenNotificationDto.getMessageReason());
    	result.setMessageReasonCode("3700");
    	result.setPanReferenceID(tokenNotificationDto.getPanReferenceID());
    	result.setTokenReferenceID(tokenNotificationDto.getTokenReferenceID());
    	result.setTokenRequestorID(tokenNotificationDto.getTokenRequestorID());
    	result.setWalletAccountEmailAddressHash(tokenDetailsDto.getWalletAccountEmailAddress());

    	if (tokenDetailsDto.getDeviceInformation() != null) {
    		JmsVtsDeviceInfo deviceInfo = new JmsVtsDeviceInfo();

    		deviceInfo.setDeviceName(tokenDetailsDto.getDeviceInformation().getDeviceName());
    		deviceInfo.setDeviceNumber(tokenDetailsDto.getDeviceInformation().getDeviceNumber());
    		deviceInfo.setDeviceType(tokenDetailsDto.getDeviceInformation().getDeviceType());
    		deviceInfo.setDeviceID(tokenNotificationDto.getDeviceID());

    		result.setDeviceInfo(deviceInfo);
    	}

    	if (tokenDetailsDto.getRiskInformation() != null) {
        	result.setIssuerSpecialConditionCodes(tokenDetailsDto.getRiskInformation().getIssuerSpecialConditionCodes());
    		result.setPanSource(PanSourceType.firstWordFromVisaIwsiPanSource(tokenDetailsDto.getRiskInformation().getPanSource()));
        	result.setVisaTokenDecisioning(tokenDetailsDto.getRiskInformation().getFinalProvisioningDecision());
        	result.setVisaTokenScore(tokenDetailsDto.getRiskInformation().getTokenProvisioningScore());
    	}
    	
    	return result;
    }
}
