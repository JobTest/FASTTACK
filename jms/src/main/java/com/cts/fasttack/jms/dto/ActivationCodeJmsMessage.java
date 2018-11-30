package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author a.lipavets
 */
public class ActivationCodeJmsMessage extends HeadersJmsMessage {
    private JmsDeliverActivationCodeDto deliverActivationDto;

    public JmsDeliverActivationCodeDto getDeliverActivationDto() {
        return deliverActivationDto;
    }

    public ActivationCodeJmsMessage deliverActivationDto(JmsDeliverActivationCodeDto deliverActivationDto) {
        this.deliverActivationDto = deliverActivationDto;
        return this;
    }
}
