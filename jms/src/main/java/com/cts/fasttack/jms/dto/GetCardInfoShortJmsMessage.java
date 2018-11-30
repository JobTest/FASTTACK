package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * JMS message for getting card info.
 *
 * @author v.semerkov
 */
public class GetCardInfoShortJmsMessage extends HeadersJmsMessage {
    private JmsGetCardInfoShortMessageDto cardInfoShortMessageDto;

    public JmsGetCardInfoShortMessageDto getCardInfoShortMessageDto() {
        return cardInfoShortMessageDto;
    }

    public GetCardInfoShortJmsMessage cardInfoShortMessageDto(JmsGetCardInfoShortMessageDto cardInfoShortMessageDto) {
        this.cardInfoShortMessageDto = cardInfoShortMessageDto;
        return this;
    }
}
