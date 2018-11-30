package com.cts.fasttack.admin.web.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.fasttack.admin.web.config.AdminWebApplication;
import com.cts.fasttack.admin.web.converter.JmsTokenInfoEventRefToTokenCommentConverter;
import com.cts.fasttack.admin.web.converter.TokenChangeStatusDtoToTokenCommentConverter;
import com.cts.fasttack.admin.web.converter.TokenUpdateDtoToTokenCommentConverter;
import com.cts.fasttack.admin.web.converter.TokensChangeStatusToJmsBankLifecycleDtoConverter;
import com.cts.fasttack.admin.web.converter.TokensUpdateToJmsMessageConverter;
import com.cts.fasttack.admin.web.data.dto.TokenChangeStatusDto;
import com.cts.fasttack.admin.web.data.dto.TokenReasonDto;
import com.cts.fasttack.admin.web.data.dto.TokenUpdateDto;
import com.cts.fasttack.admin.web.data.dto.TokensChangeStatusDto;
import com.cts.fasttack.admin.web.data.dto.TokensUpdateDto;
import com.cts.fasttack.admin.web.rest.TokenReasonRestClient;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;
import com.cts.fasttack.admin.web.service.TokenCommentService;
import com.cts.fasttack.admin.web.service.TokenService;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.messages.MessageSourceService;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.BankLifecycleTokenJmsMessage;
import com.cts.fasttack.jms.dto.JmsLifecycleTokenResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenLifecycleDto;
import com.cts.fasttack.jms.dto.JmsUpdateTokenDto;
import com.cts.fasttack.jms.dto.TokenLifecycleJmsMessage;
import com.cts.fasttack.jms.dto.TokenLifecycleJmsResponse;
import com.cts.fasttack.jms.dto.UpdateTokenJmsMessage;
import com.cts.fasttack.jms.dto.UpdateTokenJmsResponse;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.interceptor.ChangeLoggable;

