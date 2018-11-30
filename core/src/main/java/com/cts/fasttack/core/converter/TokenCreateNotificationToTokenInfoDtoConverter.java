package com.cts.fasttack.core.converter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.dict.PanSourceType;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dict.TokenType;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.jms.dto.JmsTokenCreateNotificationDto;
import com.cts.fasttack.jms.dto.JmsTokenCreateNotificationResponseDto;
import com.cts.fasttack.jms.dto.TokenCreateNotificationJmsMessage;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenCreateNotificationToTokenInfoDtoConverter {


    public TokenInfoDto convert(TokenCreateNotificationJmsMessage tokenCreateNotificationJmsMessage, JmsTokenCreateNotificationResponseDto response) {
        JmsTokenCreateNotificationDto jmsTokenCreateNotificationDto = tokenCreateNotificationJmsMessage.getJmsTokenCreateNotificationDto();
        TokenInfoDto target = new TokenInfoDto();
        target.setPanRefId(jmsTokenCreateNotificationDto.getPanReferenceID());
        target.setMaskedPan(StringUtil.displayPanOrToken(jmsTokenCreateNotificationDto.getEncryptedData().getCardholderInfo().getPrimaryAccountNumber()));
        target.setMaskedToken(StringUtil.displayPanOrToken(jmsTokenCreateNotificationDto.getEncryptedData().getTokenInfo().getToken()));
        target.setPanSource(PanSourceType.valueOfFirstWord(jmsTokenCreateNotificationDto.getPanSource()));
        target.setTokenType(TokenType.valueOfFirstWord(jmsTokenCreateNotificationDto.getEncryptedData().getTokenInfo().getTokenType()));
        target.setTokenStatus(TokenStatus.valueOfFirstWord(jmsTokenCreateNotificationDto.getEncryptedData().getTokenInfo().getTokenStatus()));
        target.setIps(InternationalPaymentSystem.V);
        target.setClientWalletAccountId(jmsTokenCreateNotificationDto.getClientWalletAccountID());
        target.setId(new TokenInfoId(jmsTokenCreateNotificationDto.getTokenReferenceID(), jmsTokenCreateNotificationDto.getTokenRequestorID()));
        target.setActiveTokenCount(jmsTokenCreateNotificationDto.getEncryptedData().getTokenInfo().getNumberOfActiveTokensForPAN());
        target.setDigitizeDate(jmsTokenCreateNotificationDto.getDateTimeOfEvent());
        target.setTokenStatusUpdate(jmsTokenCreateNotificationDto.getDateTimeOfEvent());
        target.setTokenExpdate(
                Date.from(LocalDateTime.of(
                        Integer.valueOf(jmsTokenCreateNotificationDto.getEncryptedData().getTokenInfo().getTokenExpirationDate().getYear()),
                        Integer.valueOf(jmsTokenCreateNotificationDto.getEncryptedData().getTokenInfo().getTokenExpirationDate().getMonth()), 1, 0, 0).atZone(ZoneId.systemDefault()).with(TemporalAdjusters.lastDayOfMonth()).toInstant()));

        if (response != null) {
            target.setPanInternalId(response.getPanInternalId());
            target.setPanInternalGuid(response.getPanInternalGUID());
            target.setCustomerPhone(response.getCustomerPhone());
            target.setCustomerId(response.getCustomerId());
        }

        return target;
    }
}
