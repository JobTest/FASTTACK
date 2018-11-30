package com.cts.fasttack.visa.client.jms.processor;

import com.cts.fasttack.jms.dto.JmsTokenInquiryResponseDto;
import com.cts.fasttack.jms.dto.TokenInquiryJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.visa.client.converter.TokenInquiryJmsToRequestDtoConverter;
import com.cts.fasttack.visa.client.converter.TokenInquiryResponseToJmsDtoConverter;
import com.cts.fasttack.visa.client.service.VisaRestClient;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class TokenInquiryVtsProcessor extends AbstractCamelProcessor<TokenInquiryJmsMessage, JmsTokenInquiryResponseDto> {

    @Autowired
    private VisaRestClient visaRestClient;

    @Autowired
    private TokenInquiryJmsToRequestDtoConverter tokenInquiryJmsToRequestDtoConverter;

    @Autowired
    private TokenInquiryResponseToJmsDtoConverter tokenInquiryResponseToJmsDtoConverter;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, TokenInquiryJmsMessage.class,
                request -> tokenInquiryResponseToJmsDtoConverter.convert(visaRestClient.tokenInquiry(
                        tokenInquiryJmsToRequestDtoConverter.convert(request.getTokenInquiryRequestDto()))));
    }
}
