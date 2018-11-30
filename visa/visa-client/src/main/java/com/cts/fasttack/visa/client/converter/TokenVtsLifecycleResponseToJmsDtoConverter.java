package com.cts.fasttack.visa.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.TokenLifecycleVtsJmsResponseDto;
import com.cts.fasttack.visa.client.dto.TokenLifecycleResponseDto;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenVtsLifecycleResponseToJmsDtoConverter extends AbstractConverter<TokenLifecycleResponseDto, TokenLifecycleVtsJmsResponseDto> {
    @Override
    protected TokenLifecycleVtsJmsResponseDto generateTarget() {
        return new TokenLifecycleVtsJmsResponseDto();
    }

    @Override
    protected void lightConvert(TokenLifecycleResponseDto source, TokenLifecycleVtsJmsResponseDto target) {
        target.setActionCode(source.getActionCode());
        target.setErrorCode(source.getErrorCode());
    }
}
