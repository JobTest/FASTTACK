package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author Dmitry Koval
 */
public class TokenNotificationJmsMessage extends HeadersJmsMessage {
    private JmsTokenNotificationDto jmsTokenNotificationDto;

    public JmsTokenNotificationDto getJmsTokenNotificationDto() {
        return jmsTokenNotificationDto;
    }

    public TokenNotificationJmsMessage jmsTokenNotificationDto(JmsTokenNotificationDto jmsTokenNotificationDto) {
        this.jmsTokenNotificationDto = jmsTokenNotificationDto;
        return this;
    }
}
