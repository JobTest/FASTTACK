package com.cts.fasttack.admin.web.service;

import com.cts.fasttack.admin.web.data.domain.TokenComment;
import com.cts.fasttack.admin.web.data.dto.TokenCommentDto;
import com.cts.fasttack.admin.web.data.dto.TokensAddCommentDto;
import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.jms.dto.TokenLifecycleJmsResponse;

/**
 * @author Dmitry Koval
 */
public interface TokenCommentService extends GenericService<Long, TokenCommentDto, TokenComment> {

    String TOKEN_COMMENT = "TOKEN_COMMENT";

    TokenLifecycleJmsResponse tokensComment(TokensAddCommentDto tokensAddCommentDto);
}
