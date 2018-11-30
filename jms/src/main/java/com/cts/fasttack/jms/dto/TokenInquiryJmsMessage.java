package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author a.lipavets
 */
public class TokenInquiryJmsMessage extends HeadersJmsMessage {
    private JmsTokenInquiryDto tokenInquiryRequestDto;

    public JmsTokenInquiryDto getTokenInquiryRequestDto() {
        return tokenInquiryRequestDto;
    }

    public TokenInquiryJmsMessage tokenInquiryRequestDto(JmsTokenInquiryDto tokenInquiryRequestDto) {
        this.tokenInquiryRequestDto = tokenInquiryRequestDto;
        return this;
    }
}
