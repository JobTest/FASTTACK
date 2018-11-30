package com.cts.fasttack.mdes.server.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenDto;
import com.cts.fasttack.mdes.server.dto.TokenDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class TokenToJmsTokenDtoConverter extends AbstractConverter<TokenDto, JmsTokenDto> {
    @Override
    protected JmsTokenDto generateTarget() {
        return new JmsTokenDto();
    }

    @Override
    protected void lightConvert(TokenDto source, JmsTokenDto target) {
        target.setStatus(source.getStatus());
        target.setTokenExpiry(source.getTokenExpiry());
        target.setTokenUniqueReference(source.getTokenUniqueReference());
        target.setSuspendedBy(source.getSuspendedBy());
    }
}
