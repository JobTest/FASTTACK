package com.cts.fasttack.admin.web.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.domain.TokenComment;
import com.cts.fasttack.admin.web.data.dto.TokenCommentDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenCommentDtoToDomainConverter extends AbstractConverter<TokenCommentDto, TokenComment>{

    @Override
    protected TokenComment generateTarget() {
        return new TokenComment();
    }

    @Override
    protected void lightConvert(TokenCommentDto source, TokenComment target) {
        target.setId(source.getId());
        target.setTokenRefId(source.getTokenRefId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setEventRef(source.getEventRef());
        target.setComData(source.getComData());
        target.setUsrname(source.getUsrname());
        target.setComment(source.getComment());
    }
}
