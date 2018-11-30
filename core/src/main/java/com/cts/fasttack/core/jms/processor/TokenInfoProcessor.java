package com.cts.fasttack.core.jms.processor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.core.Constants;
import com.cts.fasttack.core.converter.JmsTokenResponseDtoToTokenInfoDtoConverter;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dict.TokenEventSource;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.BinSetupDto;
import com.cts.fasttack.core.dto.DeviceInfoDto;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.BinSetupService;
import com.cts.fasttack.core.service.DeviceInfoService;
import com.cts.fasttack.core.service.FEPropService;
import com.cts.fasttack.core.service.TokenHistoryService;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.crypto.client.dto.EncryptWithTripleDESCryptoResponseDto;
import com.cts.fasttack.crypto.client.rest.VisaCryptoRestClient;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.GetCardInfoShortJmsMessage;
import com.cts.fasttack.jms.dto.GetCustomerIDJmsMessage;
import com.cts.fasttack.jms.dto.JmsAuditInfoDto;
import com.cts.fasttack.jms.dto.JmsCardholderInformationDto;
import com.cts.fasttack.jms.dto.JmsDeviceResponseDto;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortMessageDto;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortResponseDto;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDMessageDto;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenInfoMessageDto;
import com.cts.fasttack.jms.dto.JmsTokenInfoResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenInquiryDto;
import com.cts.fasttack.jms.dto.JmsTokenResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenSearchRequestDto;
import com.cts.fasttack.jms.dto.TokenInfoJmsMessage;
import com.cts.fasttack.jms.dto.TokenInquiryJmsMessage;
import com.cts.fasttack.jms.dto.TokenSearchJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;

/**
 * Processor for getting token info.
 *
 * @author v.semerkov
 */
@Component
public class TokenInfoProcessor extends AbstractCamelProcessor<TokenInfoJmsMessage, JmsTokenInfoResponseDto> {

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private VisaCryptoRestClient visaCryptoRestClient;

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private DeviceInfoService deviceInfoService;

    @Autowired
    private BinSetupService binSetupService;

    @Autowired
    private TokenHistoryService tokenHistoryService;

    @Autowired
    private FEPropService fePropService;

    @Autowired
    private AlertLogService alertLogService;

    @Autowired
    private JmsTokenResponseDtoToTokenInfoDtoConverter jmsTokenResponseDtoToTokenInfoDtoConverter;

