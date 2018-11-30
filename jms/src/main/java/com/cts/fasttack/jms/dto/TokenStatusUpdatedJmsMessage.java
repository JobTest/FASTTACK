package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author a.lipavets
 */
public class TokenStatusUpdatedJmsMessage extends HeadersJmsMessage {

    private JmsTokenStatusUpdatedDto jmsTokenStatusUpdatedDto;

    public JmsTokenStatusUpdatedDto getJmsTokenStatusUpdatedDto(){
        return jmsTokenStatusUpdatedDto;
    }

    public TokenStatusUpdatedJmsMessage jmsTokenStatusUpdatedDto(JmsTokenStatusUpdatedDto jmsTokenStatusUpdatedDto) {
        this.jmsTokenStatusUpdatedDto = jmsTokenStatusUpdatedDto;
        return this;
    }
}
