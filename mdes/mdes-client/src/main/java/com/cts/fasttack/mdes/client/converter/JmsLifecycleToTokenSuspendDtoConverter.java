package com.cts.fasttack.mdes.client.converter;

import com.cts.fasttack.mdes.client.dto.TokenSuspendRequestDto;
import org.springframework.stereotype.Component;

/**
 * @author Anton Leliuk
 */
@Component
public class JmsLifecycleToTokenSuspendDtoConverter extends AbstractJmsToTokenLifecycleDtoConverter<TokenSuspendRequestDto> {

    @Override
    protected TokenSuspendRequestDto generateTarget() {
        return new TokenSuspendRequestDto();
    }
}
