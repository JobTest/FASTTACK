package com.cts.fasttack.mdes.client.jms.processor;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.jms.dto.TokenUpdateMdesJmsMessage;
import com.cts.fasttack.jms.dto.TokenUpdateMdesJmsResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.mdes.client.converter.JmsTokenUpdateMdesToRequestDtoConverter;
import com.cts.fasttack.mdes.client.converter.TokenUpdateResponseDtoToJmsConverter;
import com.cts.fasttack.mdes.client.rest.MdesRestClient;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenUpdateMdesProcessor extends AbstractCamelProcessor<TokenUpdateMdesJmsMessage, TokenUpdateMdesJmsResponseDto> {

    @Autowired
    private MdesRestClient mdesRestClient;

    @Autowired
    private TokenUpdateResponseDtoToJmsConverter tokenUpdateResponseDtoToJmsConverter;

    @Autowired
    private JmsTokenUpdateMdesToRequestDtoConverter jmsTokenUpdateMdesToRequestDtoConverter;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, TokenUpdateMdesJmsMessage.class,
                request -> tokenUpdateResponseDtoToJmsConverter.convert(
                        mdesRestClient.tokenUpdate(
                                jmsTokenUpdateMdesToRequestDtoConverter.convert(request.getJmsTokenUpdateMdesDto())).getResponseDto()));
    }
}
