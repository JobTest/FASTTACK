package com.cts.fasttack.admin.web.converter;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.dto.TokenCommentDto;
import com.cts.fasttack.admin.web.data.dto.TokenUpdateDto;
import com.cts.fasttack.admin.web.service.UserService;

/**
 * @author a.lipavets
 */
@Component
public class TokenUpdateDtoToTokenCommentConverter {

    @Autowired
    private UserService userService;

    public TokenCommentDto convert(TokenUpdateDto source, String comment) {
        TokenCommentDto target = new TokenCommentDto();
        target.setTokenRefId(source.getTokenRefId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setUsrname(userService.getCurrentUser().getName());
        target.setComData(new Date());
        target.setComment(comment != null ? comment : source.getComment());
        return target;
    }
}
