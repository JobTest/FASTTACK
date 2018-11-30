package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * JMS message for getting token info.
 *
 * @author v.semerkov
 */
public class TokenInfoJmsMessage extends HeadersJmsMessage {
    private JmsTokenInfoMessageDto tokenInfoMessageDto;

    public JmsTokenInfoMessageDto getTokenInfoMessageDto() {
        return tokenInfoMessageDto;
    }

    public TokenInfoJmsMessage tokenInfoMessageDto(JmsTokenInfoMessageDto tokenInfoMessageDto) {
        this.tokenInfoMessageDto = tokenInfoMessageDto;
        return this;
    }
}
