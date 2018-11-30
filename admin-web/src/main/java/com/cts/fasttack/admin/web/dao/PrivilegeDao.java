package com.cts.fasttack.admin.web.dao;

import java.util.List;

import com.cts.fasttack.admin.web.data.domain.Privilege;
import com.cts.fasttack.admin.web.data.list.PrivilegeListFilter;
import com.cts.fasttack.common.core.dao.GenericDao;

public interface PrivilegeDao extends GenericDao<String, Privilege> {

    List<Privilege> listPrivileges(PrivilegeListFilter filter);
}
