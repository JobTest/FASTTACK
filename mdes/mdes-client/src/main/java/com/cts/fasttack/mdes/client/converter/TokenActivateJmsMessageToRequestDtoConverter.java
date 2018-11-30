package com.cts.fasttack.mdes.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.mdes.client.dto.TokenActivateRequestDto;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenActivateJmsMessageToRequestDtoConverter extends AbstractJmsToTokenLifecycleDtoConverter<TokenActivateRequestDto> {

    @Override
    protected TokenActivateRequestDto generateTarget() {
        return new TokenActivateRequestDto();
    }

}
