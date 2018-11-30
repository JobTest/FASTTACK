package com.cts.fasttack.bank.client.jms.processor;

import com.cts.fasttack.bank.client.ws.service.SendNotificationToCustomerService;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerResponseDto;
import com.cts.fasttack.jms.dto.SendNotificationToCustomerJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendNotificationToCustomerProcessor extends AbstractCamelProcessor<SendNotificationToCustomerJmsMessage, JmsSendNotificationToCustomerResponseDto> {

    @Autowired
    private SendNotificationToCustomerService sendNotificationToCustomerService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, SendNotificationToCustomerJmsMessage.class, request -> sendNotificationToCustomerService.sendNotificationToCustomer(request.getJmsSendNotificationToCustomerRequestDto()));
    }
}
