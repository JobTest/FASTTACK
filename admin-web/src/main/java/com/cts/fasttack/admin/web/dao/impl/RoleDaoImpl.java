package com.cts.fasttack.admin.web.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import com.cts.fasttack.admin.web.dao.RoleDao;
import com.cts.fasttack.admin.web.data.domain.Role;
import com.cts.fasttack.admin.web.data.list.RoleListFilter;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.dao.PageCriteria;

@Repository("roleDao")
public class RoleDaoImpl extends GenericDaoImpl<String, Role> implements RoleDao {

    @Override
    public Class<Role> getEntityClass() {
        return Role.class;
    }

    @Override
    public List<Role> listRoles(RoleListFilter filter) {
        PageCriteria pc = createPageCriteria(getEntityClass());
        if (!CollectionUtils.isEmpty(filter.getRoleCodes())) {
            pc.add(Restrictions.in("id", filter.getRoleCodes()));
        }
        return pc.list(filter);
    }
}
