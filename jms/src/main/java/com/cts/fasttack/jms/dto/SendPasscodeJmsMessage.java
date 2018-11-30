package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author a.lipavets
 */
public class SendPasscodeJmsMessage extends HeadersJmsMessage {
    private JmsSendPasscodeDto sendPasscodeDto;

    public JmsSendPasscodeDto getSendPasscodeDto() {
        return sendPasscodeDto;
    }

    public SendPasscodeJmsMessage sendPasscodeDto(JmsSendPasscodeDto sendPasscodeDto) {
        this.sendPasscodeDto = sendPasscodeDto;
        return this;
    }
}
