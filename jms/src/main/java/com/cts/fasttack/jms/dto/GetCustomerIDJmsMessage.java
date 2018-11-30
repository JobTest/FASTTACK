package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * JMS message for getting customer ID.
 *
 * @author v.semerkov
 */
public class GetCustomerIDJmsMessage extends HeadersJmsMessage {
    private JmsGetCustomerIDMessageDto customerIDMessageDto;

    public JmsGetCustomerIDMessageDto getCustomerIDMessageDto() {
        return customerIDMessageDto;
    }

    public GetCustomerIDJmsMessage getCustomerIdentifier(JmsGetCustomerIDMessageDto getCustomerIDMessageDto) {
        this.customerIDMessageDto = getCustomerIDMessageDto;
        return this;
    }
}
