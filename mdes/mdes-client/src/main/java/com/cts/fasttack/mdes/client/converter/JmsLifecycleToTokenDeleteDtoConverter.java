package com.cts.fasttack.mdes.client.converter;

import com.cts.fasttack.mdes.client.dto.TokenDeleteRequestDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class JmsLifecycleToTokenDeleteDtoConverter extends AbstractJmsToTokenLifecycleDtoConverter<TokenDeleteRequestDto> {
    @Override
    protected TokenDeleteRequestDto generateTarget() {
        return new TokenDeleteRequestDto();
    }
}
