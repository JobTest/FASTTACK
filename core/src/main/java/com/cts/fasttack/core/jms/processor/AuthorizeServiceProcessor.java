package com.cts.fasttack.core.jms.processor;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.core.service.AuthorizeService;
import com.cts.fasttack.jms.dto.AuthorizeServiceJmsMessage;
import com.cts.fasttack.jms.dto.JmsAuthorizeServiceResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;

/**
 * @author a.lipavets
 */
@Component
public class AuthorizeServiceProcessor extends AbstractCamelProcessor<AuthorizeServiceJmsMessage, JmsAuthorizeServiceResponseDto> {

    @Autowired
    private AuthorizeService authorizeService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, AuthorizeServiceJmsMessage.class, request -> authorizeService.authorize(request.getAuthorizeServiceDto(), request.getMessageHistoryId()));
    }
}
