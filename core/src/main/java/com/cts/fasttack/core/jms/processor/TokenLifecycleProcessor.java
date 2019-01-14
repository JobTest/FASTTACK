package com.cts.fasttack.core.jms.processor;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.messages.MessageSourceService;
import com.cts.fasttack.core.converter.JmsTokenLifecycleDtoToTokenHistoryConverter;
import com.cts.fasttack.core.converter.TokenLifecycleJmsMessageToIpsConverter;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.FEPropService;
import com.cts.fasttack.core.service.TokenHistoryService;
import com.cts.fasttack.core.service.TokenInfoService;
import com.cts.fasttack.jms.dto.JmsTokenLifecycleDto;
import com.cts.fasttack.jms.dto.TokenLifecycleJmsMessage;
import com.cts.fasttack.jms.dto.TokenLifecycleIpsJmsMessage;
import com.cts.fasttack.jms.dto.TokenLifecycleJmsResponse;
import com.cts.fasttack.jms.dto.TokenLifecycleMdesJmsResponseDto;
import com.cts.fasttack.jms.dto.TokenLifecycleVtsJmsResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenLifecycleProcessor extends AbstractCamelProcessor<TokenLifecycleJmsMessage, TokenLifecycleJmsResponse> {

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private FEPropService fePropService;

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private TokenHistoryService tokenHistoryService;

    @Autowired
    private TokenLifecycleJmsMessageToIpsConverter tokenLifecycleJmsMessageToIpsConverter;

    @Autowired
    private JmsTokenLifecycleDtoToTokenHistoryConverter jmsTokenLifecycleDtoToTokenHistoryConverter;

    @Autowired
    private MessageSourceService messageSourceService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, TokenLifecycleJmsMessage.class, request -> {
            JmsTokenLifecycleDto jmsTokenLifecycleDto = request.getJmsTokenLifecycleDto();
            TokenInfoDto tokenInfoDto = tokenInfoService.get(new TokenInfoId(jmsTokenLifecycleDto.getTokenReferenceID(), jmsTokenLifecycleDto.getTokenRequestorID()));
            Map<String, String> properties = fePropService.getPropertyMapByNameList(Arrays.asList(FEPropService.PROPERTY_ORG_NAME, FEPropService.PROPERTY_CALL_CENTER_AUTOMATED_NUMBER));

            TokenLifecycleJmsResponse response = new TokenLifecycleJmsResponse();
            TokenLifecycleIpsJmsMessage tokenLifecycleIpsJmsMessage = tokenLifecycleJmsMessageToIpsConverter.convert(request, properties);
            if (tokenInfoDto.getIps().isVisa()) {
                TokenLifecycleVtsJmsResponseDto responseDto = integrationBus.inOut(() -> "VTS", "tokenLifecycle", tokenLifecycleIpsJmsMessage, TokenLifecycleVtsJmsResponseDto.class);
                response.setCodeStatus(responseDto.getActionCode());
                response.setErrorCode(responseDto.getErrorCode());
                response.setMessage(messageSourceService.getMessage(responseDto.getErrorCode()));
            } else {
                if (tokenLifecycleIpsJmsMessage.getJmsTokenActivateIpsDto().getTokenRefID().contains("NotYetAssigned")) {
                    tokenLifecycleIpsJmsMessage.getJmsTokenActivateIpsDto().setTokenRefID(null);
                    tokenLifecycleIpsJmsMessage.getJmsTokenActivateIpsDto().setPaymentAppInstanceId(tokenInfoDto.getClientWalletAccountId());
                } else {
                    tokenLifecycleIpsJmsMessage.getJmsTokenActivateIpsDto().setPan(null);
                }
                integrationBus.inOut(() -> "MDES", "tokenLifecycle", tokenLifecycleIpsJmsMessage, TokenLifecycleMdesJmsResponseDto.class);
                response.setCodeStatus("00");
            }
            if (StringUtils.isBlank(response.getMessage()) || "VSE40002".equals(response.getErrorCode())) {
                TokenStatus tokenStatus = TokenStatus.valueOfFirstWord(jmsTokenLifecycleDto.getStatus());
                tokenStatus = tokenStatus.isResume() ? TokenStatus.A : tokenStatus;
                tokenInfoDto.setTokenStatus(tokenStatus);
                tokenInfoDto.setTokenStatusUpdate(new Date());
                tokenInfoService.save(tokenInfoDto);
                tokenHistoryService.save(jmsTokenLifecycleDtoToTokenHistoryConverter.convert(jmsTokenLifecycleDto, String.valueOf(request.getMessageHistoryId()), tokenLifecycleIpsJmsMessage.getJmsTokenActivateIpsDto(), response.getCodeStatus(), tokenStatus, tokenInfoDto.getTokenExpdate()));
            }
            return response;
        });
    }
}
