package com.cts.fasttack.core.jms.processor;

import java.util.Date;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.core.Constants;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dict.TokenEventSource;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.TokenHistoryService;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.jms.dto.JmsTokenDetailsDto;
import com.cts.fasttack.jms.dto.JmsTokenInquiryDto;
import com.cts.fasttack.jms.dto.JmsTokenInquiryResponseDto;
import com.cts.fasttack.jms.dto.TokenInquiryJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;

/**
 * @author a.lipavets
 */
@Component
public class TokenInquiryProcessor extends AbstractCamelProcessor<TokenInquiryJmsMessage, JmsTokenInquiryResponseDto> {

    private Logger logger = LogManager.getLogger(TokenInquiryProcessor.class);

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private AlertLogService alertLogService;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private TokenHistoryService tokenHistoryService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, TokenInquiryJmsMessage.class, request ->{
            JmsTokenInquiryDto tokenInquiryRequestDto = request.getTokenInquiryRequestDto();

            Optional<TokenInfoDto> tokenOptional = getTokenInfoOrSaveAlert(tokenInquiryRequestDto.getTokenReferenceID(), tokenInquiryRequestDto.getTokenRequestorID(), request.getOriginator());

            if(tokenOptional.get().getIps().isVisa()) {
                JmsTokenInquiryResponseDto response = integrationBus.inOut(() -> "VTS", "tokenInquiry", request, JmsTokenInquiryResponseDto.class);
                for(JmsTokenDetailsDto tokenDetailsDto : response.getTokenDetails()) {
                    Optional<TokenInfoDto> responseToken = getTokenInfoOrSaveAlert(tokenDetailsDto.getTokenReferenceID(), tokenDetailsDto.getTokenRequestorID(), Constants.ORIGINATOR);
                    if(!responseToken.get().getTokenStatus().name().equals(tokenDetailsDto.getTokenState())) {
                        saveTokenHistory(tokenInquiryRequestDto.getRequestID(), responseToken.get(), response.getActionCode());
                        tokenUpdateStatusAndSave(responseToken.get(), TokenStatus.getInstance(tokenDetailsDto.getTokenState()));
                    }
                }
                return response;
            }
            return null;
        });
    }

    private Optional<TokenInfoDto> getTokenInfoOrSaveAlert(String tokenRefId, String tokenRequestorId, String originator) throws ServiceException {
        return Optional.ofNullable(tokenInfoService.getOptional(new TokenInfoId(tokenRefId, tokenRequestorId))
                .orElseThrow(() -> {
                    AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                            .with(AlertLogDto::setEvent, "TOKEN_INFO_NOT_EXISTS")
                            .with(AlertLogDto::setOriginator, originator)
                            .with(AlertLogDto::setData, "Can't find tokenInfo by tokenRefId "
                                    + tokenRefId + " and tokenRequestorId " + tokenRequestorId)
                            .with(AlertLogDto::setDate, new Date())
                            .build();

                    alertLogService.save(alertLogDto);
                    logger.info(alertLogDto.getData());
                    return new ServiceException(StandardErrorCodes.INVALID_FIELD_VALUE, "tokens");
                }));
    }

    private void saveTokenHistory(String requestId, TokenInfoDto token, String actionCode){
        TokenHistoryDto tokenHistoryDto = GenericBuilder.of(TokenHistoryDto::new)
                .with(TokenHistoryDto::setWprequestId, requestId)
                .with(TokenHistoryDto::setTokenRequestorId, token.getId().getTokenRequestorId())
                .with(TokenHistoryDto::setTokenRefId, token.getId().getTokenRefId())
                .with(TokenHistoryDto::setTokenEventType, "TOKEN_STATUS_UPDATED")
                .with(TokenHistoryDto::setTokenEventSource, TokenEventSource.IS.name())
                .with(TokenHistoryDto::setTokenEventDate, new Date())
                .with(TokenHistoryDto::setSuccess, "00".equals(actionCode))
                .build();
        tokenHistoryService.save(tokenHistoryDto);
    }

    private void tokenUpdateStatusAndSave(TokenInfoDto token, TokenStatus status){
        token.setTokenStatus(status);
        tokenInfoService.save(token);
    }
}
