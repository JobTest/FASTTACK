package com.cts.fasttack.admin.web.converter;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.dto.TokenCommentDto;
import com.cts.fasttack.admin.web.data.dto.TokenInfoId;
import com.cts.fasttack.admin.web.service.TokenCommentService;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.logging.interceptor.ChangeLoggable;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenInfoCommentToTokenCommentDtoConverter {

    @Autowired
    private UserService userService;

    @ChangeLoggable(action = TokenCommentService.TOKEN_COMMENT, itemType = TokenCommentService.TOKEN_COMMENT, itemId = "#infoId.tokenRefId", fields = {"#infoId.tokenRequestorId"})
    public TokenCommentDto convert(TokenInfoId infoId, String comment) {
        TokenCommentDto tokenCommentDto = new TokenCommentDto();
        tokenCommentDto.setTokenRefId(infoId.getTokenRefId());
        tokenCommentDto.setTokenRequestorId(infoId.getTokenRequestorId());
        tokenCommentDto.setComData(new Date());
        tokenCommentDto.setComment(comment);
        tokenCommentDto.setUsrname(userService.getCurrentUser().getName());
        return tokenCommentDto;
    }
}
