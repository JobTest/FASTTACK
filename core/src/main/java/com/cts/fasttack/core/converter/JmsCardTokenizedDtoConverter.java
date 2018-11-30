package com.cts.fasttack.core.converter;

import java.util.Date;
import java.util.Optional;

import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.CardAndTokenDataDto;
import com.cts.fasttack.core.dto.CardholderVerificationMethodDto;
import com.cts.fasttack.core.dto.DCProgressDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.dto.DeviceInfoDto;
import com.cts.fasttack.core.service.CardholderVerificationMethodService;
import com.cts.fasttack.core.service.DCProgressService;
import com.cts.fasttack.core.service.DeviceInfoService;
import com.cts.fasttack.jms.dto.JmsNotifyServiceDto;
import com.cts.fasttack.jms.dto.JmsCardTokenizedRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JmsCardTokenizedDtoConverter {

    @Autowired
    private DCProgressService dcProgressService;

    @Autowired
    private DeviceInfoService deviceInfoService;

    @Autowired
    private CardholderVerificationMethodService cardholderVerificationMethodService;

    public JmsCardTokenizedRequestDto convert(JmsNotifyServiceDto notifyServiceDto, CardAndTokenDataDto cardDto, TokenInfoDto tokenDto) {
        JmsCardTokenizedRequestDto dto = new JmsCardTokenizedRequestDto();

        dto.setRequestId(notifyServiceDto.getRequestId());

        Optional<DCProgressDto> dcProgressDto = dcProgressService.get(notifyServiceDto.getCorrelationId());
        dcProgressDto.ifPresent(dc -> dto.setConversationId(dc.getRequestId()));
        if(!dcProgressDto.isPresent()){
//todo            Optional<CardholderVerificationMethodDto> cvmOptional = cardholderVerificationMethodService.getByCorrelationId(notifyServiceDto.getCorrelationId());
//todo            cvmOptional.ifPresent(cvm -> dto.setConversationId(cvm.getRequestId()));
//todo
//todo            if(!cvmOptional.isPresent()){
                dto.setConversationId(notifyServiceDto.getRequestId());

                DeviceInfoDto deviceInfoDto = deviceInfoService.get(tokenDto.getId().getTokenRefId());
                dto.setDeviceType(deviceInfoDto.getDeviceType());
                dto.setStorageTechnology(deviceInfoDto.getStorageTechnology());
                dto.setDeviceName(deviceInfoDto.getDeviceName());
//todo            }
        }
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
        dto.setTokenActivationDate(new Date());
        dto.setIps(tokenDto.getIps().name());
        if(tokenDto.getPanSource() != null) {
            dto.setPanSource(tokenDto.getPanSource().name());
        }
        dto.setPaymentAppInstId(notifyServiceDto.getPaymentAppInstanceId());
        return dto;
    }
}
