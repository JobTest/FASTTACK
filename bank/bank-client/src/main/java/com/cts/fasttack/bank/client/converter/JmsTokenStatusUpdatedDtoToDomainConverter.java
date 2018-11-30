package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.bank.client.ws.client.ObjectFactory;
import com.cts.fasttack.bank.client.ws.client.TokenStatusUpdated;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenStatusUpdatedDto;
import org.springframework.stereotype.Component;

@Component
public class JmsTokenStatusUpdatedDtoToDomainConverter extends AbstractConverter<JmsTokenStatusUpdatedDto, TokenStatusUpdated> {

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    @Override
    protected TokenStatusUpdated generateTarget() {
        return OBJECT_FACTORY.createTokenStatusUpdated();
    }

    @Override
    protected void lightConvert(JmsTokenStatusUpdatedDto source, TokenStatusUpdated target) {

        target.setRequestId(source.getRequestId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setTokenRefId(source.getTokenRefId());
        target.setStatus(source.getStatus());
        target.setPanInternalId(source.getPanInternalId());
        target.setTokenExpiryMonth(source.getTokenExpiryMonth());
        target.setTokenExpiryYear(source.getTokenExpiryYear());
        target.setIps(source.getIps());
        target.setMessageReasonCode(source.getMessageReasonCode());
        target.setPanInternalGUID(source.getPanInternalGuid());
    }
}
