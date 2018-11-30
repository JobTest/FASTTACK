package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.bank.client.ws.client.TokenStatusUpdatedResponse;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.BankJmsResponseDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TokenStatusUpdatedResponseToBankJmsResponseDtoConverter extends AbstractConverter<TokenStatusUpdatedResponse, BankJmsResponseDto> {
    @Override
    protected BankJmsResponseDto generateTarget() {
        return new BankJmsResponseDto();
    }

    @Override
    protected void lightConvert(TokenStatusUpdatedResponse source, BankJmsResponseDto target) {
        target.setCode(source.getCode().getValue());
        Optional.ofNullable(source.getErrorMessage()).ifPresent(e -> target.setErrorMessage(e.getValue()));
    }
}
