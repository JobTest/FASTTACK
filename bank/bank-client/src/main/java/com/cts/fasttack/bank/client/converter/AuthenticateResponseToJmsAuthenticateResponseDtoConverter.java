package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.bank.client.ws.client.AuthenticateResponse;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsAuthenticateResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateResponseToJmsAuthenticateResponseDtoConverter extends AbstractConverter<AuthenticateResponse, JmsAuthenticateResponseDto> {
    @Override
    protected JmsAuthenticateResponseDto generateTarget() {
        return new JmsAuthenticateResponseDto();
    }

    @Override
    protected void lightConvert(AuthenticateResponse source, JmsAuthenticateResponseDto target) {
        target.setAuthenticated(source.isIsAuthenticated().getValue());
    }
}
