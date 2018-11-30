package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author Dmitry Koval
 */
public class CardTokenizedJmsMessage extends HeadersJmsMessage {

    private JmsCardTokenizedRequestDto jmsCardTokenizedDto;

    public JmsCardTokenizedRequestDto getJmsCardTokenizedDto() {
        return jmsCardTokenizedDto;
    }

    public CardTokenizedJmsMessage jmsCardTokenizedDto(JmsCardTokenizedRequestDto jmsCardTokenizedDto) {
        this.jmsCardTokenizedDto = jmsCardTokenizedDto;
        return this;
    }
}
