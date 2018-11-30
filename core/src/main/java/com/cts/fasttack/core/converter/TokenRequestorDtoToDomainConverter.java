package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.TokenRequestor;
import com.cts.fasttack.core.dto.TokenRequestorDto;
import org.springframework.stereotype.Component;

@Component
public class TokenRequestorDtoToDomainConverter extends AbstractConverter<TokenRequestorDto, TokenRequestor> {
    @Override
    protected TokenRequestor generateTarget() {
        return new TokenRequestor();
    }

    @Override
    protected void lightConvert(TokenRequestorDto source, TokenRequestor target) {
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setTokenRequestorTitle(source.getTokenRequestorTitle());
    }
}