    @Value("${spring.binSetup.defaultSendGetCustomerId}")
    private boolean defaultSendGetCustomerId;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, TokenInfoJmsMessage.class, request -> {
            JmsTokenInfoMessageDto tokenInfoMessageDto = request.getTokenInfoMessageDto();

            List<JmsTokenResponseDto> tokenResponseDtoList = new ArrayList<>();

            if (StringUtils.isNotBlank(tokenInfoMessageDto.getPan())) {
                tokenResponseDtoList.addAll(callService(tokenInfoMessageDto, null, request.getOriginator()));
            } else if (StringUtils.isNotBlank(tokenInfoMessageDto.getTokenRefId()) && StringUtils.isNotBlank(tokenInfoMessageDto.getTokenRequestorId())) {
                Optional<TokenInfoDto> tokenOptional = Optional.ofNullable(tokenInfoService.getOptional(new TokenInfoId(tokenInfoMessageDto.getTokenRefId(), tokenInfoMessageDto.getTokenRequestorId()))
                        .orElseThrow(() -> {
                            String alertLogData = "Can't find tokenInfo by tokenRefId "
                                    + tokenInfoMessageDto.getTokenRefId() + " and tokenRequestorId " + tokenInfoMessageDto.getTokenRequestorId();
                            saveAlertLog(request.getOriginator(), alertLogData, "TOKEN_INFO_NOT_EXISTS");
                            return new ServiceException(StandardErrorCodes.INVALID_FIELD_VALUE, "tokens");
                        }));

                tokenResponseDtoList.addAll(callService(tokenInfoMessageDto, tokenOptional.get(), request.getOriginator()));
            } else {
                List<TokenInfoDto> tokens = tokenInfoService.listByIpsAndPanInternalIdOrGUID(tokenInfoMessageDto.getIps(), tokenInfoMessageDto.getPanInternalId(), tokenInfoMessageDto.getPanInternalGUID());

                for (TokenInfoDto token : tokens) {
                    tokenInfoMessageDto.setTokenRefId(token.getId().getTokenRefId());
                    tokenInfoMessageDto.setTokenRequestorId(token.getId().getTokenRequestorId());
                    tokenResponseDtoList.addAll(callService(tokenInfoMessageDto, token, request.getOriginator()));
                }
            }

            JmsTokenInfoResponseDto responseDto = new JmsTokenInfoResponseDto();
            responseDto.setTokens(tokenResponseDtoList);
            return responseDto;
        });
    }

    private List<JmsTokenResponseDto> callService(JmsTokenInfoMessageDto source, TokenInfoDto token, String originator) throws ServiceException {
        JmsTokenInfoResponseDto response;

        if (InternationalPaymentSystem.V.name().equals(source.getIps())) {
            JmsTokenInquiryDto tokenInquiryDto = prepareTokenInquireRequest(source, token);
            HeadersJmsMessage jmsMessage = new TokenInquiryJmsMessage()
                    .tokenInquiryRequestDto(tokenInquiryDto)
                    .originator(originator);
            response = integrationBus.inOut(() -> "VTS", "tokenInfo", jmsMessage, JmsTokenInfoResponseDto.class);
        } else {
            JmsTokenSearchRequestDto tokenSearchRequestDto = prepareTokenSearchRequest(source, token);
            HeadersJmsMessage jmsMessage = new TokenSearchJmsMessage()
                    .jmsTokenSearchRequestDto(tokenSearchRequestDto)
                    .originator(originator);
            response = integrationBus.inOut(() -> "MDES", "tokenInfo", jmsMessage, JmsTokenInfoResponseDto.class);
        }

        if ("00".equals(response.getActionCode())) {
            for (JmsTokenResponseDto tokenResponseDto : response.getTokens()) {
                TokenInfoId tokenInfoId = new TokenInfoId(tokenResponseDto.getTokenUniqueReference(), tokenResponseDto.getTokenRequestorId());
                TokenInfoDto tokenInfoDto = tokenInfoService.get(tokenInfoId);
                if (tokenInfoDto == null) {
                    /*
                     * Create and save token info based on response
                     */
                    tokenInfoDto = jmsTokenResponseDtoToTokenInfoDtoConverter.convertWithSourceToken(tokenResponseDto, token);
                    tokenInfoDto.setId(tokenInfoId);
                    tokenInfoDto.setIps(InternationalPaymentSystem.getInstance(source.getIps()));

                    TokenInfoDto finalTokenInfoDto = tokenInfoDto;
                    try {
                        CompletableFuture.supplyAsync(() -> {
                            getAndSetCardInfoShort(source, finalTokenInfoDto);
                            return null;
                        }).thenApplyAsync(s -> {
                            getAndSetCustomerIdentifier(source, finalTokenInfoDto);
                            return null;
                        }).get();
                    } catch (Exception e) {
                        log.error("Error while async process confirmProvisioning and verifyCardStatus", e);
                        throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
                    }
                    log.info("Finish working Get Card Info Short and Get Customer Identifier");

                    tokenInfoService.save(tokenInfoDto);

                    /*
                     * Create and save associated with token info device info based on response
                     */
                    JmsDeviceResponseDto deviceResponseDto = tokenResponseDto.getDevice();
                    if (deviceResponseDto != null) {
                        DeviceInfoDto deviceInfoDto = new DeviceInfoDto();
                        deviceInfoDto.setTokenRefId(tokenResponseDto.getTokenUniqueReference());
                        deviceInfoDto.setDeviceName(deviceResponseDto.getDeviceName());

                        deviceInfoService.save(deviceInfoDto);
                    }
                } else {
                    tokenInfoDto.setTokenStatus(TokenStatus.getInstance(tokenResponseDto.getCurrentStatusCode()));
                    tokenInfoDto.setTokenStatusUpdate(tokenResponseDto.getCurrentStatusDateTime());
                    tokenInfoService.save(tokenInfoDto);
                }
                saveTokenHistory(source, tokenResponseDto.getTokenUniqueReference(), tokenResponseDto.getTokenRequestorId());
            }

            return response.getTokens();
        } else {
            String alertLogData = "Can't find tokenInfo for originator '"
                    + originator + "'. Action code: '" + response.getActionCode() + "'.";
            saveAlertLog(originator, alertLogData, "TOKEN_INFO_NOT_EXISTS");
            throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
        }
    }

    /**
     * Prepare JMS token inquire DTO.
     *
     * @param source JMS token info message DTO
     * @param token  token info DTO (can be {@code null})
     * @return JMS token inquire DTO
     * @throws ServiceException
     */
    private JmsTokenInquiryDto prepareTokenInquireRequest(JmsTokenInfoMessageDto source, TokenInfoDto token) throws ServiceException {
        JmsTokenInquiryDto target = new JmsTokenInquiryDto();
        target.setRequestID(source.getRequestId());
        target.setTokenReferenceID(source.getTokenRefId());
        target.setTokenRequestorID(source.getTokenRequestorId());
        if (token != null) {
            target.setPanReferenceID(token.getPanRefId());
        }

        JmsCardholderInformationDto cardholderInformationDto = new JmsCardholderInformationDto();
        if (StringUtils.isNotBlank(source.getPan())) {
            EncryptWithTripleDESCryptoResponseDto encryptResponseDto = visaCryptoRestClient.encryptWith3desAlgorithm("pan=" + source.getPan() + ";");
            cardholderInformationDto.setEncryptionKeyIndex(encryptResponseDto.getEncryptionKeyIndex());
            cardholderInformationDto.setEncryptedData(encryptResponseDto.getEncryptedData());
        }
        target.setCardholderInfo(cardholderInformationDto);

        return target;
    }

    /**
     * Prepare JMS token search request DTO.
     *
     * @param source JMS token info message DTO
     * @param token  token info DTO (can be {@code null})
     * @return JMS token inquire DTO
     * @throws ServiceException
     */
    private JmsTokenSearchRequestDto prepareTokenSearchRequest(JmsTokenInfoMessageDto source, TokenInfoDto token) {
        JmsTokenSearchRequestDto target = new JmsTokenSearchRequestDto();
        target.setAccountPan(source.getPan());
        target.setTokenUniqueReference(source.getTokenRefId());
        target.setPaymentAppInstanceId(source.getPaymentAppInstanceId());
        target.setExcludeDeletedIndicator(false);

        JmsAuditInfoDto auditInfoDto = new JmsAuditInfoDto();
        auditInfoDto.setUserId(source.getUserId());
        auditInfoDto.setUserName(source.getUserName());
        fePropService.getOptional(FEPropService.PROPERTY_ORG_NAME)
                .ifPresent(fePropDto -> auditInfoDto.setOrganization(fePropDto.getPropValue()));
        auditInfoDto.setPhone(token.getCustomerPhone());
        target.setAuditInfo(auditInfoDto);

        return target;
    }

    private void saveTokenHistory(JmsTokenInfoMessageDto jmsTokenInfoMessageDto, String tokenRefId, String tokenRequestorId) {
        TokenHistoryDto tokenHistoryDto = GenericBuilder.of(TokenHistoryDto::new)
                .with(TokenHistoryDto::setWprequestId, jmsTokenInfoMessageDto.getRequestId())
                .with(TokenHistoryDto::setTokenRequestorId, tokenRequestorId)
                .with(TokenHistoryDto::setTokenEventType, "GET_TOKEN_INFO")
                .with(TokenHistoryDto::setTokenEventSource, TokenEventSource.IS.name())
                .with(TokenHistoryDto::setTokenEventDate, new Date())
                .with(TokenHistoryDto::setTokenRefId, tokenRefId)
                .build();
        tokenHistoryService.save(tokenHistoryDto);
    }

    private void getAndSetCardInfoShort(JmsTokenInfoMessageDto source, TokenInfoDto tokenInfoDto) {
        if (StringUtils.isNotBlank(source.getPan())) {
            try {
                JmsGetCardInfoShortMessageDto jmsGetCardInfoShortMessageDto = new JmsGetCardInfoShortMessageDto();
                jmsGetCardInfoShortMessageDto.setPan(source.getPan());
                HeadersJmsMessage getCardInfoShortJmsMessage = new GetCardInfoShortJmsMessage()
                        .cardInfoShortMessageDto(jmsGetCardInfoShortMessageDto)
                        .originator(Constants.ORIGINATOR);
                JmsGetCardInfoShortResponseDto jmsGetCardInfoShortResponseDto = integrationBus.inOut(() -> Constants.ORIGINATOR, "getCardInfoShort", getCardInfoShortJmsMessage, JmsGetCardInfoShortResponseDto.class);
                tokenInfoDto.setPanInternalId(jmsGetCardInfoShortResponseDto.getCardID());
                tokenInfoDto.setPanInternalGuid(jmsGetCardInfoShortResponseDto.getCardGUID());
                tokenInfoDto.setCustomerPhone(jmsGetCardInfoShortResponseDto.getPhoneNumber());
            } catch (ServiceException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void getAndSetCustomerIdentifier(JmsTokenInfoMessageDto source, TokenInfoDto tokenInfoDto) {
        if (StringUtils.isNotBlank(source.getPan())) {
            BinSetupDto binSetupDto = binSetupService.getSuitableBin(source.getPan()).orElse(null);
            boolean sendGetCustomerId = defaultSendGetCustomerId;
            if(binSetupDto != null) {
            	sendGetCustomerId = binSetupDto.isSendGetCustomerId();
            }            
            if (sendGetCustomerId) {
                try {
                    JmsGetCustomerIDMessageDto getCustomerIDMessageDto = new JmsGetCustomerIDMessageDto();
                    getCustomerIDMessageDto.setCardID(source.getPanInternalId());
                    getCustomerIDMessageDto.setCardNum(source.getPan());
                    getCustomerIDMessageDto.setCardGUID(source.getPanInternalGUID());
                    HeadersJmsMessage jmsMessage = new GetCustomerIDJmsMessage()
                            .getCustomerIdentifier(getCustomerIDMessageDto)
                            .originator(Constants.ORIGINATOR);
                    JmsGetCustomerIDResponseDto jmsGetCustomerIDResponseDto = integrationBus.inOut(() -> Constants.ORIGINATOR, "customerIdentifier", jmsMessage, JmsGetCustomerIDResponseDto.class);
                    tokenInfoDto.setCustomerId(jmsGetCustomerIDResponseDto.getCustomerID());
                } catch (ServiceException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void saveAlertLog(String originator, String data, String event) {
        AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                .with(AlertLogDto::setEvent, event)
                .with(AlertLogDto::setOriginator, originator)
                .with(AlertLogDto::setData, data)
                .with(AlertLogDto::setDate, new Date())
                .build();

        alertLogService.save(alertLogDto);
        log.info(alertLogDto.getData());
    }
}
