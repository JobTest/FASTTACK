package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

public class SendNotificationToCustomerJmsMessage extends HeadersJmsMessage {

    private JmsSendNotificationToCustomerRequestDto jmsSendNotificationToCustomerRequestDto;

    public JmsSendNotificationToCustomerRequestDto getJmsSendNotificationToCustomerRequestDto() {
        return jmsSendNotificationToCustomerRequestDto;
    }

    public SendNotificationToCustomerJmsMessage jmsSendNotificationToCustomerRequestDto(JmsSendNotificationToCustomerRequestDto jmsSendNotificationToCustomerRequestDto) {
        this.jmsSendNotificationToCustomerRequestDto = jmsSendNotificationToCustomerRequestDto;
        return this;
    }
}
