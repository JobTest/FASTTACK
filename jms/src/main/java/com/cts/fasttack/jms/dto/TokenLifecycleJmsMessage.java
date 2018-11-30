package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author Dmitry Koval
 */
public class TokenLifecycleJmsMessage extends HeadersJmsMessage {
    private JmsTokenLifecycleDto jmsTokenLifecycleDto;

    public JmsTokenLifecycleDto getJmsTokenLifecycleDto() {
        return jmsTokenLifecycleDto;
    }

    public TokenLifecycleJmsMessage jmsTokenLifecycleDto(JmsTokenLifecycleDto jmsTokenLifecycleDto) {
        this.jmsTokenLifecycleDto = jmsTokenLifecycleDto;
        return this;
    }
}
