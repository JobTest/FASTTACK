package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author Dmitry Koval
 */
public class UpdateTokenJmsMessage extends HeadersJmsMessage {

    private JmsUpdateTokenDto updateTokenDto;

    public JmsUpdateTokenDto getUpdateTokenDto() {
        return updateTokenDto;
    }

    public UpdateTokenJmsMessage updateTokenDto(JmsUpdateTokenDto updateTokenDto) {
        this.updateTokenDto = updateTokenDto;
        return this;
    }
}
