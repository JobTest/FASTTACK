package com.cts.fasttack.core.converter;

import java.util.Objects;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dict.TokenType;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.jms.dto.JmsNotifyServiceDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class NotifyServiceDtoToTokenInfoConverter extends AbstractConverter<JmsNotifyServiceDto, TokenInfoDto> {
    @Override
    protected TokenInfoDto generateTarget() {
        return new TokenInfoDto();
    }

    @Override
    protected void lightConvert(JmsNotifyServiceDto source, TokenInfoDto target) {
        target.setId(new TokenInfoId(source.getTokenUniqueReference(), source.getTokenRequestorId()));
        target.setPanRefId(source.getPanUniqueReference());
        target.setActiveTokenCount(source.getNumberOfActiveTokens());
        target.setTokenType(Objects.equals(source.getTokenType(), "STATIC") ? TokenType.C : Objects.equals(source.getTokenType(), "EMBEDDED_SE") ?
                TokenType.S : Objects.equals(source.getTokenType(), "CLOUD") ? TokenType.H : TokenType.E);
        target.setTokenStatus(TokenStatus.A);
        target.setDigitizeDate(source.getTokenActivatedDateTime());
        target.setIps(InternationalPaymentSystem.M);
        target.setClientWalletAccountId(source.getPaymentAppInstanceId());
    }
}
