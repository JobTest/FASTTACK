package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.TokenReason;
import com.cts.fasttack.core.dto.TokenReasonDto;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenReasonDtoToDomainConverter extends AbstractConverter<TokenReasonDto, TokenReason> {
    @Override
    protected TokenReason generateTarget() {
        return new TokenReason();
    }

    @Override
    protected void lightConvert(TokenReasonDto source, TokenReason target) {
        target.setId(source.getId());
        target.setTokenStatusUpdateReason(source.getTokenStatusUpdateReason());
        target.setReason(source.getReason());
        target.setMdesReason(source.getMdesReason());
    }
}
