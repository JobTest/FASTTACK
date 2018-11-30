package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.TokenReason;
import com.cts.fasttack.core.dto.TokenReasonDto;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenReasonToDtoConverter extends AbstractConverter<TokenReason, TokenReasonDto> {
    @Override
    protected TokenReasonDto generateTarget() {
        return new TokenReasonDto();
    }

    @Override
    protected void lightConvert(TokenReason source, TokenReasonDto target) {
        target.setId(source.getId());
        target.setReason(source.getReason());
        target.setTokenStatusUpdateReason(source.getTokenStatusUpdateReason());
        target.setMdesReason(source.getMdesReason());
    }
}
