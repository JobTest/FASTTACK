package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author a.lipavets
 */
public class AuthorizeServiceJmsMessage extends HeadersJmsMessage{

    private JmsAuthorizeServiceDto authorizeServiceDto;

    public JmsAuthorizeServiceDto getAuthorizeServiceDto() {
        return authorizeServiceDto;
    }

    public AuthorizeServiceJmsMessage authorizeServiceDto(JmsAuthorizeServiceDto authorizeServiceDto) {
        this.authorizeServiceDto = authorizeServiceDto;
        return this;
    }

}
