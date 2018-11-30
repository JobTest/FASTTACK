package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author a.lipavets
 */
public class CardholderVerificationMethodsJmsMessage extends HeadersJmsMessage {
    private JmsCardholderVerificationMethodsDto cardholderVerificationMethodsDto;

    public JmsCardholderVerificationMethodsDto getCardholderVerificationMethodsDto() {
        return cardholderVerificationMethodsDto;
    }

    public CardholderVerificationMethodsJmsMessage cardholderVerificationMethodsDto(JmsCardholderVerificationMethodsDto cardholderVerificationMethodsDto) {
        this.cardholderVerificationMethodsDto = cardholderVerificationMethodsDto;
        return this;
    }
}
