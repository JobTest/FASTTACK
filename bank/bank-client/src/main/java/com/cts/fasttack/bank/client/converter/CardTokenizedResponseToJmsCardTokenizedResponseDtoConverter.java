package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.bank.client.ws.client.CardTokenizedResponse;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsCardTokenizedResponseDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CardTokenizedResponseToJmsCardTokenizedResponseDtoConverter extends AbstractConverter<CardTokenizedResponse, JmsCardTokenizedResponseDto> {
    @Override
    protected JmsCardTokenizedResponseDto generateTarget() {
        return new JmsCardTokenizedResponseDto();
    }

    @Override
    protected void lightConvert(CardTokenizedResponse source, JmsCardTokenizedResponseDto target) {
        target.setRequestId(source.getRequestId().getValue());
        target.setPanInternalId(source.getPanInternalId().getValue());
        target.setPanInternalGUID(source.getPanInternalGUID().getValue());
        target.setCode(source.getCode().getValue());
        Optional.ofNullable(source.getErrorMessage()).ifPresent(e -> target.setErrorMessage(e.getValue()));
        Optional.ofNullable(source.getCustomerPhone()).ifPresent(e -> target.setCustomerPhone(e.getValue()));
        target.setCustomerId(source.getCustomerId().getValue());
        target.setConversationId(source.getConversationId().getValue());
    }
}
