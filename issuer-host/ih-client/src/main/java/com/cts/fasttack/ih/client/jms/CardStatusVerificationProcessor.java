package com.cts.fasttack.ih.client.jms;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.jms.dto.JmsCardStatusVerificationResponseDto;
import com.cts.fasttack.ih.client.service.AccountStatusVerificationService;
import com.cts.fasttack.jms.dto.CardStatusVerificationJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;

/**
 * Processor for card status verification.
 *
 * @author v.semerkov
 */
@Component
public class CardStatusVerificationProcessor extends AbstractCamelProcessor<CardStatusVerificationJmsMessage, JmsCardStatusVerificationResponseDto> {

    @Autowired
    private AccountStatusVerificationService accountStatusVerificationService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, CardStatusVerificationJmsMessage.class, request -> accountStatusVerificationService.verify(request));
    }
}
