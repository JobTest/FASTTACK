package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.cts.fasttack.common.core.util.DateFormatUtil;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dict.TokenType;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.jms.dto.JmsTokenResponseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {@link JmsTokenResponseDto} to {@link TokenInfoDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class JmsTokenResponseDtoToTokenInfoDtoConverter extends AbstractConverter<JmsTokenResponseDto, TokenInfoDto> {

    private Logger logger = LogManager.getLogger(JmsTokenResponseDtoToTokenInfoDtoConverter.class);

    @Override
    protected TokenInfoDto generateTarget() {
        return new TokenInfoDto();
    }

    @Override
    protected void lightConvert(JmsTokenResponseDto source, TokenInfoDto target) {
        target.setTokenExpdate(DateFormatUtil.expiryDate(DateFormatUtil.stringToDate(DateFormatEnum.EXPIRATION_DATE, source.getTokenExpirationDate())));
        target.setTokenType(TokenType.getInstance(source.getTokenType()));
        target.setTokenStatus(TokenStatus.getInstance(source.getCurrentStatusCode())); //todo unavailable to master
        target.setDigitizeDate(source.getDigitizationRequestDateTime());
        target.setTokenStatusUpdate(source.getCurrentStatusDateTime());
        target.setClientWalletAccountId(source.getPaymentAppInstanceId());
    }

    /**
     * Full converting with source token.
     *
     * @param source      JMS token response DTO
     * @param sourceToken source token info DTO
     * @return {@link TokenInfoDto}
     */
    public TokenInfoDto convertWithSourceToken(JmsTokenResponseDto source, TokenInfoDto sourceToken) {
        TokenInfoDto target = convert(source);
        if (sourceToken != null) {
            target.setPanRefId(sourceToken.getPanRefId());
            target.setMaskedPan(sourceToken.getMaskedPan());
            target.setMaskedToken(sourceToken.getMaskedToken());
            target.setLifecycleTraceId(sourceToken.getLifecycleTraceId());
            target.setPanSource(sourceToken.getPanSource());
            target.setActiveTokenCount(sourceToken.getActiveTokenCount());
        }

        return target;
    }
}
