package com.cts.fasttack.bank.server.converter;

import com.cts.fasttack.bank.server.dto.CardDataUpdateResponseDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsCardDataUpdateResponseDto;
import org.springframework.stereotype.Component;

/**
 * {@link JmsCardDataUpdateResponseDto} to {@link CardDataUpdateResponseDto} converter.
 */
@Component
public class JmsCardDataUpdateResponseDtoToCardDataUpdateResponseDtoConverter extends AbstractConverter<JmsCardDataUpdateResponseDto, CardDataUpdateResponseDto> {

    @Override
    protected CardDataUpdateResponseDto generateTarget() {
        return new CardDataUpdateResponseDto();
    }

    @Override
    protected void lightConvert(JmsCardDataUpdateResponseDto source, CardDataUpdateResponseDto target) {

        target.setRequestId(source.getRequestId());
        target.setCode(source.getCode());
        target.setErrorMessage(source.getErrorMessage());
    }
}
