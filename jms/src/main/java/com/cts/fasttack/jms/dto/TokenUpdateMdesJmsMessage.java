package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author Dmitry Koval
 */
public class TokenUpdateMdesJmsMessage extends HeadersJmsMessage {

    private JmsTokenUpdateMdesDto jmsTokenUpdateMdesDto;

    public JmsTokenUpdateMdesDto getJmsTokenUpdateMdesDto() {
        return jmsTokenUpdateMdesDto;
    }

    public TokenUpdateMdesJmsMessage jmsTokenUpdateMdesDto(JmsTokenUpdateMdesDto jmsTokenUpdateMdesDto) {
        this.jmsTokenUpdateMdesDto = jmsTokenUpdateMdesDto;
        return this;
    }
}
