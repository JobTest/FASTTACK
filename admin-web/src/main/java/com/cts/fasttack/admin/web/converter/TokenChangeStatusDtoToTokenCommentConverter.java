package com.cts.fasttack.admin.web.converter;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.dto.TokenChangeStatusDto;
import com.cts.fasttack.admin.web.data.dto.TokenCommentDto;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.common.core.converter.AbstractConverter;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenChangeStatusDtoToTokenCommentConverter extends AbstractConverter<TokenChangeStatusDto,TokenCommentDto> {

    @Autowired
    private UserService userService;

    @Override
    protected TokenCommentDto generateTarget() {
        return new TokenCommentDto();
    }

    @Override
    protected void lightConvert(TokenChangeStatusDto source, TokenCommentDto target) {
        target.setTokenRefId(source.getTokenRefId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setUsrname(userService.getCurrentUser().getName());
        target.setComData(new Date());
        target.setEventRef(source.getEventRef());
        target.setComment(source.getComment());
    }
}
