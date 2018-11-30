package com.cts.fasttack.core.dao;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.core.data.CardholderVerificationMethod;

/**
 * @author a.lipavets
 */
@Repository("cardholderVerificationMethodDao")
public class CardholderVerificationMethodDaoImpl extends GenericDaoImpl<Long, CardholderVerificationMethod> implements CardholderVerificationMethodDao {
    @Override
    public Class<CardholderVerificationMethod> getEntityClass() {
        return CardholderVerificationMethod.class;
    }

    @Override
    public CardholderVerificationMethod getByCorrelationId(String correlationId) {
        return (CardholderVerificationMethod) getSession().createCriteria(CardholderVerificationMethod.class)
                .add(Restrictions.eq("correlationId", correlationId))
                .uniqueResult();
    }

    @Override
    public CardholderVerificationMethod getByTokenRefIdAndRequestorId(String tokenRefId, String tokenRequestorId) {
        return (CardholderVerificationMethod) getSession().createCriteria(CardholderVerificationMethod.class)
                .add(Restrictions.eq("tokenRefId", tokenRefId))
                .add(Restrictions.eq("tokenRequestorId", tokenRequestorId))
                .uniqueResult();
    }
}
