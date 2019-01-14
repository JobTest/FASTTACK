package com.cts.fasttack.core.jms.processor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.time.temporal.TemporalAdjusters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.cts.fasttack.common.core.dict.PanSourceType;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.core.Constants;
import com.cts.fasttack.core.converter.JmsCardTokenizedDtoConverter;
import com.cts.fasttack.core.converter.NotifyServiceDtoToDeviceInfoConverter;
import com.cts.fasttack.core.converter.NotifyServiceDtoToTokenHistoryConverter;
import com.cts.fasttack.core.converter.NotifyServiceDtoToTokenInfoConverter;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dict.Source;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.CardAndTokenDataDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.dto.BinSetupDto;
import com.cts.fasttack.core.dto.DCProgressDto;
import com.cts.fasttack.core.dto.TokenDto;
import com.cts.fasttack.core.dto.CardholderVerificationMethodDto;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerResponseDto;
import com.cts.fasttack.jms.dto.SendNotificationToCustomerJmsMessage;
import com.cts.fasttack.jms.dto.NotifyServiceJmsMessage;
import com.cts.fasttack.jms.dto.CommonMdesJmsResponseDto;
import com.cts.fasttack.jms.dto.JmsNotifyServiceDto;
import com.cts.fasttack.jms.dto.JmsCardTokenizedResponseDto;
import com.cts.fasttack.jms.dto.JmsCardTokenizedRequestDto;
import com.cts.fasttack.jms.dto.CardTokenizedJmsMessage;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerRequestDto;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDMessageDto;
import com.cts.fasttack.jms.dto.GetCustomerIDJmsMessage;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDResponseDto;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortMessageDto;
import com.cts.fasttack.jms.dto.GetCardInfoShortJmsMessage;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortResponseDto;
import com.cts.fasttack.core.service.BinSetupService;
import com.cts.fasttack.core.service.CardholderVerificationMethodService;
import com.cts.fasttack.core.service.DCProgressService;
import com.cts.fasttack.core.service.DeviceInfoService;
import com.cts.fasttack.core.service.TokenHistoryService;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.core.util.TokenHelper;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import com.cts.fasttack.crypto.client.rest.MdesCryptoRestClient;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;
import com.cts.fasttack.logging.service.CallingContext;
import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.dao.InvalidDataAccessApiUsageException;

/**
 * @author a.lipavets
 */
@Component
public class NotifyServiceActivatedProcessor extends AbstractCamelProcessor<NotifyServiceJmsMessage, CommonMdesJmsResponseDto> {

    private Logger logger = LogManager.getLogger(NotifyTokenUpdatedProcessor.class);

    public static final String NOTIFICATION_TYPE = "TOKEN_ACTIVATED";

    private static final String OLD_PREFIX_ID = "NotYetAssigned-";

    @Autowired
    private AlertLogService alertLogService;

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private TokenHistoryService tokenHistoryService;

    @Autowired
    private DeviceInfoService deviceInfoService;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private MdesCryptoRestClient mdesCryptoRestClient;

    @Autowired
    private NotifyServiceDtoToTokenInfoConverter notifyServiceDtoToTokenInfoConverter;

    @Autowired
    private NotifyServiceDtoToDeviceInfoConverter notifyServiceDtoToDeviceInfoConverter;

    @Autowired
    private NotifyServiceDtoToTokenHistoryConverter notifyServiceDtoToTokenHistoryConverter;

    @Autowired
    private JmsCardTokenizedDtoConverter jmsCardTokenizedDtoConverter;

    @Autowired
    private BinSetupService binSetupService;

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private CardholderVerificationMethodService cardholderVerificationMethodService;

    @Autowired
    private DCProgressService dcProgressService;

    @Autowired
    private TokenHelper tokenHelper;

