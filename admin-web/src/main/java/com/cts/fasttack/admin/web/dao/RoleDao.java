package com.cts.fasttack.admin.web.dao;

import java.util.List;

import com.cts.fasttack.admin.web.data.domain.Role;
import com.cts.fasttack.admin.web.data.list.RoleListFilter;
import com.cts.fasttack.common.core.dao.GenericDao;

public interface RoleDao extends GenericDao<String, Role> {

    List<Role> listRoles(RoleListFilter filter);
}
