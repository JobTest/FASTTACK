package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author a.lipavets
 */
public class NotifyTokenUpdatedJmsMessage extends HeadersJmsMessage {
    private JmsNotifyTokenUpdatedDto notifyTokenUpdatedDto;

    public JmsNotifyTokenUpdatedDto getNotifyTokenUpdatedDto() {
        return notifyTokenUpdatedDto;
    }


    public NotifyTokenUpdatedJmsMessage notifyTokenUpdatedDto(JmsNotifyTokenUpdatedDto jmsNotifyTokenUpdatedDto) {
        this.notifyTokenUpdatedDto = jmsNotifyTokenUpdatedDto;
        return this;
    }
}
