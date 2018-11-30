package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author a.lipavets
 */
public class SendOtpJmsMessage extends HeadersJmsMessage {
    private JmsSendOtpDto sendOtpDto;

    public JmsSendOtpDto getSendOtpDto(){
        return sendOtpDto;
    }

    public SendOtpJmsMessage sendOtpDto(JmsSendOtpDto sendOtpDto) {
        this.sendOtpDto = sendOtpDto;
        return this;
    }

}
