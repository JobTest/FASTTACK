package com.cts.fasttack.bank.server.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.bank.server.dto.TokenInfoResponseDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenInfoResponseDto;

/**
 * {@link JmsTokenInfoResponseDto} to {@link TokenInfoResponseDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class JmsTokenInfoResponseDtoToTokenInfoResponseDtoConverter extends AbstractConverter<JmsTokenInfoResponseDto, TokenInfoResponseDto> {

    @Autowired
    private JmsTokenResponseDtoToTokenResponseDtoConverter jmsTokenResponseDtoToTokenResponseDtoConverter;

    @Override
    protected TokenInfoResponseDto generateTarget() {
        return new TokenInfoResponseDto();
    }

    @Override
    protected void lightConvert(JmsTokenInfoResponseDto source, TokenInfoResponseDto target) {
        target.setTokens(jmsTokenResponseDtoToTokenResponseDtoConverter.convert(source.getTokens()));
        target.setCode(source.getErrorCode());
    }
}
