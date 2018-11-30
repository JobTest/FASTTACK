package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.bank.client.ws.client.SendOTPResponse;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.BankJmsResponseDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author a.lipavets
 */
@Component
public class SendOtpResponseToDtoConverter extends AbstractConverter<SendOTPResponse, BankJmsResponseDto> {
    @Override
    protected BankJmsResponseDto generateTarget() {
        return new BankJmsResponseDto();
    }

    @Override
    protected void lightConvert(SendOTPResponse source, BankJmsResponseDto target) {
        target.setCode(source.getCode().getValue());
        Optional.ofNullable(source.getErrorMessage()).ifPresent(e -> target.setErrorMessage(e.getValue()));
    }
}
