package com.cts.fasttack.admin.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fasttack.admin.web.converter.TokenCommentDtoToDomainConverter;
import com.cts.fasttack.admin.web.converter.TokenCommentToDtoConverter;
import com.cts.fasttack.admin.web.converter.TokenInfoCommentToTokenCommentDtoConverter;
import com.cts.fasttack.admin.web.dao.TokenCommentDao;
import com.cts.fasttack.admin.web.data.domain.TokenComment;
import com.cts.fasttack.admin.web.data.dto.TokenCommentDto;
import com.cts.fasttack.admin.web.data.dto.TokensAddCommentDto;
import com.cts.fasttack.admin.web.service.TokenCommentService;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.jms.dto.TokenLifecycleJmsResponse;

/**
 * @author Dmitry Koval
 */
@Service
public class TokenCommentServiceImpl extends GenericServiceImpl<Long, TokenCommentDto, TokenComment, TokenCommentDao> implements TokenCommentService {

    @Autowired
    private TokenInfoCommentToTokenCommentDtoConverter tokenInfoCommentToTokenCommentDtoConverter;

    @Autowired
    public TokenCommentServiceImpl(TokenCommentDao dao, TokenCommentToDtoConverter domainToDtoConverter, TokenCommentDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional
    public TokenLifecycleJmsResponse tokensComment(TokensAddCommentDto tokensAddCommentDto) {
        tokensAddCommentDto.getTokens().forEach(item -> {
            save(tokenInfoCommentToTokenCommentDtoConverter.convert(item, tokensAddCommentDto.getComment()));
        });
        return new TokenLifecycleJmsResponse();
    }
}
