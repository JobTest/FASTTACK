package com.cts.fasttack.bank.client.jms.processor;

import com.cts.fasttack.bank.client.ws.service.AuthenticateService;
import com.cts.fasttack.jms.dto.AuthenticateJmsMessage;
import com.cts.fasttack.jms.dto.JmsAuthenticateResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateProcessor extends AbstractCamelProcessor<AuthenticateJmsMessage, JmsAuthenticateResponseDto> {

    @Autowired
    private AuthenticateService authenticateService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, AuthenticateJmsMessage.class, request -> authenticateService.authenticate(request.getJmsAuthenticateRequestDto()));
    }
}
