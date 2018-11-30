package com.cts.fasttack.admin.web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.cts.fasttack.admin.web.data.domain.User;
import com.cts.fasttack.admin.web.data.dto.UserDto;
import com.cts.fasttack.admin.web.data.list.UserListFilter;
import com.cts.fasttack.admin.web.security.service.CurrentUserService;
import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.service.GenericService;

public interface UserService extends UserDetailsService, GenericService<String, UserDto, User>, CurrentUserService {

    /**
     * Get list of users by filter
     *
     * @param filter {@link UserListFilter}
     * @return {@link QueryResult}&lt;{@link UserDto}&gt;
     */
    QueryResult<UserDto> listUsers(UserListFilter filter);

    /**
     * Create new user
     *
     * @param userDto {@link UserDto}
     * @return {@link UserDto}
     */
    UserDto createUser(UserDto userDto) throws BusinessLogicException;

    /**
     * Check if user with password exists.
     *
     * @param username username.
     * @param password password.
     */
    boolean isPasswordEqualsForUser(String username, String password);

    /**
     * Change user password
     *
     * @param username username
     * @param password new password
     */
    boolean changePassword(String username, String password);


    /**
     * Reset user password in restore process
     */
    boolean resetPassword(String username, String password);

    /**
     * When authenticate fail - do operations with:
     * logonFailures - increase failures to {@code admin.web.security.maxLogonFailures}
     * unlockDate - set unlock date = current date plus {@code admin.web.security.minExpireAccountMinutes}
     *
     * @param username {@link User#username}
     * @return failures count
     */
    int authenticateFail(String username);

    /**
     * When authenticate success - do operations:
     * Reset {@link User#logonFailures} to 0
     * Reset {@link User#unlockDate} to null
     * Set {@link User#lastlogonDate} to current date
     *
     * @param username {@link User#username}
     */
    void authenticateSuccess(String username);

    /**
     * Second step of two factor authentication - save user sms code.
     *
     * @param username {@link User#username}.
     * @param smsCode  sms code to confirm authenticate {@link User#smsCode}.
     */
    void twoFactorAuthenticationProcess(String username, String smsCode);

    /**
     * Create sms code to restore password.
     *
     * @param username {@link User#username}.
     */
    void createRestorePasswordSmsCode(String username) throws ServiceException, BusinessLogicException;

    /**
     * Check restore password sms code with saved code form DB.
     * If updated count == 1, then check successful.
     *
     * @param username {@link User#username}.
     * @param smsCode  sms code.
     */
    boolean checkRestorePasswordSmsCode(String username, String smsCode);

    /**
     * Check that password not the same that previous last 'n' passwords.
     *
     * @param username {@link User#username}.
     * @param password {@link User#password}.
     * @return true if exist password in password change history
     */
    boolean existPasswordHistory(String username, String password);

    /**
     * Check that password not exists before
     *
     * @param username new username
     * @return true if exists username in history
     */
    boolean existUsernameHistory(String username);

    /**
     * Block users or reset password
     */
    void blockOverdueUserOrResetPassword();
}