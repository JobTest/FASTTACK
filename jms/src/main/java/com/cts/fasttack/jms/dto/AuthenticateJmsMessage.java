package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

public class AuthenticateJmsMessage extends HeadersJmsMessage {

    private JmsAuthenticateRequestDto jmsAuthenticateRequestDto;

    public JmsAuthenticateRequestDto getJmsAuthenticateRequestDto() {
        return jmsAuthenticateRequestDto;
    }

    public AuthenticateJmsMessage jmsAuthenticateRequestDto(JmsAuthenticateRequestDto jmsAuthenticateRequestDto) {
        this.jmsAuthenticateRequestDto = jmsAuthenticateRequestDto;
        return this;
    }
}
