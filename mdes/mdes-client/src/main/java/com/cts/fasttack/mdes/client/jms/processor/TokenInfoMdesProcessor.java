package com.cts.fasttack.mdes.client.jms.processor;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.jms.dto.JmsTokenInfoResponseDto;
import com.cts.fasttack.jms.dto.TokenSearchJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.mdes.client.converter.JmsTokenSearchRequestToTokenSearchRequestDtoConverter;
import com.cts.fasttack.mdes.client.converter.TokenSearchResponseWrapperToJmsTokenInfoResponseDtoConverter;
import com.cts.fasttack.mdes.client.rest.MdesRestClient;

/**
 * Processor for getting token info for VISA.
 *
 * @author v.semerkov
 */
@Component
public class TokenInfoMdesProcessor extends AbstractCamelProcessor<TokenSearchJmsMessage, JmsTokenInfoResponseDto> {

    @Autowired
    private MdesRestClient mdesRestClient;

    @Autowired
    private TokenSearchResponseWrapperToJmsTokenInfoResponseDtoConverter tokenSearchResponseWrapperToJmsTokenInfoResponseDtoConverter;

    @Autowired
    private JmsTokenSearchRequestToTokenSearchRequestDtoConverter jmsTokenSearchRequestToTokenSearchRequestDtoConverter;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, TokenSearchJmsMessage.class,
                request -> tokenSearchResponseWrapperToJmsTokenInfoResponseDtoConverter.convert(
                        mdesRestClient.tokenSearch(jmsTokenSearchRequestToTokenSearchRequestDtoConverter.convert(request.getJmsTokenSearchRequestDto()))
                ));
    }
}
