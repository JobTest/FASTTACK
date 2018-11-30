package com.cts.fasttack.admin.web.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.cts.fasttack.admin.web.dao.TokenCommentDao;
import com.cts.fasttack.admin.web.data.domain.TokenComment;
import com.cts.fasttack.admin.web.data.filter.TokenCommentFilter;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.dao.PageCriteria;
import com.cts.fasttack.common.core.list.ListFilter;

/**
 * @author Dmitry Koval
 */
@Repository
public class TokenCommentDaoImpl extends GenericDaoImpl<Long, TokenComment> implements TokenCommentDao {
    @Override
    public Class<TokenComment> getEntityClass() {
        return TokenComment.class;
    }

    @Override
    public List<TokenComment> list(ListFilter<TokenComment> listfilter) {
        TokenCommentFilter<TokenComment> filter = (TokenCommentFilter<TokenComment>) listfilter;
        PageCriteria criteria = createPageCriteria(getEntityClass());
        if(StringUtils.isNotBlank(filter.getTokenRefId())){
            criteria.add(Restrictions.eq("tokenRefId", filter.getTokenRefId()));
        }

        if(StringUtils.isNotBlank(filter.getTokenRefId())){
            criteria.add(Restrictions.eq("tokenRequestorId", filter.getTokenRequestorId()));
        }

        return criteria.list(filter);
    }
}
