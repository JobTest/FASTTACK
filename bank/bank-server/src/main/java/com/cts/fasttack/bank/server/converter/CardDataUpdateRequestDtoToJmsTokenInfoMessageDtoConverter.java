package com.cts.fasttack.bank.server.converter;

import com.cts.fasttack.bank.server.dto.CardDataUpdateRequestDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenInfoMessageDto;
import org.springframework.stereotype.Component;

/**
 * {@link CardDataUpdateRequestDto} to {@link JmsTokenInfoMessageDto} converter.
 */
@Component
public class CardDataUpdateRequestDtoToJmsTokenInfoMessageDtoConverter extends AbstractConverter<CardDataUpdateRequestDto, JmsTokenInfoMessageDto> {

    @Override
    protected JmsTokenInfoMessageDto generateTarget() {
        return new JmsTokenInfoMessageDto();
    }

    @Override
    protected void lightConvert(CardDataUpdateRequestDto source, JmsTokenInfoMessageDto target) {
        target.setRequestId(source.getRequestId());
        target.setTokenRefId(source.getTokenRefId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setPan(source.getNewAccountPan());
        target.setPanInternalId(source.getNewPanInternalId());
        target.setPanInternalGUID(source.getNewPanInternalGUID());
    }
}