    @Value("${spring.binSetup.defaultSendCardTokenized}")
    private boolean defaultSendCardTokenized;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, NotifyServiceJmsMessage.class, request -> {
            JmsNotifyServiceDto serviceDto = request.getNotifyServiceDto();

            CryptoResponseDto decryptedDto = mdesCryptoRestClient.decryptWithMdesCustomerPriv(serviceDto.getEncryptedData(),
                    serviceDto.getEncryptedKey(),
                    serviceDto.getPublicKeyFingerprint(), serviceDto.getOaepHashingAlgorithm(),
                    serviceDto.getIv());

            CardAndTokenDataDto cardAndTokenDataDto = JsonUtil.fromJson(decryptedDto.getText(), CardAndTokenDataDto.class);

            TokenInfoDto tokenInfoDto = fillTokenInfo(serviceDto, cardAndTokenDataDto, request.getOriginator());

            BinSetupDto binSetupDto = binSetupService.getSuitableBin(cardAndTokenDataDto.getCard().getAccountNumber()).orElse(null);

            if (binSetupDto != null) {
            	tokenInfoDto.setBin(binSetupDto.getBin());
            }

            TokenInfoDto currentTokenInfoDto = tokenInfoService.getOptional(tokenInfoDto.getId()).orElse(null);
            if (currentTokenInfoDto != null) {
                tokenInfoDto.setCustomerId(currentTokenInfoDto.getCustomerId());
                tokenInfoDto.setPanInternalId(currentTokenInfoDto.getPanInternalId());
                tokenInfoDto.setPanInternalGuid(currentTokenInfoDto.getPanInternalGuid());
                tokenInfoDto.setCustomerPhone(currentTokenInfoDto.getCustomerPhone());
            }

            if (serviceDto.getDeviceInfo() != null) {
                deviceInfoService.save(notifyServiceDtoToDeviceInfoConverter.convert(serviceDto));
            }

            tokenHistoryService.save(notifyServiceDtoToTokenHistoryConverter.convert(serviceDto, tokenInfoDto.getTokenExpdate()));

            boolean sendCardTokenized = defaultSendCardTokenized;
            if (binSetupDto != null) {
            	sendCardTokenized = binSetupDto.isSendCardTokenized();
            }            

            JmsCardTokenizedResponseDto ctResponse = new JmsCardTokenizedResponseDto();
            Optional<DCProgressDto> dcProgressDto = dcProgressService.get(serviceDto.getCorrelationId());
            if(sendCardTokenized){
                ctResponse = publishCardTokenized(request, cardAndTokenDataDto, tokenInfoDto);

                if (tokenHelper.isSendOnlyForRequestors(serviceDto.getTokenRequestorId())) {
                    if (currentTokenInfoDto != null && tokenHelper.isSendNotificationToCustomer(currentTokenInfoDto, tokenInfoDto, ctResponse.getCustomerPhone())) { //todo master...
                        String fillCustomerPhone = fillCustomerPhone(currentTokenInfoDto, ctResponse.getCustomerPhone());
                        publishSendNotificationToCustomer(tokenInfoDto, fillCustomerPhone, request.getNotifyServiceDto().getRequestId());
                    } else if (tokenHelper.isSendNotificationToCustomer(tokenInfoDto, ctResponse.getCustomerPhone())) {
                        String fillCustomerPhone = ctResponse.getCustomerPhone();
                        publishSendNotificationToCustomer(tokenInfoDto, fillCustomerPhone, request.getNotifyServiceDto().getRequestId());
                    }
                }
                saveTokenInfo(tokenInfoDto, ctResponse.getCustomerId(), ctResponse.getPanInternalId(), ctResponse.getPanInternalGUID(), ctResponse.getCustomerPhone(), serviceDto.getCorrelationId());
            } else if (dcProgressDto.isPresent() && dcProgressDto.get().getAsvStatus() != null && StringUtils.isNotBlank(dcProgressDto.get().getPanInternalId()) && StringUtils.isNotBlank(dcProgressDto.get().getPanInternalGUID())) {
                getAndUpdateCustomerID(cardAndTokenDataDto.getCard().getAccountNumber(), tokenInfoDto, dcProgressDto.get().getPanInternalId(), dcProgressDto.get().getPanInternalGUID(), request.getOriginator(), request.getMessageHistoryId(), serviceDto.getCorrelationId());

                if (currentTokenInfoDto != null && tokenHelper.isSendOnlyForRequestors(serviceDto.getTokenRequestorId())) {
                    try {
                        if (tokenHelper.isSendNotificationToCustomer(currentTokenInfoDto, tokenInfoDto, currentTokenInfoDto.getCustomerPhone())) { //todo master...
                            String fillCustomerPhone = fillCustomerPhone(currentTokenInfoDto, currentTokenInfoDto.getCustomerPhone());
                            publishSendNotificationToCustomer(tokenInfoDto, fillCustomerPhone, request.getNotifyServiceDto().getRequestId());
                        } else if (tokenHelper.isSendNotificationToCustomer(tokenInfoDto, currentTokenInfoDto.getCustomerPhone())) {
                            String fillCustomerPhone = currentTokenInfoDto.getCustomerPhone();
                            publishSendNotificationToCustomer(tokenInfoDto, fillCustomerPhone, request.getNotifyServiceDto().getRequestId());
                        }
                    } catch (ServiceException e) {
                        log.error("Error while async process getCardInfoShort and customerIdentifier", e);
                    }
                }
            } else  {
                try {
                    JmsCardTokenizedResponseDto finalCtResponse = ctResponse;
                    CompletableFuture.supplyAsync(() -> {
                        getCardInfoShort(finalCtResponse, cardAndTokenDataDto.getCard().getAccountNumber(), Constants.ORIGINATOR, request.getMessageHistoryId());

                        if (currentTokenInfoDto != null && tokenHelper.isSendOnlyForRequestors(serviceDto.getTokenRequestorId())) {
                            try {
                                if (tokenHelper.isSendNotificationToCustomer(currentTokenInfoDto, tokenInfoDto, currentTokenInfoDto.getCustomerPhone())) { //todo master...
                                    String fillCustomerPhone = fillCustomerPhone(currentTokenInfoDto, currentTokenInfoDto.getCustomerPhone());
                                    publishSendNotificationToCustomer(tokenInfoDto, fillCustomerPhone, request.getNotifyServiceDto().getRequestId());
                                } else if (tokenHelper.isSendNotificationToCustomer(tokenInfoDto, currentTokenInfoDto.getCustomerPhone())) {
                                    String fillCustomerPhone = currentTokenInfoDto.getCustomerPhone();
                                    publishSendNotificationToCustomer(tokenInfoDto, fillCustomerPhone, request.getNotifyServiceDto().getRequestId());
                                }
                            } catch (ServiceException e) {
                                log.error("Error while async process getCardInfoShort and customerIdentifier", e);
                            }
                        }

                        return null;
                    }).thenApplyAsync(s -> {
                        getAndUpdateCustomerID(cardAndTokenDataDto.getCard().getAccountNumber(), tokenInfoDto, finalCtResponse.getPanInternalId(), finalCtResponse.getPanInternalGUID(), request.getOriginator(), request.getMessageHistoryId(), serviceDto.getCorrelationId());
                        return null;
                    }).get();
                } catch (Exception e) {
                    log.error("Error while async process getCardInfoShort and customerIdentifier", e);
                    throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
                }
            }

        	CommonMdesJmsResponseDto cmjResponse = new CommonMdesJmsResponseDto();
            cmjResponse.setMaskedPan(tokenInfoDto.getMaskedPan());
            cmjResponse.setPanSource(tokenInfoDto.getPanSource() != null ? tokenInfoDto.getPanSource().name() : null);
            cmjResponse.setPanInternalId(tokenInfoDto.getPanInternalId());
            cmjResponse.setPanInternalGuid(tokenInfoDto.getPanInternalGuid());

            return cmjResponse;
        });
    }

    @Transactional
    private TokenInfoDto fillTokenInfo(JmsNotifyServiceDto serviceDto, CardAndTokenDataDto cardAndTokenDataDto, String originator) throws ServiceException {
    	TokenDto tokenDto = cardAndTokenDataDto.getToken();
        int tokenYear = 2000 + Integer.parseInt(tokenDto.getExpiryYear());
        int tokenMonth = Integer.parseInt(tokenDto.getExpiryMonth());
        Date tokenExpDate = Date.from(LocalDateTime.of(tokenYear, tokenMonth, 1, 0, 0).with(TemporalAdjusters.lastDayOfMonth()).atZone(ZoneId.systemDefault()).toInstant());

        TokenInfoDto tokenInfoDto = notifyServiceDtoToTokenInfoConverter.convert(serviceDto);
        tokenInfoDto.setTokenExpdate(tokenExpDate);
        tokenInfoDto.setMaskedPan(StringUtil.displayPanOrToken(cardAndTokenDataDto.getCard().getAccountNumber()));
        tokenInfoDto.setMaskedToken(StringUtil.displayPanOrToken(tokenDto.getToken()));
        Source panSource = cardAndTokenDataDto.getCard().getSource();
        if (panSource != null)
        	tokenInfoDto.setPanSource(PanSourceType.getInstance(Source.getSource(panSource.name())));

        //todo:  OTP Code (as -> dac -> nsa)
        Optional<CardholderVerificationMethodDto> cvm = cardholderVerificationMethodService.getByTokenRefIdAndRequestorId(tokenInfoDto.getId().getTokenRefId(), tokenInfoDto.getId().getTokenRequestorId());
        cvm.ifPresent(cardholderVerificationMethodDto -> {
            tokenInfoDto.setPanInternalGuid(cardholderVerificationMethodDto.getPanInternalGUID());
            tokenInfoDto.setPanInternalId(cardholderVerificationMethodDto.getPanInternalId());
            tokenInfoDto.setCustomerPhone(cardholderVerificationMethodDto.getCellPhone());
            //todo  always copy from 'CardholderVerificationMethod' to 'TokenInfo'
            tokenInfoDto.setTokenizationPath(cardholderVerificationMethodDto.getTokenizationPath());
            tokenInfoDto.setWpDeviceScore(cardholderVerificationMethodDto.getWpDeviceScore());
            tokenInfoDto.setWpAccountScore(cardholderVerificationMethodDto.getWpAccountScore());
            tokenInfoDto.setWpPhonenumberScore(cardholderVerificationMethodDto.getWpPhonenumberScore());
            tokenInfoDto.setWpReasonCodes(cardholderVerificationMethodDto.getWpReasonCodes());
            tokenInfoDto.setClrTokenizationStandardVer(cardholderVerificationMethodDto.getColorTokenizationStandardVersion());
        });

        //todo:  Call Centre (as -> nsa)
        TokenInfoDto updateTokenInfoDto = null;
        if(!cvm.isPresent()) {
            cvm = cardholderVerificationMethodService.getByCorrelationId(serviceDto.getCorrelationId()); //todo get By TokenInfo 'CorrelationId' (then not found By 'TokenRefIdAndRequestorId')
            updateTokenInfoDto = cvm.map(cardholderVerificationMethodDto -> {
                final String oldDeviceId = "NotYetAssigned-" + serviceDto.getCorrelationId();
                deviceInfoService.getOptional(oldDeviceId)
                        .ifPresent(deviceInfoDto -> {
                            deviceInfoDto.setTokenRefId(cardholderVerificationMethodDto.getTokenRefId());
                            deviceInfoService.save(deviceInfoDto);
                        });

                final TokenInfoId oldTokenId = new TokenInfoId(cardholderVerificationMethodDto.getTokenRefId(), serviceDto.getTokenRequestorId());
                return tokenInfoService.getOptional(oldTokenId)
                        .map(oldTokenInfoDto -> {
                            oldTokenInfoDto.setId(new TokenInfoId(serviceDto.getTokenUniqueReference(), serviceDto.getTokenRequestorId()));
                            oldTokenInfoDto.setTokenExpdate(tokenInfoDto.getTokenExpdate());
                            oldTokenInfoDto.setMaskedPan(tokenInfoDto.getMaskedPan());
                            oldTokenInfoDto.setMaskedToken(tokenInfoDto.getMaskedToken());
                            if (tokenInfoDto.getPanSource() != null) oldTokenInfoDto.setPanSource(tokenInfoDto.getPanSource());
                            oldTokenInfoDto.setPanRefId(tokenInfoDto.getPanRefId());
                            oldTokenInfoDto.setTokenType(tokenInfoDto.getTokenType());
                            oldTokenInfoDto.setTokenStatus(tokenInfoDto.getTokenStatus());
                            oldTokenInfoDto.setDigitizeDate(tokenInfoDto.getDigitizeDate());
                            return oldTokenInfoDto;
                }).orElse(null);

            }).orElse(verifyDuplicatedTokenInfoDto(tokenInfoDto)); //todo verify duplicated TokenInfo
        }

        if(!cvm.isPresent()){
            AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                    .with(AlertLogDto::setEvent, "CVM_NOT_EXISTS")
                    .with(AlertLogDto::setOriginator, originator)
                    .with(AlertLogDto::setData, "Can't find cardholderVerificationMethod by tokenReferenceId " + tokenInfoDto.getId().getTokenRefId() + " and tokenRequestorId "
                            + tokenInfoDto.getId().getTokenRequestorId())
                    .with(AlertLogDto::setDate, new Date())
                    .build();

            alertLogService.save(alertLogDto);
            logger.info(alertLogDto.getData());
        }

        return updateTokenInfoDto!=null
                ? updateTokenInfoDto
                : tokenInfoDto;
    }

    private TokenInfoDto verifyDuplicatedTokenInfoDto(TokenInfoDto tokenInfoDto) {
        return tokenInfoService.getOptional(tokenInfoDto.getId())
                .filter(oldTokenInfoDto -> oldTokenInfoDto.getTokenStatus()==TokenStatus.A)
                .orElse(tokenInfoDto);
    }

    private JmsCardTokenizedResponseDto publishCardTokenized(NotifyServiceJmsMessage request, CardAndTokenDataDto cardAndTokenDataDto, TokenInfoDto tokenInfoDto) throws ServiceException {
        JmsCardTokenizedRequestDto dto = jmsCardTokenizedDtoConverter.convert(request.getNotifyServiceDto(), cardAndTokenDataDto, tokenInfoDto);

        return integrationBus.inOut(() -> Constants.ORIGINATOR, "cardTokenized",
                new CardTokenizedJmsMessage().jmsCardTokenizedDto(dto).originator(callingContext.getOriginator()).messageHistoryId(request.getMessageHistoryId()), JmsCardTokenizedResponseDto.class);
    }


    private JmsSendNotificationToCustomerResponseDto publishSendNotificationToCustomer(TokenInfoDto tokenInfoDto, String customerPhone, String requestId) throws ServiceException {
        JmsSendNotificationToCustomerRequestDto jmsSendCreateNotificationToCustomerRequestDto = tokenHelper.createJmsSendCreateNotificationToCustomerRequestDto(tokenInfoDto, NOTIFICATION_TYPE, customerPhone);
        jmsSendCreateNotificationToCustomerRequestDto.setRequestId(requestId);

        HeadersJmsMessage jmsMessage = new SendNotificationToCustomerJmsMessage()
                .jmsSendNotificationToCustomerRequestDto(jmsSendCreateNotificationToCustomerRequestDto)
                .originator(callingContext.getOriginator());

        return integrationBus.inOut(() -> "BANK", "sendNotificationToCustomer", jmsMessage, JmsSendNotificationToCustomerResponseDto.class);
    }

    private void getAndUpdateCustomerID(String accountNumber, TokenInfoDto tokenInfoDto, String panInternalId, String panInternalGuid, String originator, Long messageHistoryId, String correlationId) {
        JmsGetCustomerIDMessageDto getCustomerIDMessageDto = new JmsGetCustomerIDMessageDto();
        getCustomerIDMessageDto.setCardNum(accountNumber);

        HeadersJmsMessage jmsMessage = new GetCustomerIDJmsMessage()
                .getCustomerIdentifier(getCustomerIDMessageDto)
                .originator(originator).messageHistoryId(messageHistoryId);

        JmsGetCustomerIDResponseDto jmsGetCustomerIDResponseDto = new JmsGetCustomerIDResponseDto();
        try {
            jmsGetCustomerIDResponseDto = integrationBus.inOut(jmsMessage::getOriginator, "customerIdentifier", jmsMessage, JmsGetCustomerIDResponseDto.class);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

        /*
         * "0" - OK Success
         * "1" and more - error
         */
        if ("0".equals(jmsGetCustomerIDResponseDto.getCode())) {
            saveTokenInfo(tokenInfoDto, jmsGetCustomerIDResponseDto.getCustomerID(), panInternalId, panInternalGuid, tokenInfoDto.getCustomerPhone(), correlationId);
        } else {
            AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                    .with(AlertLogDto::setEvent, "GET_CUSTOMER_ID_ERROR")
                    .with(AlertLogDto::setOriginator, jmsMessage.getOriginator())
                    .with(AlertLogDto::setData, "Get customer ID error. Code - " + jmsGetCustomerIDResponseDto.getCode() + "; errorMessage - " + jmsGetCustomerIDResponseDto.getErrorMessage() + ".")
                    .with(AlertLogDto::setDate, new Date())
                    .build();
            alertLogService.save(alertLogDto);
            logger.info(alertLogDto.getData());
        }
    }

    private String fillCustomerPhone(TokenInfoDto currentTokenInfoDto, String customerPhone) {
        return StringUtils.isNotBlank(customerPhone)
                ? customerPhone
                : currentTokenInfoDto.getCustomerPhone();
    }

    @Transactional(rollbackFor = InvalidDataAccessApiUsageException.class)
    private void saveTokenInfo(TokenInfoDto tokenInfoDto, String customerId, String panInternalId, String panInternalGuid, String customerPhone, String correlationId){
		if (customerId != null)
			tokenInfoDto.setCustomerId(customerId);
		if (panInternalId != null)
			tokenInfoDto.setPanInternalId(panInternalId);
		if (panInternalGuid != null)
			tokenInfoDto.setPanInternalGuid(panInternalGuid);
		if (customerPhone != null)
			tokenInfoDto.setCustomerPhone(customerPhone);

        if (tokenInfoDto.getTokenStatusUpdate()==null) {
            tokenInfoDto.setTokenStatusUpdate(new Date());
        }

        tokenInfoService.save(tokenInfoDto);

        //todo:  clear all old dependencies
        final String oldId = OLD_PREFIX_ID + correlationId;
        final TokenInfoId oldTokenId = new TokenInfoId(oldId, tokenInfoDto.getId().getTokenRequestorId());

        Optional<CardholderVerificationMethodDto> cvmByTokenRefIdAndRequestorId = cardholderVerificationMethodService.getByTokenRefIdAndRequestorId(tokenInfoDto.getId().getTokenRefId(), tokenInfoDto.getId().getTokenRequestorId());
        Optional<CardholderVerificationMethodDto> cvmByCorrelationId = cardholderVerificationMethodService.getByCorrelationId(correlationId);
        Optional<CardholderVerificationMethodDto> cvm = cvmByTokenRefIdAndRequestorId.isPresent()
                ? cvmByTokenRefIdAndRequestorId
                : cvmByCorrelationId.isPresent()
                    ? cvmByCorrelationId
                    : Optional.empty();

        cvm.ifPresent(cardholderVerificationMethodDto -> cardholderVerificationMethodService.delete(cardholderVerificationMethodDto.getId()));
        deviceInfoService.getOptional(oldId).ifPresent(dto -> deviceInfoService.delete(oldId));
        tokenInfoService.getOptional(oldTokenId).ifPresent(dto -> tokenInfoService.delete(oldTokenId));
    }

    private void getCardInfoShort(JmsCardTokenizedResponseDto responseDto, String pan, String originator, Long messageHistoryId) {
        try {
            JmsGetCardInfoShortMessageDto jmsGetCardInfoShortMessageDto = new JmsGetCardInfoShortMessageDto();
            jmsGetCardInfoShortMessageDto.setPan(pan);

            HeadersJmsMessage getCardInfoShortJmsMessage = new GetCardInfoShortJmsMessage()
                    .cardInfoShortMessageDto(jmsGetCardInfoShortMessageDto)
                    .originator(originator).messageHistoryId(messageHistoryId);
            JmsGetCardInfoShortResponseDto jmsGetCardInfoShortResponseDto = integrationBus.inOut(getCardInfoShortJmsMessage::getOriginator, "getCardInfoShort", getCardInfoShortJmsMessage, JmsGetCardInfoShortResponseDto.class);

            responseDto.setPanInternalId(jmsGetCardInfoShortResponseDto.getCardID());
            responseDto.setPanInternalGUID(jmsGetCardInfoShortResponseDto.getCardGUID());
            responseDto.setCustomerPhone(jmsGetCardInfoShortResponseDto.getPhoneNumber());
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}
