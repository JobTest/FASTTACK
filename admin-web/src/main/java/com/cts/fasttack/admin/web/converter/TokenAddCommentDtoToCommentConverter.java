package com.cts.fasttack.admin.web.converter;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.dto.TokenAddCommentDto;
import com.cts.fasttack.admin.web.data.dto.TokenCommentDto;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.common.core.converter.AbstractConverter;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenAddCommentDtoToCommentConverter extends AbstractConverter<TokenAddCommentDto, TokenCommentDto>{

    @Autowired
    private UserService userService;

    @Override
    protected TokenCommentDto generateTarget() {
        return new TokenCommentDto();
    }

    @Override
    protected void lightConvert(TokenAddCommentDto source, TokenCommentDto target) {
        target.setTokenRefId(source.getTokenRefId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setComData(new Date());
        target.setComment(source.getComment());
        target.setUsrname(userService.getCurrentUser().getName());
    }
}
