package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.bank.client.ws.client.Authenticate;
import com.cts.fasttack.bank.client.ws.client.ObjectFactory;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsAuthenticateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class JmsAuthenticateDtoToDomainConverter extends AbstractConverter<JmsAuthenticateRequestDto, Authenticate> {

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    @Override
    protected Authenticate generateTarget() {
        return OBJECT_FACTORY.createAuthenticate();
    }

    @Override
    protected void lightConvert(JmsAuthenticateRequestDto source, Authenticate target) {
        target.setUser(source.getUser());
        target.setPassword(source.getPassword());
    }
}
