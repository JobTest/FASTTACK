package com.cts.fasttack.bank.client.jms.processor;

import com.cts.fasttack.bank.client.rest.client.BankRestClient;
import com.cts.fasttack.bank.client.rest.client.BankSoapClient;
import com.cts.fasttack.jms.dto.BankJmsResponseDto;
import com.cts.fasttack.jms.dto.TokenStatusUpdatedJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class NotifyTokenUpdatedBankClientProcessor extends AbstractCamelProcessor<TokenStatusUpdatedJmsMessage, BankJmsResponseDto> {

    @Autowired
    private BankRestClient bankRestClient;

    @Autowired
    private BankSoapClient bankSoapClient;

    @Override
    public void process(Exchange exchange) throws Exception {
        //todo  implementation case to switch between rest or soap method...

        execute(exchange, TokenStatusUpdatedJmsMessage.class, request -> {
            bankSoapClient.tokenStatusUpdated(request.getJmsTokenStatusUpdatedDto());
            return new BankJmsResponseDto();
        });
    }
}
