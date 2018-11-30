package com.cts.fasttack.bank.client.jms.processor;

import com.cts.fasttack.bank.client.rest.client.BankRestClient;
import com.cts.fasttack.bank.client.rest.client.BankSoapClient;
import com.cts.fasttack.jms.dto.CardTokenizedJmsMessage;
import com.cts.fasttack.jms.dto.JmsCardTokenizedResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardTokenizedProcessor extends AbstractCamelProcessor<CardTokenizedJmsMessage, JmsCardTokenizedResponseDto> {

    @Autowired
    private BankRestClient bankRestClient;

    @Autowired
    private BankSoapClient bankSoapClient;

    @Override
    public void process(Exchange exchange) throws Exception {
        //todo  implementation case to switch between rest or soap method...

        execute(exchange, CardTokenizedJmsMessage.class, request -> bankSoapClient.cardTokenized(request.getJmsCardTokenizedDto()));
    }
}
