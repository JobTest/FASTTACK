package com.cts.fasttack.admin.web.dao;

import java.util.List;

import com.cts.fasttack.admin.web.data.domain.AccessLog;
import com.cts.fasttack.admin.web.data.filter.AccessLogFilter;
import com.cts.fasttack.common.core.dao.GenericDao;


public interface AccessLogDao extends GenericDao<Long, AccessLog> {

    public List<AccessLog> listAll(AccessLogFilter filter);

}
