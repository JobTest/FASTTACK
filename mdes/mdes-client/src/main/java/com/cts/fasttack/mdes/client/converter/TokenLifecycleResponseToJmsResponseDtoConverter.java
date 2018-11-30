package com.cts.fasttack.mdes.client.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.TokenLifecycleMdesJmsResponseDto;
import com.cts.fasttack.mdes.client.dto.AbstractTokenLifecycleResponseDto;
import org.springframework.stereotype.Component;

/**
 * @author Anton Leliuk
 */
@Component
public class TokenLifecycleResponseToJmsResponseDtoConverter extends AbstractConverter<AbstractTokenLifecycleResponseDto, TokenLifecycleMdesJmsResponseDto> {

    @Override
    protected TokenLifecycleMdesJmsResponseDto generateTarget() {
        return new TokenLifecycleMdesJmsResponseDto();
    }

    @Override
    protected void lightConvert(AbstractTokenLifecycleResponseDto source, TokenLifecycleMdesJmsResponseDto target) {
        target.setToken(source.getToken());
    }
}
