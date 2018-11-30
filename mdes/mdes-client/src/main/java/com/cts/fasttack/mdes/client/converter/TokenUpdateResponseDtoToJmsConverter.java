package com.cts.fasttack.mdes.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.TokenUpdateMdesJmsResponseDto;
import com.cts.fasttack.mdes.client.dto.TokenUpdateResponseDto;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenUpdateResponseDtoToJmsConverter extends AbstractConverter<TokenUpdateResponseDto, TokenUpdateMdesJmsResponseDto> {
    @Override
    protected TokenUpdateMdesJmsResponseDto generateTarget() {
        return new TokenUpdateMdesJmsResponseDto();
    }

    @Override
    protected void lightConvert(TokenUpdateResponseDto source, TokenUpdateMdesJmsResponseDto target) {
        target.setTokens(source.getTokens());
    }
}
