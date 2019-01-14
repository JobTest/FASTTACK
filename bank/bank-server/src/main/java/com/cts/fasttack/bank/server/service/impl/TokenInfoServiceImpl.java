package com.cts.fasttack.bank.server.service.impl;

import com.cts.fasttack.bank.server.converter.TokenInfoRequestDtoToJmsTokenInfoMessageDtoConverter;
import com.cts.fasttack.bank.server.dto.TokenInfoRequestDto;
import com.cts.fasttack.bank.server.dto.TokenInfoResponseDto;
import com.cts.fasttack.bank.server.service.TokenInfoService;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.JmsTokenInfoResponseDto;
import com.cts.fasttack.jms.dto.TokenInfoJmsMessage;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.service.CallingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("tokenInfoService")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TokenInfoServiceImpl implements TokenInfoService {

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private TokenInfoRequestDtoToJmsTokenInfoMessageDtoConverter tokenInfoRequestDtoToJmsTokenInfoMessageDtoConverter;

    @Override
    public JmsTokenInfoResponseDto tokenInfo(TokenInfoRequestDto request, TokenInfoResponseDto response) throws ServiceException {
        HeadersJmsMessage jmsMessage = new TokenInfoJmsMessage()
                .tokenInfoMessageDto(tokenInfoRequestDtoToJmsTokenInfoMessageDtoConverter.convert(request))
                .originator(callingContext.getOriginator());
        JmsTokenInfoResponseDto jmsTokenInfoResponseDto =  integrationBus.inOut(callingContext.getProcessingArea(), "tokenInfo", jmsMessage, JmsTokenInfoResponseDto.class);

        if (jmsTokenInfoResponseDto.getTokens().isEmpty()) {
            jmsTokenInfoResponseDto.setErrorCode("2");
        }
        if (jmsTokenInfoResponseDto.getErrorCode() == null) {
            jmsTokenInfoResponseDto.setErrorCode("0");
        }
 
        return jmsTokenInfoResponseDto;
    }

}
