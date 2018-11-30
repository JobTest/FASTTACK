package com.cts.fasttack.bank.server.service.impl;

import com.cts.fasttack.bank.server.converter.CardDataUpdateRequestDtoToJmsTokenInfoMessageDtoConverter;
import com.cts.fasttack.bank.server.dto.CardDataUpdateRequestDto;
import com.cts.fasttack.bank.server.dto.CardDataUpdateResponseDto;
import com.cts.fasttack.bank.server.service.CardDataUpdateService;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.JmsCardDataUpdateResponseDto;
import com.cts.fasttack.jms.dto.TokenInfoJmsMessage;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.service.CallingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cardDataUpdateService")
public class CardDataUpdateServiceImpl implements CardDataUpdateService {

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private CardDataUpdateRequestDtoToJmsTokenInfoMessageDtoConverter cardDataUpdateRequestDtoToJmsTokenInfoMessageDtoConverter;

    @Override
    public JmsCardDataUpdateResponseDto cardDataUpdate(CardDataUpdateRequestDto request, CardDataUpdateResponseDto response) throws ServiceException {
        HeadersJmsMessage jmsMessage = new TokenInfoJmsMessage()
                .tokenInfoMessageDto(cardDataUpdateRequestDtoToJmsTokenInfoMessageDtoConverter.convert(request))
                .originator(callingContext.getOriginator());
        JmsCardDataUpdateResponseDto jmsCardDataUpdateResponseDto =  integrationBus.inOut(() -> "CORE", "cardDataUpdate", jmsMessage, JmsCardDataUpdateResponseDto.class);

        return jmsCardDataUpdateResponseDto;
    }

}