/**
 * @author Dmitry Koval
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSourceService messageSourceService;

    @Autowired
    private TokenReasonRestClient tokenReasonRestClient;

    @Autowired
    private TokenCommentService tokenCommentService;

    @Autowired
    private TokenChangeStatusDtoToTokenCommentConverter tokenChangeStatusDtoToTokenCommentConverter;

    @Autowired
    private TokenUpdateDtoToTokenCommentConverter tokenUpdateDtoToTokenCommentConverter;

    @Autowired
    private TokensChangeStatusToJmsBankLifecycleDtoConverter tokensChangeStatusToJmsBankLifecycleDtoConverter;

    @Autowired
    private TokensUpdateToJmsMessageConverter tokensUpdateToJmsMessageConverter;

    @Autowired
    private JmsTokenInfoEventRefToTokenCommentConverter jmsTokenInfoEventRefToTokenCommentConverter;

    @Override
    @ChangeLoggable(itemId = "#tokenChangeStatusDto.tokenRefId", itemType = TokenService.TOKEN_LIFECYCLE, fields = {"#tokenChangeStatusDto.tokenRequestorId", "#tokenChangeStatusDto.comment", "#tokenChangeStatusDto.tokenReason", "#tokenChangeStatusDto.tokenEventStatus"})
    public TokenLifecycleJmsResponse tokenLifecycle(TokenChangeStatusDto tokenChangeStatusDto) throws ServiceException {
        try {
            tokenChangeStatusDto.setEventRef(UUID.randomUUID().toString());
            TokenLifecycleJmsResponse response = integrationBus.inOut(() -> "CORE", "tokenLifecycle", tokenLifecycleJmsMessage(tokenChangeStatusDto), TokenLifecycleJmsResponse.class);
            if (response.getCodeStatus().equals("00")) {
                tokenCommentService.save(tokenChangeStatusDtoToTokenCommentConverter.convert(tokenChangeStatusDto));
            }
            return response;
        } catch (ServiceException e) {
            TokenLifecycleJmsResponse response = new TokenLifecycleJmsResponse();
            response.setCodeStatus("01");
            response.setMessage(messageSourceService.getMessage("admin." + e.getErrorCode().name()));
            return response;
        }
    }

    @Override
    @ChangeLoggable(action = TokenService.TOKEN_LIFECYCLE, itemType = TokenService.TOKEN_LIFECYCLE, itemId = "#tokensChangeStatusDto.getTokens().get(0).getPanInternalId() != null ? #tokensChangeStatusDto.getTokens().get(0).getPanInternalId() : null", fields = {"#tokensChangeStatusDto.getTokens().get(0).getPanInternalGuid() != null ? #tokensChangeStatusDto.getTokens().get(0).getPanInternalGuid() : null"})
    public JmsLifecycleTokenResponseDto confirmTokenLifecycle(TokensChangeStatusDto tokensChangeStatusDto) throws ServiceException {
        HeadersJmsMessage jmsMessage = new BankLifecycleTokenJmsMessage()
                .activateTokenDto(tokensChangeStatusToJmsBankLifecycleDtoConverter.convert(tokensChangeStatusDto));
        JmsLifecycleTokenResponseDto response = integrationBus.inOut(() -> "BANK", "lifecycleToken", jmsMessage, JmsLifecycleTokenResponseDto.class);
        if ("0".equals(response.getCode()) && !response.getTokensInfo().isEmpty()) {
            response.getTokensInfo().forEach(item -> tokenCommentService.save(jmsTokenInfoEventRefToTokenCommentConverter.convert(item, tokensChangeStatusDto.getComment())));
        }
        return response;
    }

    @Override
    @ChangeLoggable(action = TokenCommentService.TOKEN_COMMENT, itemType = TokenCommentService.TOKEN_COMMENT, itemId = "#tokensUpdateDto.getTokens().get(0).getPanInternalId()",
            fields = {"#tokensUpdateDto.getTokens().get(0).getPanInternalGuid()", "#tokensUpdateDto.tokenReason", "#tokensUpdateDto.comment"})
    public UpdateTokenJmsResponse tokensUpdate(TokensUpdateDto tokensUpdateDto) throws ServiceException {
        HeadersJmsMessage jmsMessage = new UpdateTokenJmsMessage()
                .updateTokenDto(tokensUpdateToJmsMessageConverter.convert(tokensUpdateDto));
        UpdateTokenJmsResponse response = integrationBus.inOut(() -> "CORE", "updateToken", jmsMessage, UpdateTokenJmsResponse.class);
        if (response.getCodeStatus().equals("00") && !response.getTokensInfo().isEmpty()) {
            response.getTokensInfo().forEach(item -> tokenCommentService.save(jmsTokenInfoEventRefToTokenCommentConverter.convert(item, tokensUpdateDto.getComment())));
        }
        return response;
    }

    private TokenLifecycleJmsMessage tokenLifecycleJmsMessage(TokenChangeStatusDto tokenInfoDto) throws ServiceException {
        TokenLifecycleJmsMessage tokenActivateJmsMessage = new TokenLifecycleJmsMessage();
        JmsTokenLifecycleDto tokenLifecycleDto = new JmsTokenLifecycleDto();
        tokenLifecycleDto.setTokenReferenceID(tokenInfoDto.getTokenRefId());
        tokenLifecycleDto.setTokenRequestorID(tokenInfoDto.getTokenRequestorId());
        tokenLifecycleDto.setStatus(tokenInfoDto.getTokenEventStatus().name());
        tokenLifecycleDto.setComment(tokenInfoDto.getComment());
        UserAuthoritiesDto user = userService.getCurrentUser();
        tokenLifecycleDto.setUserId(user.getUsername());
        tokenLifecycleDto.setUsername(user.getName());
        TokenReasonDto reason = tokenReasonRestClient.get(Long.valueOf(tokenInfoDto.getTokenReason()));
        tokenLifecycleDto.setTokenReason(reason.getReason());
        tokenLifecycleDto.setMdesReason(reason.getMdesReason());
        tokenLifecycleDto.setTokenStatusUpdateReason(reason.getTokenStatusUpdateReason().name());
        tokenLifecycleDto.setEventRef(tokenInfoDto.getEventRef());
        tokenActivateJmsMessage.jmsTokenLifecycleDto(tokenLifecycleDto);
        return tokenActivateJmsMessage;
    }

    @Override
    @ChangeLoggable(itemId = "#tokenUpdateDto.tokenRefId", itemType = "TOKEN_UPDATE", fields = {"#tokenUpdateDto.tokenRequestorId", "#tokenUpdateDto.tokenReason"})
    public UpdateTokenJmsResponse tokenUpdate(TokenUpdateDto tokenUpdateDto) throws ServiceException {
        try {
            UpdateTokenJmsResponse response = integrationBus.inOut(() -> "CORE", "updateToken", createUpdateTokenJmsMessage(tokenUpdateDto), UpdateTokenJmsResponse.class);
            if (response.getCodeStatus().equals("00")) {
                tokenCommentService.save(tokenUpdateDtoToTokenCommentConverter.convert(tokenUpdateDto, null));
            }
            return response;
        } catch (ServiceException e) {
            UpdateTokenJmsResponse response = new UpdateTokenJmsResponse();
            response.setCodeStatus("01");
            response.setMessage(messageSourceService.getMessage("admin." + e.getErrorCode().name()));
            return response;
        }
    }

    private UpdateTokenJmsMessage createUpdateTokenJmsMessage(TokenUpdateDto source) throws ServiceException {
        JmsUpdateTokenDto jmsDto = new JmsUpdateTokenDto();
        jmsDto.setComment(source.getComment());
        jmsDto.setNewExpDate(source.getNewExpDate());
        jmsDto.setNewPan(source.getNewPan());
        TokenReasonDto tokenReasonDto = tokenReasonRestClient.get(Long.valueOf(source.getTokenReason()));
        jmsDto.setTokenReason(tokenReasonDto.getReason());
        jmsDto.setTokenRefId(source.getTokenRefId());
        jmsDto.setTokenRequestorId(source.getTokenRequestorId());
        UserAuthoritiesDto user = userService.getCurrentUser();
        jmsDto.setUserId(user.getUsername());
        jmsDto.setUsername(user.getName());
        jmsDto.setUpdateWalletProviderIndicator(source.isUpdateWalletProviderIndicator() ? "1" : "0");

        jmsDto.setSkipOldPan(true);

        UpdateTokenJmsMessage message = new UpdateTokenJmsMessage();
        message.updateTokenDto(jmsDto);
        message.originator(AdminWebApplication.ORIGINATOR);
        return message;
    }
}

