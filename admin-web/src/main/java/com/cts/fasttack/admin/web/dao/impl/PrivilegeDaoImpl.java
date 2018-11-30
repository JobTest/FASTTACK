package com.cts.fasttack.admin.web.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import com.cts.fasttack.admin.web.dao.PrivilegeDao;
import com.cts.fasttack.admin.web.data.domain.Privilege;
import com.cts.fasttack.admin.web.data.list.PrivilegeListFilter;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.dao.PageCriteria;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends GenericDaoImpl<String, Privilege> implements PrivilegeDao {

    @Override
    public Class<Privilege> getEntityClass() {
        return Privilege.class;
    }

    @Override
    public List<Privilege> listPrivileges(PrivilegeListFilter filter) {
        PageCriteria pc = createPageCriteria(getEntityClass());
        if (!CollectionUtils.isEmpty(filter.getPrivilegeCodes())) {
            pc.add(Restrictions.in("id", filter.getPrivilegeCodes()));
        }
        return pc.list(filter);
    }
}
