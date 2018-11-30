package com.cts.fasttack.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.fasttack.admin.web.converter.TokenAddCommentDtoToCommentConverter;
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.domain.TokenComment;
import com.cts.fasttack.admin.web.data.dto.TokenAddCommentDto;
import com.cts.fasttack.admin.web.data.dto.TokenCommentDto;
import com.cts.fasttack.admin.web.data.dto.TokensAddCommentDto;
import com.cts.fasttack.admin.web.data.filter.TokenCommentFilter;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.admin.web.service.TokenCommentService;
import com.cts.fasttack.common.core.converter.QueryResultToDtoConverter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.TokenLifecycleJmsResponse;

/**
 * @author Dmitry Koval
 */
@Controller
@RequestMapping("/token/comment")
@PreAuthorize("isAuthenticated()")
public class TokenCommentController {

    @Autowired
    private AccessLogService accessLogService;

    @Autowired
    private TokenCommentService tokenCommentService;

    @Autowired
    private QueryResultToDtoConverter<TokenCommentDto> queryResultToDtoConverter;

    @Autowired
    private TokenAddCommentDtoToCommentConverter tokenAddCommentDtoToCommentConverter;

    @PreAuthorize("@aclToken.canView")
    @PostMapping("/{tokenRefId}/{tokenRequestorId}/filter.json")
    @ResponseBody
    public QueryResultDto<TokenCommentDto> filter(@RequestBody TokenCommentFilter<TokenComment> filter, @PathVariable String tokenRefId, @PathVariable String tokenRequestorId) throws ServiceException {
        accessLogService.create().item(ItemType.TOKEN_HISTORY).type(AccessType.VIEW_ALL).fields("tokenRefId: " + tokenRefId + ", tokenRequestorId: " + tokenRequestorId).save();
        filter.setTokenRefId(tokenRefId);
        filter.setTokenRequestorId(tokenRequestorId);
        return queryResultToDtoConverter.convert(tokenCommentService.list(filter));
    }

    @PreAuthorize("@aclToken.canAddComment")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public TokenCommentDto tokenComment(@Validated @RequestBody TokenAddCommentDto request) throws ServiceException {
        accessLogService.create().item(ItemType.TOKEN_COMMENT).id(request.getTokenRefId()).type(AccessType.ADD_COMMENT).save();
        return tokenCommentService.save(tokenAddCommentDtoToCommentConverter.convert(request));
    }

    @PreAuthorize("@aclToken.canAddComment")
    @RequestMapping("/confirmList")
    @ResponseBody
    public TokenLifecycleJmsResponse tokensComment(@RequestBody TokensAddCommentDto request) {
        return tokenCommentService.tokensComment(request);
    }
}
