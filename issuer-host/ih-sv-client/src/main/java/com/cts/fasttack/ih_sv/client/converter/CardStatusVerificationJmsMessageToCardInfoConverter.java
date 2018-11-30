package com.cts.fasttack.ih_sv.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.ih_sv.client.dto.CardInfo;
import com.cts.fasttack.jms.dto.CardStatusVerificationJmsMessage;
import com.cts.fasttack.jms.dto.JmsCardStatusVerificationDto;

/**
 * @author d.ishchenko
 */
@Component
public class CardStatusVerificationJmsMessageToCardInfoConverter extends AbstractConverter<CardStatusVerificationJmsMessage, CardInfo> {

    @Override
    protected CardInfo generateTarget() {
        return new CardInfo();
    }

    @Override
    protected void lightConvert(CardStatusVerificationJmsMessage source, CardInfo target) {
        JmsCardStatusVerificationDto jmsCardStatusVerificationDto = source.getCardStatusVerificationDto();

        target.setPan(jmsCardStatusVerificationDto.getCardNum().toString());
        target.setExpiryMonth(jmsCardStatusVerificationDto.getExpMonth());
        target.setExpiryYear(jmsCardStatusVerificationDto.getExpYear().substring(2));
        target.setCvNum(jmsCardStatusVerificationDto.getCvNum());
    }

}
