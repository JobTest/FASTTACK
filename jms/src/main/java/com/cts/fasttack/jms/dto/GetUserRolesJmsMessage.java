package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

public class GetUserRolesJmsMessage extends HeadersJmsMessage {

    private JmsGetUserRolesRequestDto jmsGetUserRolesRequestDto;

    public JmsGetUserRolesRequestDto getJmsGetUserRolesRequestDto() {
        return jmsGetUserRolesRequestDto;
    }

    public GetUserRolesJmsMessage jmsGetUserRolesRequestDto(JmsGetUserRolesRequestDto jmsGetUserRolesRequestDto) {
        this.jmsGetUserRolesRequestDto = jmsGetUserRolesRequestDto;
        return this;
    }
}
