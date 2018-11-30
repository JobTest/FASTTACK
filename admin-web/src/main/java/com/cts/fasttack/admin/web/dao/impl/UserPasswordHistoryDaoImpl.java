package com.cts.fasttack.admin.web.dao.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cts.fasttack.admin.web.config.context.parameter.AdminWebSecurityParameters;
import com.cts.fasttack.admin.web.dao.UserPasswordHistoryDao;
import com.cts.fasttack.admin.web.data.domain.UserPasswordHistory;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.util.ObjectUtil;

@Repository("userPasswordHistoryDao")
public class UserPasswordHistoryDaoImpl extends GenericDaoImpl<Long, UserPasswordHistory> implements UserPasswordHistoryDao {

    @Autowired
    private AdminWebSecurityParameters adminWebSecurityParameters;

    @Override
    public Class<UserPasswordHistory> getEntityClass() {
        return UserPasswordHistory.class;
    }

    @Override
    public boolean existUsernameHistory(String username) {
        return isExists(
                getSession().createCriteria(getEntityClass())
                        .add(Restrictions.eq("username", username))
        );
    }

    @Override
    public boolean existPasswordHistory(String username, String password) {
        Criteria c = getSession().createCriteria(UserPasswordHistory.class)
                .add(Restrictions.eq("username", username))
                .addOrder(Order.desc("id"))
                .setMaxResults(adminWebSecurityParameters.getCheckLastChangePasswordCount())
                .setProjection(Projections.id());

        List<Long> ids = ObjectUtil.uncheckedCast(c.list());
        return !ids.isEmpty() && isExists(
                        getSession().createCriteria(UserPasswordHistory.class)
                                .add(Restrictions.eq("username", username))
                                .add(Restrictions.eq("password", password))
                                .add(Property.forName("id").in(ids))
        );

    }


    @Override
    public boolean isPasswordExpire(String username) {
        LocalDate expiredLocalDate = LocalDate.now().minusDays(adminWebSecurityParameters.getMinExpireDaysToChangePassword() - adminWebSecurityParameters.getMinExpireDaysToNotifyChangePassword());
        Date expiredDate = Date.from(expiredLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return !isExists(
                getSession().createCriteria(getEntityClass())
                        .add(Restrictions.eq("username", username))
                        .add(Restrictions.gt("date", expiredDate))
        );
    }

    @Override
    public List<UserPasswordHistory> listUsernameHistories(String username) {
        return ObjectUtil.uncheckedCast(getSession()
                        .createCriteria(getEntityClass())
                        .add(Restrictions.eq("username", username))
                        .list());
    }
}
