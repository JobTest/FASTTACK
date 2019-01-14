package com.cts.fasttack.mdes.client.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenResponseDto;
import com.cts.fasttack.jms.dto.TokenSearchAccountTokenDto;

/**
 * {@link TokenSearchAccountTokenDto} to {@link JmsTokenResponseDto} converter.
 *
 * @author v.semerkov
 * @author d.ishchenko
 */
@Component
public class TokenSearchAccountTokenDtoToJmsTokenResponseDtoConverter extends AbstractConverter<TokenSearchAccountTokenDto, JmsTokenResponseDto> {

    @Autowired
    private TokenSearchAccountTokenDeviceDtoToJmsDeviceResponseDtoConverter tokenSearchAccountTokenDeviceDtoToJmsDeviceResponseDtoConverter;

    @Override
    protected JmsTokenResponseDto generateTarget() {
        return new JmsTokenResponseDto();
    }

    @Override
    protected void lightConvert(TokenSearchAccountTokenDto source, JmsTokenResponseDto target) {
        target.setTokenUniqueReference(source.getTokenUniqueReference());
        target.setTokenSuffix(source.getTokenSuffix());
        target.setTokenExpirationDate(source.getExpirationDate());
        target.setCorrelationId(source.getCorrelationId());
        target.setCurrentStatusCode(toVtsStyleStatusCode(source.getCurrentStatusCode()));
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
        target.setTokenType(toVtsStyleTokenType(source.getTokenType()));
        target.setDevice(tokenSearchAccountTokenDeviceDtoToJmsDeviceResponseDtoConverter.convert(source.getDevice()));
    }

    private String toVtsStyleStatusCode(String statusCode) {
        if ("U".equals(statusCode)) {
            return "I";
        } else {
            return statusCode;
        }
    }

    private String toVtsStyleTokenType(String tokenType) {
        if ("C".equals(tokenType)) {
            return "H";
        } else if ("F".equals(tokenType)) {
            return "C";
        } else {
            return tokenType;
        }
    }
}
