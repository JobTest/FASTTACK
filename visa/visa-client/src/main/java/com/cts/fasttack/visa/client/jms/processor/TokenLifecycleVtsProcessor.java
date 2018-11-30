package com.cts.fasttack.visa.client.jms.processor;

import com.cts.fasttack.jms.dto.TokenLifecycleIpsJmsMessage;
import com.cts.fasttack.jms.dto.TokenLifecycleVtsJmsResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.visa.client.converter.TokenVtsLifecycleJmsMessageToRequestDtoConverter;
import com.cts.fasttack.visa.client.converter.TokenVtsLifecycleResponseToJmsDtoConverter;
import com.cts.fasttack.visa.client.service.VisaRestClient;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenLifecycleVtsProcessor extends AbstractCamelProcessor<TokenLifecycleIpsJmsMessage, TokenLifecycleVtsJmsResponseDto> {

    @Autowired
    private VisaRestClient visaRestClient;

    @Autowired
    private TokenVtsLifecycleResponseToJmsDtoConverter tokenVtsLifecycleResponseToJmsDtoConverter;

    @Autowired
    private TokenVtsLifecycleJmsMessageToRequestDtoConverter tokenVtsLifecycleJmsMessageToRequestDtoConverter;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, TokenLifecycleIpsJmsMessage.class,
                request -> tokenVtsLifecycleResponseToJmsDtoConverter.convert(visaRestClient.tokenLifecycle(tokenVtsLifecycleJmsMessageToRequestDtoConverter.convert(request))));
    }
}
