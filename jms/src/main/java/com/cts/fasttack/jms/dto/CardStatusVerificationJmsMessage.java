package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * JMS message for card status verification.
 *
 * @author v.semerkov
 */
public class CardStatusVerificationJmsMessage extends HeadersJmsMessage {
    private JmsCardStatusVerificationDto cardStatusVerificationDto;

    public JmsCardStatusVerificationDto getCardStatusVerificationDto() {
        return cardStatusVerificationDto;
    }

    public CardStatusVerificationJmsMessage cardStatusVerificationDto(JmsCardStatusVerificationDto cardStatusVerificationDto) {
        this.cardStatusVerificationDto = cardStatusVerificationDto;
        return this;
    }
}
