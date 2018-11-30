package com.cts.fasttack.core.dao;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.dict.TokenEventStatus;
import com.cts.fasttack.common.core.util.ObjectUtil;
import com.cts.fasttack.core.data.TokenReason;

/**
 * @author Dmitry Koval
 */
@Repository
public class TokenReasonDaoImpl extends GenericDaoImpl<Long, TokenReason> implements TokenReasonDao {
    @Override
    public Class<TokenReason> getEntityClass() {
        return TokenReason.class;
    }

    @Override
    public List<TokenReason> listByStatus(TokenEventStatus eventStatus) {
        return ObjectUtil.uncheckedCast(getSession().createCriteria(getEntityClass()).add(Restrictions.eq("tokenStatusUpdateReason", eventStatus)).list());
    }

    @Override
    public String getMdesReason(TokenEventStatus tokenEventStatus, String reason) {
        return getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("tokenStatusUpdateReason", tokenEventStatus))
                .add(Restrictions.eq("reason", reason))
                .setProjection(Projections.property("mdesReason")).uniqueResult().toString();
    }

    @Override
    public TokenReason getByTokenStatusUpdateAndMdesReason(String tokenStatusUpdate, String mdesReason) {
        return (TokenReason) getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("tokenStatusUpdateReason", TokenEventStatus.getInstance(tokenStatusUpdate)))
                .add(Restrictions.eq("mdesReason", mdesReason)).uniqueResult();
    }
}
