package com.cts.fasttack.core.jms.processor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.dict.TokenEventStatus;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dict.TokenEventSource;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.dto.TokenReasonDto;
import com.cts.fasttack.core.service.FEPropService;
import com.cts.fasttack.core.service.TokenHistoryService;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.core.service.TokenReasonService;
import com.cts.fasttack.jms.dto.BankLifecycleTokenJmsMessage;
import com.cts.fasttack.jms.dto.JmsBankLifecycleTokenDto;
import com.cts.fasttack.jms.dto.JmsLifecycleTokenResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenInfoEventRefDto;
import com.cts.fasttack.jms.dto.JmsTokenLifecycleIpsDto;
import com.cts.fasttack.jms.dto.TokenLifecycleIpsJmsMessage;
import com.cts.fasttack.jms.dto.TokenLifecycleMdesJmsResponseDto;
import com.cts.fasttack.jms.dto.TokenLifecycleVtsJmsResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author a.lipavets
 */
@Component
public class LifecycleTokenProcessor extends AbstractCamelProcessor<BankLifecycleTokenJmsMessage, JmsLifecycleTokenResponseDto> {

    private Logger logger = LogManager.getLogger(LifecycleTokenProcessor.class);

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private FEPropService fePropService;

    @Autowired
    private TokenHistoryService tokenHistoryService;

    @Autowired
    private AlertLogService alertLogService;

