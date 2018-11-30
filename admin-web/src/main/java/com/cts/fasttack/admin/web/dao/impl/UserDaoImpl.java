package com.cts.fasttack.admin.web.dao.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cts.fasttack.admin.web.config.context.parameter.AdminWebSecurityParameters;
import com.cts.fasttack.admin.web.dao.UserDao;
import com.cts.fasttack.admin.web.dao.UserPasswordHistoryDao;
import com.cts.fasttack.admin.web.data.dict.UserStatus;
import com.cts.fasttack.admin.web.data.domain.User;
import com.cts.fasttack.admin.web.data.domain.UserPasswordHistory;
import com.cts.fasttack.admin.web.data.list.UserListFilter;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.dao.PageCriteria;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<String, User> implements UserDao {

    @Autowired
    private AdminWebSecurityParameters adminWebSecurityParameters;

    @Autowired
    private UserPasswordHistoryDao userPasswordHistoryDao;

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public boolean isPasswordEqualsForUser(String username, String password) {
        return ((Number) getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("username", username).ignoreCase())
                .add(Restrictions.eq("password", password))
                .setProjection(Projections.count("id"))
                .setMaxResults(1)
                .uniqueResult())
                .intValue() > 0;
    }

    @Override
    public int changePassword(String username, String password, Date changeDate) {
        int updatedCount = getSession().createQuery("UPDATE User SET password = :password, pwdchdate = :pwdchdate, restore_pwd_sms_code = null WHERE username = :username")
                .setString("username", username)
                .setString("password", password)
                .setTimestamp("pwdchdate", changeDate)
                .executeUpdate();

        userPasswordHistoryDao.save(new UserPasswordHistory(username, password));

        return updatedCount;
    }

    @Override
    public List<User> listUsers(UserListFilter filter) {
        PageCriteria pageCriteria = createPageCriteria(getEntityClass());
        if (StringUtils.isNotBlank(filter.getUsername())) {
            pageCriteria.add(Restrictions.disjunction()
                    .add(Restrictions.ilike("id", filter.getUsername(), MatchMode.ANYWHERE))
                    .add(Restrictions.ilike("name", filter.getUsername(), MatchMode.ANYWHERE)));
        }
        return pageCriteria.list(filter);
    }

    @Override
    public int authenticateFail(String username) {
        LocalDateTime unlockLocalDate = LocalDateTime.now().plusMinutes(adminWebSecurityParameters.getMinExpireAccountMinutes());
        Date unlockDate = Date.from(unlockLocalDate.atZone(ZoneId.systemDefault()).toInstant());

        return getSession().createSQLQuery("UPDATE " + User.TABLE_NAME + " SET " +
                "logonFailures = logonFailures + 1, " +
                "unlockDate = (CASE WHEN logonFailures >= :maxLogonFailures THEN :unlockDate ELSE unlockDate END), " +
                "smsCode = (CASE WHEN logonFailures >= :maxLogonFailures THEN NULL ELSE smsCode END), " +
                "statcode = (CASE WHEN logonFailures >= :maxLogonFailures AND statcode = :activeStatus THEN :status ELSE statcode END) " +
                "WHERE username = :username")
                .setString("username", username)
                .setInteger("maxLogonFailures", adminWebSecurityParameters.getMaxLogonFailures())
                .setTimestamp("unlockDate", unlockDate)
                .setString("status", UserStatus.TEMP_BLOCKED.getDataBaseValue())
                .setString("activeStatus", UserStatus.ACTIVE.getDataBaseValue())
                .executeUpdate();
    }

    @Override
    public int twoFactorAuthenticationProcess(String username, String smsCode) {
        return getSession().createQuery("UPDATE User SET smsCode = :smsCode WHERE username = :username")
                .setString("username", username)
                .setString("smsCode", smsCode)
                .executeUpdate();
    }

    @Override
    public int createRestorePasswordSmsCode(String username, String smsCode) {
        return getSession().createQuery("UPDATE User SET restore_pwd_sms_code = :smsCode WHERE username = :username")
                .setString("username", username)
                .setString("smsCode", smsCode)
                .executeUpdate();
    }

    @Override
    public boolean checkRestorePasswordSmsCode(String username, String smsCode) {
        return ((Number) getSession().createSQLQuery("SELECT COUNT(username) FROM " + User.TABLE_NAME + " WHERE username = :username AND restore_pwd_sms_code = :smsCode")
                .setString("username", username)
                .setString("smsCode", smsCode)
                .uniqueResult())
                .intValue() == 1;
    }

    @Override
    public int blockOverdueUsers() {
        LocalDate expiredLocalDate = LocalDate.now().minusDays(adminWebSecurityParameters.getMinExpireDaysToChangePassword() + adminWebSecurityParameters.getMinDaysToChangePasswordAfterExpired());
        Date expiredDate = Date.from(expiredLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        /* block users if they overdue time to change password*/
        return getSession().createSQLQuery(
                "UPDATE " + User.TABLE_NAME + " SET STATCODE = :status " +
                        "WHERE (SELECT COUNT(uh.USR) FROM " + UserPasswordHistory.TABLE_NAME + " uh WHERE uh.USR = USERNAME AND DATETIME > :expiredDate) = 0")
                .setTimestamp("expiredDate", expiredDate)
                .setString("status", UserStatus.BLOCKED.getDataBaseValue())
                .executeUpdate();
    }

    @Override
    public int resetUserPassword() {
        LocalDate expiredLocalDate = LocalDate.now().minusDays(adminWebSecurityParameters.getMinExpireDaysToChangePassword());
        Date expiredDate = Date.from(expiredLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        /* set force need to change password due to next login */
        return getSession().createSQLQuery(
                "UPDATE " + User.TABLE_NAME + " SET need_reset_password = :needResetPasswordSet " +
                        "WHERE need_reset_password = :needResetPasswordWhere AND STATCODE = :status AND (" +
                        "SELECT COUNT(uh.USR) FROM " + UserPasswordHistory.TABLE_NAME + " uh WHERE uh.USR = USERNAME AND DATETIME > :expiredDate) = 0 ")
                .setString("status", UserStatus.ACTIVE.getDataBaseValue())
                .setTimestamp("expiredDate", expiredDate)
                .setBoolean("needResetPasswordSet", true)
                .setBoolean("needResetPasswordWhere", false)
                .executeUpdate();
    }

    @Override
    public int getFailuresCount(String username) {
        return ((Number) getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("username", username))
                .setProjection(Projections.property("logonFailures"))
                .uniqueResult())
                .intValue();
    }
}
