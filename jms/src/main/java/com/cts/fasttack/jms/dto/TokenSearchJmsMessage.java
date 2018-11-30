package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author Dmitry Koval
 */
public class TokenSearchJmsMessage extends HeadersJmsMessage {

    private JmsTokenSearchRequestDto jmsTokenSearchRequestDto;

    public JmsTokenSearchRequestDto getJmsTokenSearchRequestDto() {
        return jmsTokenSearchRequestDto;
    }

    public TokenSearchJmsMessage jmsTokenSearchRequestDto(JmsTokenSearchRequestDto jmsTokenSearchRequestDto) {
        this.jmsTokenSearchRequestDto = jmsTokenSearchRequestDto;
        return this;
    }
}