    @Autowired
    private TokenReasonService tokenReasonService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, BankLifecycleTokenJmsMessage.class, request -> {
            JmsBankLifecycleTokenDto jmsActivateTokenDto = request.getBankLifecycleTokenDto();
            if(StringUtils.isNotBlank(jmsActivateTokenDto.getPan())){
                if(InternationalPaymentSystem.M.name().equals(jmsActivateTokenDto.getIps())) {
                    return callService(jmsActivateTokenDto, null, request.getOriginator());
                } else {
                    throw new ServiceException(StandardErrorCodes.NO_DATA_FOUND, "ips");
                }
            } else {
                if(StringUtils.isNotBlank(jmsActivateTokenDto.getTokenRefId())) {
                    Optional<TokenInfoDto> tokenOptional = Optional.ofNullable(tokenInfoService.getOptional(new TokenInfoId(jmsActivateTokenDto.getTokenRefId(), jmsActivateTokenDto.getTokenRequestorId()))
                            .orElseThrow(() -> {
                                String alertLogData = "Can't find tokenInfo by tokenRefId "
                                        + jmsActivateTokenDto.getTokenRefId() + " and tokenRequestorId " + jmsActivateTokenDto.getTokenRequestorId();
                                saveAlertLog(request.getOriginator(), alertLogData, "TOKEN_INFO_NOT_EXISTS");
                                return new ServiceException(StandardErrorCodes.NO_DATA_FOUND, "tokens");
                    }));

                    if(TokenStatus.D.equals(tokenOptional.get().getTokenStatus()) && !"Deactivate".equals(jmsActivateTokenDto.getAction())) {
                        throw new ServiceException(StandardErrorCodes.INVALID_TOKEN_STATUS, tokenOptional.get().getTokenStatus().name());
                    }
                    return callService(jmsActivateTokenDto, tokenOptional.get(), request.getOriginator());
                } else {
                    List<TokenInfoDto> tokens = tokenInfoService.listNotDeletedByPanInternalIdOrGUID(jmsActivateTokenDto.getPanInternalId(), jmsActivateTokenDto.getPanInternalGUID());
                    if (CollectionUtils.isEmpty(tokens)){
                        String alertLogData = "Can't find tokenInfo by panInternalId "
                                + jmsActivateTokenDto.getPanInternalId() + " or panInternalGUID " + jmsActivateTokenDto.getPanInternalGUID();
                        saveAlertLog(request.getOriginator(), alertLogData, "TOKEN_INFO_NOT_EXISTS");
                        throw new ServiceException(StandardErrorCodes.NO_DATA_FOUND, "tokens");
                    }
                    JmsLifecycleTokenResponseDto responseDto = new JmsLifecycleTokenResponseDto();
                    for(TokenInfoDto token : tokens){
                        responseDto = callService(jmsActivateTokenDto, token, request.getOriginator());
                        if ("01".equals(responseDto.getCode())) {
                            return responseDto;
                        } else {
                            responseDto.getTokensInfo().addAll(responseDto.getTokensInfo());
                        }
                    }
                    return responseDto;
                }
            }
        });
    }

    private void updateTokenStatus(TokenInfoDto token, TokenStatus status) {
        token.setTokenStatus(status.isResume() ? TokenStatus.A : status);
        token.setTokenStatusUpdate(new Date(new Date().getTime() - 10000)); // this is to avoid setting this date/time ahead of dateTimeOfEvent recorded by VTS
        tokenInfoService.save(token);
    }

    private JmsLifecycleTokenResponseDto callService(JmsBankLifecycleTokenDto source,  TokenInfoDto token, String originator) throws ServiceException {

        JmsLifecycleTokenResponseDto serviceResponse = new JmsLifecycleTokenResponseDto();
        Map<String, String> properties = fePropService.getPropertyMapByNameList(Arrays.asList(FEPropService.PROPERTY_ORG_NAME, FEPropService.PROPERTY_CALL_CENTER_AUTOMATED_NUMBER));

        if(InternationalPaymentSystem.V.name().equals(source.getIps())) {
            TokenLifecycleVtsJmsResponseDto responseDto = integrationBus.inOut(() -> "VTS", "tokenLifecycle", createActivateTokenJmsMessage(source, properties, token), TokenLifecycleVtsJmsResponseDto.class);
            serviceResponse.setCode(responseDto.getActionCode());
            serviceResponse.setErrorMessage(responseDto.getErrorCode());
        } else {
            TokenLifecycleMdesJmsResponseDto mdesResponse = integrationBus.inOut(() -> "MDES", "tokenLifecycle", createActivateTokenJmsMessage(source, properties, token), TokenLifecycleMdesJmsResponseDto.class);
            if(StringUtils.isNotBlank(source.getPan()) && mdesResponse.getToken() != null) {
                List<TokenInfoDto> tokenList = tokenInfoService.listByTokenRefId(mdesResponse.getToken().getTokenUniqueReference());
                if(tokenList.isEmpty()){
                    String alertLogData = "Can't find any tokenInfo by TokenUniqueReference "
                            + mdesResponse.getToken().getTokenUniqueReference();
                    saveAlertLog(originator, alertLogData, "TOKEN_INFO_NOT_EXISTS");
                } else {
                    tokenList.forEach(tokenInfoDto -> {
                        updateTokenStatus(tokenInfoDto, getTokenStatusByTokenAction(source.getAction()));
                    });
                }
                String eventRef = UUID.randomUUID().toString();
                saveTokenHistory(source, mdesResponse.getToken().getTokenUniqueReference(), null, null, eventRef);
                serviceResponse.addTokenInfo(new JmsTokenInfoEventRefDto(source.getTokenRefId(), source.getTokenRequestorId(), eventRef));
            }
        }
        if((StringUtils.isBlank(serviceResponse.getErrorMessage()) || "VSE40002".equals(serviceResponse.getErrorMessage())) && token != null) {
            String eventRef = UUID.randomUUID().toString();
            saveTokenHistory(source, token.getId().getTokenRefId(), token.getId().getTokenRequestorId(), serviceResponse.getCode(), eventRef);
            serviceResponse.addTokenInfo(new JmsTokenInfoEventRefDto(token.getId().getTokenRefId(), token.getId().getTokenRequestorId(), eventRef));
            updateTokenStatus(token, getTokenStatusByTokenAction(source.getAction()));
        }
        return serviceResponse;
    }

    private TokenLifecycleIpsJmsMessage createActivateTokenJmsMessage(JmsBankLifecycleTokenDto source, Map<String, String> properties, TokenInfoDto tokenInfoDto){
        TokenLifecycleIpsJmsMessage tokenLifecycleIpsJmsMessage = new TokenLifecycleIpsJmsMessage();
        JmsTokenLifecycleIpsDto target = new JmsTokenLifecycleIpsDto();

        if(StringUtils.isBlank(source.getTokenRefId()) && tokenInfoDto != null) {
            target.setTokenRefID(tokenInfoDto.getId().getTokenRefId());
            target.setTokenRequestorID(tokenInfoDto.getId().getTokenRequestorId());
        } else {
            target.setTokenRefID(source.getTokenRefId());
            target.setTokenRequestorID(source.getTokenRequestorId());
        }

        target.setOrganization(properties.get(FEPropService.PROPERTY_ORG_NAME));
        target.setMdesReasonCode(source.getReasonCode());
        target.setVtsReasonCode(String.valueOf(getTokenStatusByTokenAction(source.getAction()).getVtsReasonCode()));
        target.setUserId(source.getUserId());
        target.setUsername(source.getUserName());
        target.setComment(source.getCommentText());
        target.setStatus(getEventStatusByTokenAction(source.getAction()));
        target.setPaymentAppInstanceId(source.getPaymentAppInstanceId());
        target.setPan(source.getPan());
        target.setTokenReason(source.getReasonCode());
        target.setActivationCode("000000");
        tokenLifecycleIpsJmsMessage.jmsTokenActivateIpsDto(target);
        return tokenLifecycleIpsJmsMessage;
    }

    private TokenStatus getTokenStatusByTokenAction(String action) {
        switch (action.toUpperCase()){
            case "DEACTIVATE":
                return TokenStatus.D;
            case "SUSPEND":
                return TokenStatus.S;
            case "RESUME":
                return TokenStatus.R;
            default:
                return TokenStatus.A;
        }
    }

    private String getEventStatusByTokenAction(String action) {
        switch (action.toUpperCase()){
            case "DEACTIVATE":
                return TokenEventStatus.DELETE.name();
            case "SUSPEND":
                return TokenEventStatus.SUSPEND.name();
            case "RESUME":
                return TokenEventStatus.RESUME.name();
            default:
                return TokenEventStatus.ACTIVATE.name();
        }
    }

    private void saveTokenHistory(JmsBankLifecycleTokenDto jmsActivateTokenDto, String tokenRefId, String tokenRequestorId, String code, String eventRef){
        Optional<TokenReasonDto> tokenReasonDto = tokenReasonService.getByTokenStatusUpdateAndMdesReason(jmsActivateTokenDto.getAction().toUpperCase(), jmsActivateTokenDto.getReasonCode());
        TokenHistoryDto tokenHistoryDto = GenericBuilder.of(TokenHistoryDto::new)
                .with(TokenHistoryDto::setWprequestId, jmsActivateTokenDto.getRequestId())
                .with(TokenHistoryDto::setTokenRequestorId, tokenRequestorId)
                .with(TokenHistoryDto::setTokenEventType, "TOKEN_STATUS_UPDATED")
                .with(TokenHistoryDto::setTokenEventSource, TokenEventSource.IS.name())
                .with(TokenHistoryDto::setTokenEventDate, new Date())
                .with(TokenHistoryDto::setMessageReasonCode, jmsActivateTokenDto.getAction().toUpperCase())
                .with(TokenHistoryDto::setTokenEventReason, tokenReasonDto.isPresent() ? tokenReasonDto.get().getReason() : null)
                .with(TokenHistoryDto::setMdesReason, jmsActivateTokenDto.getReasonCode())
                .with(TokenHistoryDto::setEventRef, eventRef)
                .with(TokenHistoryDto::setSuccess, !(StringUtils.isNotBlank(code) && code.equals("01")))
                .with(TokenHistoryDto::setTokenRefId, tokenRefId)
                .build();
        tokenHistoryService.save(tokenHistoryDto);
    }

    private void saveAlertLog(String originator, String data, String event) {
        AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                .with(AlertLogDto::setEvent, event)
                .with(AlertLogDto::setOriginator, originator)
                .with(AlertLogDto::setData, data)
                .with(AlertLogDto::setDate, new Date())
                .build();

        alertLogService.save(alertLogDto);
        logger.info(alertLogDto.getData());
    }
}
