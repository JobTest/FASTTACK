package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;
import com.cts.fasttack.core.data.TokenRequestor;
import com.cts.fasttack.core.dto.TokenRequestorDto;
import org.springframework.stereotype.Component;

@Component
public class TokenRequestorToDtoConverter extends IdentifierToDtoConverter<String, TokenRequestor, TokenRequestorDto> {
    @Override
    protected TokenRequestorDto generateTarget() {
        return new TokenRequestorDto();
    }

    @Override
    public void convert(TokenRequestor source, TokenRequestorDto target) {
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setTokenRequestorTitle(source.getTokenRequestorTitle());
    }
}
