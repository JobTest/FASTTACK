package com.cts.fasttack.bank.server.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.fasttack.bank.server.dict.StorageTechnology;
import com.cts.fasttack.bank.server.dict.TokenProtectionMethod;
import com.cts.fasttack.bank.server.dto.TokenResponseDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenResponseDto;

/**
 * {@link JmsTokenResponseDto} to {@link TokenResponseDto} converter.
 *
 * @author v.semerkov
 * @author d.ishchenko
 */
@Component
public class JmsTokenResponseDtoToTokenResponseDtoConverter
        extends AbstractConverter<JmsTokenResponseDto, TokenResponseDto> {

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
        target.setTokenRefId(source.getTokenUniqueReference());
        target.setTokenSuffix(source.getTokenSuffix());

        String tokenExpirationDate = source.getTokenExpirationDate();

        if (tokenExpirationDate != null) {
            target.setTokenExpiryMonth(tokenExpirationDate.substring(0, 2));
            target.setTokenExpiryYear(tokenExpirationDate.substring(2));
        }

        target.setCorrelationId(source.getCorrelationId());
        target.setCurrentStatusCode(source.getCurrentStatusCode());
        target.setCurrentStatusDescription(source.getCurrentStatusDescription());
        target.setCurrentStatusDateTime(source.getCurrentStatusDateTime());
        target.setDigitizationRequestDateTime(source.getDigitizationRequestDateTime());
        target.setLastCommentId(source.getLastCommentId());
        target.setPaymentAppInstanceId(source.getPaymentAppInstanceId());
        target.setProvisioningStatusCode(source.getProvisioningStatusCode());
        if (source.getIps() != null) {
            switch (source.getIps()) {
            case M:
                target.setStorageTechnology(
                        StorageTechnology.fromTokenInfoStorageTechnology(source.getStorageTechnology()).name());
                break;
            case V:
                target.setStorageTechnology(
                        TokenProtectionMethod.fromTokenInfoStorageTechnology(source.getStorageTechnology()).name());
                break;
            }
        }
        target.setTokenActivatedDateTime(source.getTokenActivatedDateTime());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setTokenRequestorName(source.getTokenRequestorName());
        target.setTokenType(source.getTokenType());
        target.setPanInternalId(source.getPanInternalId());
        target.setPanInternalGUID(source.getPanInternalGuid());
        if (source.getIps() != null) {
            target.setIps(source.getIps().name());
        }
        target.setDevice(jmsDeviceResponseDtoToDeviceResponseDtoConverter.convert(source.getDevice()));
    }
}
