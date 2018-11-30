package com.cts.fasttack.mdes.client.converter;

import com.cts.fasttack.mdes.client.dto.TokenUnsuspendRequestDto;
import org.springframework.stereotype.Component;

/**
 * @author Anton Leliuk
 */
@Component
public class JmsLifecycleToTokenUnsuspendDtoConverter extends AbstractJmsToTokenLifecycleDtoConverter<TokenUnsuspendRequestDto> {

    @Override
    protected TokenUnsuspendRequestDto generateTarget() {
        return new TokenUnsuspendRequestDto();
    }
}
