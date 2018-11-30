package com.cts.fasttack.core.jms.processor;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.core.util.TokenHelper;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.cts.fasttack.core.Constants;
import com.cts.fasttack.core.converter.JmsVtsDeviceInfoToDtoConverter;
import com.cts.fasttack.core.converter.TokenCreateNotificationDtoToTokenHistoryConverter;
import com.cts.fasttack.core.converter.TokenCreateNotificationToTokenInfoDtoConverter;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dto.BinSetupDto;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.BinSetupService;
import com.cts.fasttack.core.service.DeviceInfoService;
import com.cts.fasttack.core.service.TokenHistoryService;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.jms.dto.JmsTokenCreateNotificationDto;
import com.cts.fasttack.jms.dto.JmsTokenCreateNotificationResponseDto;
import com.cts.fasttack.jms.dto.TokenCreateNotificationJmsMessage;
import com.cts.fasttack.jms.dto.TokenNotificationJmsResponse;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerResponseDto;
import com.cts.fasttack.jms.dto.SendNotificationToCustomerJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenCreateNotificationProcessor extends AbstractCamelProcessor<TokenCreateNotificationJmsMessage, TokenNotificationJmsResponse> {

    public static final String NOTIFICATION_TYPE = "TOKEN_ACTIVATED";

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private TokenHistoryService tokenHistoryService;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private BinSetupService binSetupService;

    @Autowired
    private TokenCreateNotificationDtoToTokenHistoryConverter tokenCreateNotificationDtoToTokenHistoryConverter;

    @Autowired
    private TokenCreateNotificationToTokenInfoDtoConverter tokenCreateNotificationToTokenInfoDtoConverter;

    @Autowired
    private DeviceInfoService deviceInfoService;

    @Autowired
    private JmsVtsDeviceInfoToDtoConverter jmsVtsDeviceInfoToDtoConverter;

    @Autowired
    private TokenHelper tokenHelper;

    @Value("${spring.binSetup.defaultSendCardTokenized}")
    private boolean defaultSendCardTokenized;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, TokenCreateNotificationJmsMessage.class, request -> {
            JmsTokenCreateNotificationDto tokenCreateNotificationDto = request.getJmsTokenCreateNotificationDto();

            TokenInfoDto currentTokenInfoDto = tokenInfoService.getOptional(new TokenInfoId(tokenCreateNotificationDto.getTokenReferenceID(), tokenCreateNotificationDto.getTokenRequestorID())).orElse(null);

            TokenInfoDto tokenInfoDto;

            if (currentTokenInfoDto == null || (currentTokenInfoDto != null && currentTokenInfoDto.getTokenStatusUpdate() == null)) {
                TokenCreateNotificationJmsMessage jmsMessage = (TokenCreateNotificationJmsMessage) new TokenCreateNotificationJmsMessage()
                        .jmsTokenCreateNotificationDto(tokenCreateNotificationDto)
                        .originator(Constants.ORIGINATOR).messageHistoryId(request.getMessageHistoryId());

                if (currentTokenInfoDto != null) {
            	    jmsMessage.setPanInternalId(currentTokenInfoDto.getPanInternalId());
            	    jmsMessage.setPanInternalGuid(currentTokenInfoDto.getPanInternalGuid());
                }

                BinSetupDto binSetupDto = binSetupService.getSuitableBin(tokenCreateNotificationDto.getEncryptedData().getCardholderInfo().getPrimaryAccountNumber()).orElse(null);
            
                boolean sendCardTokenized = defaultSendCardTokenized;
                if(binSetupDto != null) {
            	    sendCardTokenized = binSetupDto.isSendCardTokenized();
                }            

                jmsMessage.setCardTokenized(sendCardTokenized);
            
                JmsTokenCreateNotificationResponseDto tokenCreateNotificationResponseDto = integrationBus.inOut(() -> Constants.ORIGINATOR, "tokenCreateNotification",
                        jmsMessage, JmsTokenCreateNotificationResponseDto.class);

                TokenInfoDto responseTokenInfoDto = tokenCreateNotificationToTokenInfoDtoConverter.convert(request, tokenCreateNotificationResponseDto);

                if (currentTokenInfoDto != null) {
            	    if (responseTokenInfoDto.getPanInternalId() == null) {
            		    responseTokenInfoDto.setPanInternalId(currentTokenInfoDto.getPanInternalId());
            	    }
            	    if (responseTokenInfoDto.getPanInternalGuid() == null) {
            		    responseTokenInfoDto.setPanInternalGuid(currentTokenInfoDto.getPanInternalGuid());
            	    }
            	    if (responseTokenInfoDto.getCustomerId() == null) {
            		    responseTokenInfoDto.setCustomerId(currentTokenInfoDto.getCustomerId());
            	    }
            	    if (responseTokenInfoDto.getCustomerPhone() == null) {
            		    responseTokenInfoDto.setCustomerPhone(currentTokenInfoDto.getCustomerPhone());
            	    }
            	    responseTokenInfoDto.setLifecycleTraceId(currentTokenInfoDto.getLifecycleTraceId());
                }

                if (binSetupDto != null) {
            	    responseTokenInfoDto.setBin(binSetupDto.getBin());
                }

                if (tokenHelper.isSendNotificationToCustomer(responseTokenInfoDto, responseTokenInfoDto.getCustomerPhone())) { //todo visa...
                    publishSendNotificationToCustomer(responseTokenInfoDto);
                }

                tokenInfoDto = tokenInfoService.save(responseTokenInfoDto);
            } else {
        		log.info("Received Token Create Notification message but another token notification has been processed before. " +
        				"Will not send notification to the bank. tokenReferenceId = " +
        				tokenCreateNotificationDto.getTokenReferenceID());

        		TokenInfoDto requestTokenInfoDto = tokenCreateNotificationToTokenInfoDtoConverter.convert(request, null);

                requestTokenInfoDto.setTokenStatus(currentTokenInfoDto.getTokenStatus());
                requestTokenInfoDto.setTokenStatusUpdate(currentTokenInfoDto.getTokenStatusUpdate());
                requestTokenInfoDto.setPanInternalId(currentTokenInfoDto.getPanInternalId());
                requestTokenInfoDto.setPanInternalGuid(currentTokenInfoDto.getPanInternalGuid());
        	    requestTokenInfoDto.setLifecycleTraceId(currentTokenInfoDto.getLifecycleTraceId());
                requestTokenInfoDto.setCustomerId(currentTokenInfoDto.getCustomerId());
                requestTokenInfoDto.setCustomerPhone(currentTokenInfoDto.getCustomerPhone());
                requestTokenInfoDto.setBin(currentTokenInfoDto.getBin());

                tokenInfoDto = tokenInfoService.save(requestTokenInfoDto);
            }

            TokenHistoryDto tokenHistoryDto = tokenCreateNotificationDtoToTokenHistoryConverter.convert(tokenCreateNotificationDto);
            tokenHistoryDto.setTokenStatus(tokenInfoDto.getTokenStatus());
            tokenHistoryDto.setTokenExpdate(tokenInfoDto.getTokenExpdate());
            tokenHistoryService.save(tokenHistoryDto);

            if (tokenCreateNotificationDto.getDeviceInfo() != null) {
            	deviceInfoService.save(jmsVtsDeviceInfoToDtoConverter.convert(tokenCreateNotificationDto.getDeviceInfo(), tokenInfoDto));
            }

            TokenNotificationJmsResponse response = new TokenNotificationJmsResponse();
            response.setMaskedPan(tokenInfoDto.getMaskedPan());
            response.setPanSource(tokenInfoDto.getPanSource() != null ? tokenInfoDto.getPanSource().name() : null);
            response.setPanInternalId(tokenInfoDto.getPanInternalId());
            response.setPanInternalGuid(tokenInfoDto.getPanInternalGuid());

            return response;
        });
    }

    private JmsSendNotificationToCustomerResponseDto publishSendNotificationToCustomer(TokenInfoDto tokenInfoDto) throws ServiceException {
        tokenInfoDto.setReminderPeriod(String.valueOf(tokenHelper.getDiffHours(tokenInfoDto.getTokenStatusUpdate())));
        HeadersJmsMessage jmsMessage = new SendNotificationToCustomerJmsMessage()
                .jmsSendNotificationToCustomerRequestDto(tokenHelper.createJmsSendCreateNotificationToCustomerRequestDto(tokenInfoDto, NOTIFICATION_TYPE))
                .originator(Constants.ORIGINATOR);

        return integrationBus.inOut(() -> "BANK", "sendNotificationToCustomer", jmsMessage, JmsSendNotificationToCustomerResponseDto.class);
    }
}
