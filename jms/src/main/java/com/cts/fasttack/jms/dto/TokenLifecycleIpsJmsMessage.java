package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author Dmitry Koval
 */
public class TokenLifecycleIpsJmsMessage extends HeadersJmsMessage {

    private JmsTokenLifecycleIpsDto jmsTokenActivateIpsDto;

    public JmsTokenLifecycleIpsDto getJmsTokenActivateIpsDto() {
        return jmsTokenActivateIpsDto;
    }

    public TokenLifecycleIpsJmsMessage jmsTokenActivateIpsDto(JmsTokenLifecycleIpsDto jmsTokenActivateIpsDto) {
        this.jmsTokenActivateIpsDto = jmsTokenActivateIpsDto;
        return this;
    }
}
