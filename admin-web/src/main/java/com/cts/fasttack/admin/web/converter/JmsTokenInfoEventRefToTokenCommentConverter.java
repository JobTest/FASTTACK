package com.cts.fasttack.admin.web.converter;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.dto.TokenCommentDto;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.jms.dto.JmsTokenInfoEventRefDto;

/**
 * @author Dmitry Koval
 */
@Component
public class JmsTokenInfoEventRefToTokenCommentConverter {

    @Autowired
    private UserService userService;

    public TokenCommentDto convert(JmsTokenInfoEventRefDto source, String comment) {
        TokenCommentDto target = new TokenCommentDto();
        target.setTokenRefId(source.getTokenRefId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setUsrname(userService.getCurrentUser().getName());
        target.setComData(new Date());
        target.setComment(comment);
        target.setEventRef(source.getEventRef());
        return target;
    }
}
