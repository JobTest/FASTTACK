package com.cts.fasttack.bank.server.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.bank.server.dto.TokenResponseDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenResponseDto;

/**
 * {@link JmsTokenResponseDto} to {@link TokenResponseDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class JmsTokenResponseDtoToTokenResponseDtoConverter extends AbstractConverter<JmsTokenResponseDto, TokenResponseDto> {

    @Autowired
    private JmsDeviceResponseDtoToDeviceResponseDtoConverter jmsDeviceResponseDtoToDeviceResponseDtoConverter;

    @Override
    protected TokenResponseDto generateTarget() {
        return new TokenResponseDto();
    }

    @Override
    protected void lightConvert(JmsTokenResponseDto source, TokenResponseDto target) {
        target.setAccountPanSuffix(source.getAccountPanSuffix());
        target.setPanExpirationDate(source.getPanExpirationDate());
        target.setTokenUniqueReference(source.getTokenUniqueReference());
        target.setTokenSuffix(source.getTokenSuffix());
        target.setTokenExpirationDate(source.getTokenExpirationDate());
        target.setCorrelationId(source.getCorrelationId());
        target.setCurrentStatusCode(source.getCurrentStatusCode());
        target.setCurrentStatusDescription(source.getCurrentStatusDescription());
        target.setCurrentStatusDateTime(source.getCurrentStatusDateTime());
        target.setDigitizationRequestDateTime(source.getDigitizationRequestDateTime());
        target.setLastCommentId(source.getLastCommentId());
        target.setPaymentAppInstanceId(source.getPaymentAppInstanceId());
        target.setProvisioningStatusCode(source.getProvisioningStatusCode());
        target.setStorageTechnology(source.getStorageTechnology());
        target.setTokenActivatedDateTime(source.getTokenActivatedDateTime());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setTokenRequestorName(source.getTokenRequestorName());
        target.setTokenType(source.getTokenType());
        target.setDevice(jmsDeviceResponseDtoToDeviceResponseDtoConverter.convert(source.getDevice()));
    }
}
