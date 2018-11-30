package com.cts.fasttack.logging.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.dao.PageCriteria;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.common.core.util.CriteriaUtil;
import com.cts.fasttack.logging.domain.ChangeLog;
import com.cts.fasttack.logging.domain.filter.ChangeLogFilter;

/**
 * @author Dmitry Koval
 */
@Repository("changeLogDao")
public class ChangeLogDaoImpl extends GenericDaoImpl<Long, ChangeLog> implements ChangeLogDao {
    @Override
    public Class<ChangeLog> getEntityClass() {
        return ChangeLog.class;
    }

    @Override
    public List<ChangeLog> list(ListFilter<ChangeLog> filter) {
        ChangeLogFilter changeLogFilter = (ChangeLogFilter) filter;
        PageCriteria c = createPageCriteria(getEntityClass());
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        CriteriaUtil.eqIfNotEmpty(c, "action", changeLogFilter.getAction());
        CriteriaUtil.eqIfNotEmpty(c, "itemType", changeLogFilter.getItemType());
        CriteriaUtil.eqIfNotEmpty(c, "itemId", changeLogFilter.getItemId());
        CriteriaUtil.dateBetween(c, "time", changeLogFilter.getDateFrom(), changeLogFilter.getDateTill());
        return c.list(filter);
    }
}
