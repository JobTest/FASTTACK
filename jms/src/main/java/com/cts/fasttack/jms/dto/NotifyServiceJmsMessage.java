package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author a.lipavets
 */
public class NotifyServiceJmsMessage extends HeadersJmsMessage {
    private JmsNotifyServiceDto notifyServiceDto;

    public JmsNotifyServiceDto getNotifyServiceDto() {
        return notifyServiceDto;
    }

    public NotifyServiceJmsMessage notifyServiceDto(JmsNotifyServiceDto notifyServiceDto) {
        this.notifyServiceDto = notifyServiceDto;
        return this;
    }
}
