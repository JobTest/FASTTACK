package com.cts.fasttack.core.converter;

import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.CardAndTokenDataDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.dto.DeviceInfoDto;
import com.cts.fasttack.core.service.DeviceInfoService;
import com.cts.fasttack.jms.dto.JmsNotifyServiceDto;
import com.cts.fasttack.jms.dto.JmsCardTokenizedRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JmsCardTokenizedDtoConverter {

    @Autowired
    private DeviceInfoService deviceInfoService;

    public JmsCardTokenizedRequestDto convert(JmsNotifyServiceDto notifyServiceDto, CardAndTokenDataDto cardDto, TokenInfoDto tokenDto) {
        JmsCardTokenizedRequestDto dto = new JmsCardTokenizedRequestDto();

        dto.setRequestId(notifyServiceDto.getRequestId());

        dto.setConversationId(notifyServiceDto.getCorrelationId());
        DeviceInfoDto deviceInfoDto = deviceInfoService.get(tokenDto.getId().getTokenRefId());
        dto.setDeviceType(deviceInfoDto.getDeviceType());
        dto.setStorageTechnology(deviceInfoDto.getStorageTechnology());
        dto.setDeviceName(deviceInfoDto.getDeviceName());
        dto.setTokenRequestorId(notifyServiceDto.getTokenRequestorId());

        dto.setTokenRefId(tokenDto.getId().getTokenRefId());
        dto.setStatus(TokenStatus.A.name());
        dto.setPanInternalId(tokenDto.getPanInternalId());
        dto.setPanInternalGUID(tokenDto.getPanInternalGuid());

        dto.setPan(cardDto.getCard().getAccountNumber());
        dto.setExpiryMonth(cardDto.getCard().getExpiryMonth());
        dto.setExpiryYear(cardDto.getCard().getExpiryYear());

        dto.setToken(cardDto.getToken().getToken());
        dto.setTokenExpiryMonth(cardDto.getToken().getExpiryMonth());
        dto.setTokenExpiryYear(cardDto.getToken().getExpiryYear());
        dto.setTokenActivationDate(notifyServiceDto.getTokenActivatedDateTime());
        dto.setIps(tokenDto.getIps().name());
        if(tokenDto.getPanSource() != null) {
            dto.setPanSource(tokenDto.getPanSource().name());
        }
        dto.setPaymentAppInstId(notifyServiceDto.getPaymentAppInstanceId());
        return dto;
    }
}
