package com.cts.fasttack.admin.web.dao;

import java.util.Date;
import java.util.List;

import com.cts.fasttack.admin.web.data.domain.User;
import com.cts.fasttack.admin.web.data.list.UserListFilter;
import com.cts.fasttack.common.core.dao.GenericDao;

public interface UserDao extends GenericDao<String, User> {

    /**
     * Check if user with password exists
     *
     * @param username username
     * @param password password
     */
    boolean isPasswordEqualsForUser(String username, String password);

    /**
     * Change user password
     *
     * @param username   username
     * @param password   new password
     * @param changeDate password change date
     */
    int changePassword(String username, String password, Date changeDate);

    /**
     * List users by filter
     *
     * @param filter user list filter
     * @return {@link java.util.List}&lt;{@link User}&gt;
     */
    List<User> listUsers(UserListFilter filter);

    /**
     * When authenticate fail - do operations with:
     * logonFailures - increase failures to {@code admin.web.security.maxLogonFailures}
     * unlockDate - set unlock date = current date plus {@code admin.web.security.minExpireAccountMinutes}
     *
     * @param username {@link User#username}
     */
    int authenticateFail(String username);

    /**
     * Second step of two factor authentication - save user sms code
     *
     * @param username {@link User#username}
     * @param smsCode  sms code to confirm authenticate {@link User#smsCode}
     */
    int twoFactorAuthenticationProcess(String username, String smsCode);

    /**
     * Create sms code to restore password
     *
     * @param username {@link User#username}
     * @param smsCode  sms code
     */
    int createRestorePasswordSmsCode(String username, String smsCode);

    /**
     * Check restore password sms code with saved code form DB
     * Set sms code = null of user, if return count == 1, then check successful
     *
     * @param username {@link User#username}
     * @param smsCode  sms code
     * @return updated count
     */
    boolean checkRestorePasswordSmsCode(String username, String smsCode);

    /**
     * Get the user count of failures
     *
     * @param username {@link User#username}
     * @return count of failures
     */
    int getFailuresCount(String username);

    /**
     * Block users that overdue their time to change password
     */
    int blockOverdueUsers();

    /**
     * Reset user passwords
     */
    int resetUserPassword();
}
