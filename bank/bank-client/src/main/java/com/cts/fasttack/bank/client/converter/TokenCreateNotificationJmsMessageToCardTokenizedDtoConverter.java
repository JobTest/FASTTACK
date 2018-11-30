package com.cts.fasttack.bank.client.converter;

import java.util.UUID;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.dict.PanSourceType;
import com.cts.fasttack.jms.dto.JmsTokenCreateNotificationDto;
import com.cts.fasttack.jms.dto.JmsCardTokenizedRequestDto;
import com.cts.fasttack.jms.dto.TokenCreateNotificationJmsMessage;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenCreateNotificationJmsMessageToCardTokenizedDtoConverter extends AbstractConverter<TokenCreateNotificationJmsMessage, JmsCardTokenizedRequestDto> {
    @Override
    protected JmsCardTokenizedRequestDto generateTarget() {
        return new JmsCardTokenizedRequestDto();
    }

    @Override
    protected void lightConvert(TokenCreateNotificationJmsMessage source, JmsCardTokenizedRequestDto target) {
        JmsTokenCreateNotificationDto createNotificationDto = source.getJmsTokenCreateNotificationDto();
        target.setRequestId(createNotificationDto.getEventID());
        target.setConversationId(UUID.randomUUID().toString());
        target.setTokenRequestorId(createNotificationDto.getTokenRequestorID());
        target.setTokenRefId(createNotificationDto.getTokenReferenceID());
        target.setStatus(createNotificationDto.getEncryptedData().getTokenInfo().getTokenStatus().substring(0, 1));
        target.setPan(createNotificationDto.getEncryptedData().getCardholderInfo().getPrimaryAccountNumber());
        if (createNotificationDto.getEncryptedData().getCardholderInfo().getExpirationDate() != null) {
            target.setExpiryMonth(createNotificationDto.getEncryptedData().getCardholderInfo().getExpirationDate().getMonth());
            target.setExpiryYear(createNotificationDto.getEncryptedData().getCardholderInfo().getExpirationDate().getYear().substring(2));
        }
        target.setToken(createNotificationDto.getEncryptedData().getTokenInfo().getToken());
        target.setTokenExpiryMonth(createNotificationDto.getEncryptedData().getTokenInfo().getTokenExpirationDate().getMonth());
        target.setTokenExpiryYear(createNotificationDto.getEncryptedData().getTokenInfo().getTokenExpirationDate().getYear().substring(2));
        target.setTokenActivationDate(createNotificationDto.getDateTimeOfEvent());
        PanSourceType panSourceType = PanSourceType.valueOfFirstWord(createNotificationDto.getPanSource());
		if (panSourceType != null)
			target.setPanSource(panSourceType.name());
		target.setIps(InternationalPaymentSystem.V.name());
		target.setPaymentAppInstId(createNotificationDto.getClientWalletAccountID());
		target.setPanInternalId(source.getPanInternalId());
		target.setPanInternalGUID(source.getPanInternalGuid());
        target.setDeviceType(source.getJmsTokenCreateNotificationDto().getDeviceInfo().getDeviceType());
        target.setStorageTechnology(source.getJmsTokenCreateNotificationDto().getDeviceInfo().getStorageTechnology());
        target.setDeviceName(source.getJmsTokenCreateNotificationDto().getDeviceInfo().getDeviceName());
    }
}
