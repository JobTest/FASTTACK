package com.cts.fasttack.core.dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.core.data.CvcAttempt;

/**
 * @author Dmitry Koval
 */
@Repository
public class CvcAttemptDaoImpl extends GenericDaoImpl<Long, CvcAttempt> implements CvcAttemptDao {

    @Override
    public Class<CvcAttempt> getEntityClass() {
        return CvcAttempt.class;
    }

    @Override
    public CvcAttempt getByPanInternalIdAndGUID(String panInternalID, String panInternalGUID) {
       Criteria criteria = getSession().createCriteria(getEntityClass());

        if (StringUtils.isNotBlank(panInternalGUID)) {
            criteria.add(Restrictions.eq("panInternalID", panInternalID));
        }

        if(StringUtils.isNotBlank(panInternalGUID)){
            criteria.add(Restrictions.eq("panInternalGUID", panInternalGUID));
        }

        return (CvcAttempt) criteria.uniqueResult();
    }
}
