package com.cts.fasttack.visa.vtis.server.converter;

import com.cts.fasttack.visa.vtis.server.dto.TokenInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenInfoDto;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenInfoToJmsConverter extends AbstractConverter<TokenInfoDto, JmsTokenInfoDto> {

    @Autowired
    private ExpirationDateToJmsDtoConverter expirationDateToJmsDtoConverter;

    @Override
    protected JmsTokenInfoDto generateTarget() {
        return new JmsTokenInfoDto();
    }

    @Override
    protected void lightConvert(TokenInfoDto source, JmsTokenInfoDto target) {
        target.setToken(source.getToken());
        target.setTokenType(source.getTokenType().name());
        target.setTokenStatus(source.getTokenStatus().name());
        target.setTokenExpirationDate(expirationDateToJmsDtoConverter.convert(source.getTokenExpirationDate()));
        target.setTokenAssuranceLevel(source.getTokenAssuranceLevel());
        target.setNumberOfActiveTokensForPAN(source.getNumberOfActiveTokensForPAN());
        target.setNumberOfInactiveTokensForPAN(source.getNumberOfInactiveTokensForPAN());
        target.setNumberOfSuspendedTokensForPAN(source.getNumberOfSuspendedTokensForPAN());
    }
}
