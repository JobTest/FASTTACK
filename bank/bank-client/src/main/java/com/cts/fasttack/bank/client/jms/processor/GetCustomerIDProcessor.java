package com.cts.fasttack.bank.client.jms.processor;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.bank.client.ws.service.GetCustomerIDService;
import com.cts.fasttack.jms.dto.GetCustomerIDJmsMessage;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;

/**
 * Processor for getting customer ID.
 *
 * @author v.semerkov
 */
@Component
public class GetCustomerIDProcessor extends AbstractCamelProcessor<GetCustomerIDJmsMessage, JmsGetCustomerIDResponseDto> {

    @Autowired
    private GetCustomerIDService getCustomerIDService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, GetCustomerIDJmsMessage.class, request -> getCustomerIDService.getCustomerID(request.getCustomerIDMessageDto()));
    }
}
