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
        Optional.ofNullable(source.getRequestId()).ifPresent(e -> target.setRequestId(e.getValue()));
        Optional.ofNullable(source.getPanInternalId()).ifPresent(e -> target.setPanInternalId(e.getValue()));
        Optional.ofNullable(source.getPanInternalGUID()).ifPresent(e -> target.setPanInternalGUID(e.getValue()));
        target.setCode(source.getCode().getValue());
        Optional.ofNullable(source.getErrorMessage()).ifPresent(e -> target.setErrorMessage(e.getValue()));
        Optional.ofNullable(source.getCustomerPhone()).ifPresent(e -> target.setCustomerPhone(e.getValue()));
        Optional.ofNullable(source.getCustomerId()).ifPresent(e -> target.setCustomerId(e.getValue()));
        Optional.ofNullable(source.getConversationId()).ifPresent(e -> target.setConversationId(e.getValue()));
    }
}
