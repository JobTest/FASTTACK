package com.cts.fasttack.admin.web.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import com.cts.fasttack.admin.web.dao.AccessLogDao;
import com.cts.fasttack.admin.web.data.domain.AccessLog;
import com.cts.fasttack.admin.web.data.filter.AccessLogFilter;
import com.cts.fasttack.common.core.util.CriteriaUtil;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.dao.PageCriteria;

/**
 * @author - a.kuzminov
 */
@Repository
public class AccessLogDaoImpl extends GenericDaoImpl<Long, AccessLog> implements AccessLogDao {

    @Override
    public List<AccessLog> listAll(AccessLogFilter filter) {
        PageCriteria c = createPageCriteria(getEntityClass());
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        CriteriaUtil.likeIfNotEmpty(c, "username", filter.getUsername());
        CriteriaUtil.dateBetween(c, "accessDate", filter.getAccessDateFrom(), filter.getAccessDateTill());
        CriteriaUtil.eqIfNotEmpty(c, "itemType", filter.getItemType());
        CriteriaUtil.eqIfNotEmpty(c, "accessType", filter.getAccessType());
        CriteriaUtil.likeIfNotEmpty(c, "itemId", filter.getItemId());
        return c.list(filter);
    }

    @Override
    public Class<AccessLog> getEntityClass() {
        return AccessLog.class;
    }
}
