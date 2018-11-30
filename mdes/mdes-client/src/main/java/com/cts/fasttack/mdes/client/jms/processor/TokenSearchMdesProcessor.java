package com.cts.fasttack.mdes.client.jms.processor;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.jms.dto.TokenSearchJmsMessage;
import com.cts.fasttack.jms.dto.TokenSearchResponseWrapper;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.mdes.client.converter.JmsTokenSearchRequestToTokenSearchRequestDtoConverter;
import com.cts.fasttack.mdes.client.rest.MdesRestClient;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenSearchMdesProcessor extends AbstractCamelProcessor<TokenSearchJmsMessage, TokenSearchResponseWrapper> {

    @Autowired
    private MdesRestClient mdesRestClient;

    @Autowired
    private JmsTokenSearchRequestToTokenSearchRequestDtoConverter jmsTokenSearchRequestToTokenSearchRequestDtoConverter;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, TokenSearchJmsMessage.class,
                request -> mdesRestClient.tokenSearch(jmsTokenSearchRequestToTokenSearchRequestDtoConverter.convert(request.getJmsTokenSearchRequestDto())));
    }
}
