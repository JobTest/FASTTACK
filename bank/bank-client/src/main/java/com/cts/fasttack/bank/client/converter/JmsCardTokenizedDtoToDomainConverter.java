package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.bank.client.ws.client.CardTokenized;
import com.cts.fasttack.bank.client.ws.client.ObjectFactory;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsCardTokenizedRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JmsCardTokenizedDtoToDomainConverter extends AbstractConverter<JmsCardTokenizedRequestDto, CardTokenized> {

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    @Value("${spring.client.ws.cardTokenized.useDeviceName:false}")
    private Boolean useDeviceName;

    @Override
    protected CardTokenized generateTarget() {
        return OBJECT_FACTORY.createCardTokenized();
    }

    @Override
    protected void lightConvert(JmsCardTokenizedRequestDto source, CardTokenized target) {

        target.setRequestId(source.getRequestId());
        target.setConversationId(source.getConversationId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setTokenRefId(source.getTokenRefId());
        target.setStatus(source.getStatus());
        target.setPanInternalId(source.getPanInternalId());
        target.setPan(source.getPan());
        target.setExpiryMonth(source.getExpiryMonth());
        target.setExpiryYear(source.getExpiryYear());
        target.setToken(source.getToken());
        target.setTokenExpiryMonth(source.getTokenExpiryMonth());
        target.setTokenExpiryYear(source.getTokenExpiryYear());
        target.setTokenActivationDate(source.getTokenActivationDate().toString());
        target.setIps(source.getIps());
        target.setPanSource(source.getPanSource());
        target.setPaymentAppInstId(source.getPaymentAppInstId());
        target.setDeviceType(source.getDeviceType());
        target.setStorageTechnology(source.getStorageTechnology());
        if(useDeviceName) {
            target.setDeviceName(source.getDeviceName());
        }
    }
}
