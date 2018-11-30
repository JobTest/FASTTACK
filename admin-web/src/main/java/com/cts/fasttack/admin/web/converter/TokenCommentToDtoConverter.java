package com.cts.fasttack.admin.web.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.domain.TokenComment;
import com.cts.fasttack.admin.web.data.dto.TokenCommentDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenCommentToDtoConverter extends AbstractConverter<TokenComment, TokenCommentDto> {
    @Override
    protected TokenCommentDto generateTarget() {
        return new TokenCommentDto();
    }

    @Override
    protected void lightConvert(TokenComment source, TokenCommentDto target) {
        target.setId(source.getId());
        target.setTokenRefId(source.getTokenRefId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setEventRef(source.getEventRef());
        target.setComData(source.getComData());
        target.setComment(source.getComment());
        target.setUsrname(source.getUsrname());
    }
}
