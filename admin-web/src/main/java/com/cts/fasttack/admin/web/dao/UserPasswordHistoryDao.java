package com.cts.fasttack.admin.web.dao;

import com.cts.fasttack.admin.web.data.domain.UserPasswordHistory;
import com.cts.fasttack.common.core.dao.GenericDao;

import java.util.List;

public interface UserPasswordHistoryDao extends GenericDao<Long, UserPasswordHistory> {

    /**
     * Check that username not used before
     *
     * @param username new username
     * @return true if username doesn't exists in history
     */
    boolean existUsernameHistory(String username);

    /**
     * Check that password not the same that previous last 'n' passwords
     *
     * @param username username
     * @param password new password
     * @return true if exist password in password change history
     */
    boolean existPasswordHistory(String username, String password);

    /**
     * Check that user have not change password at last 'n' days
     *
     * @param username username
     * @return true if expire
     */
    boolean isPasswordExpire(String username);

    /**
     * List userPasswordHistories by username
     *
     * @param username UserPasswordHistory
     * @return {@link java.util.List}&lt;{@link UserPasswordHistory}&gt;
     */
    List<UserPasswordHistory> listUsernameHistories(String username);
}
