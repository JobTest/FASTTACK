package com.cts.fasttack.admin.web.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import com.cts.fasttack.admin.web.converter.UserDtoToDomainConverter;
import com.cts.fasttack.admin.web.converter.UserToAuthoritiesDtoConverter;
import com.cts.fasttack.admin.web.converter.UserToDtoConverter;
import com.cts.fasttack.admin.web.dao.RoleDao;
import com.cts.fasttack.admin.web.dao.UserDao;
import com.cts.fasttack.admin.web.dao.UserPasswordHistoryDao;
import com.cts.fasttack.admin.web.data.dict.UserStatus;
import com.cts.fasttack.admin.web.data.domain.User;
import com.cts.fasttack.admin.web.data.domain.UserPasswordHistory;
import com.cts.fasttack.admin.web.data.dto.UserDto;
import com.cts.fasttack.admin.web.data.list.RoleListFilter;
import com.cts.fasttack.admin.web.data.list.UserListFilter;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;
import com.cts.fasttack.admin.web.security.service.UserAuthoritiesHolder;
import com.cts.fasttack.admin.web.security.userdetails.UserPreAuthenticationChecks;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.admin.web.util.DigestEncoderHelper;
import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.logging.dto.ChangeLogMessage;
import com.cts.fasttack.logging.service.ChangeLogger;
import com.cts.fasttack.sms.client.rest.SmsRestClient;

@Service("userService")
public class UserServiceImpl extends GenericServiceImpl<String, UserDto, User, UserDao> implements UserService {

    @Autowired
    private UserAuthoritiesHolder userAuthoritiesHolder;

    @Autowired
    private RandomSequenceGeneratorRepository randomSequenceGeneratorRepository;

    @Autowired
    private ChangeLogger changeLogger;

    @Autowired
    private UserPreAuthenticationChecks userPreAuthenticationChecks;

    @Autowired
    private UserToAuthoritiesDtoConverter userToAuthoritiesDtoConverter;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserPasswordHistoryDao userPasswordHistoryDao;

    @Autowired
    private SmsRestClient smsRestClient;

    public UserServiceImpl(UserDao dao, UserToDtoConverter domainToDtoConverter, UserDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto get(String id) {
        User domain = dao.get(id);
        if (domain == null) {
            throw new BusinessLogicException(HttpStatus.NOT_FOUND, "user.not.found");
        }
        return domainToDtoConverter.convert(domain);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dao.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }
        UserAuthoritiesDto result = userToAuthoritiesDtoConverter.convert(user);
        result.setPassword(user.getPassword());
        result.setSmsCode(user.getSmsCode());
        result.setPasswordExpire(userPasswordHistoryDao.isPasswordExpire(username));
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResult<UserDto> listUsers(UserListFilter filter) {
        List<User> list = dao.listUsers(filter);
        List<UserDto> dtos = domainToDtoConverter.convert(list);
        return new QueryResult<>(dtos, filter);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isPasswordEqualsForUser(String username, String password) {
        return dao.isPasswordEqualsForUser(username, password);
    }

    @Override
    @Transactional
    public boolean changePassword(String username, String password) {
        /* if user not authenticated or user change password himself then we need to set current date to {@link AbstractUser#pwdchDate} */
        Date changeDate = null;
        if (getCurrentUser() == null || StringUtils.equals(getCurrentUser().getUsername(), username)) {
            changeDate = new Date();
        }
        return dao.changePassword(username, DigestEncoderHelper.encode(password, username), changeDate) == 1;
    }

    @Override
    @Transactional
    public boolean resetPassword(String username, String password) {
        boolean result = changePassword(username, password);
        if (result) {
            User user = dao.get(username);
            changeLogger.info("RESET_PASSWORD", new ChangeLogMessage("USER", user.getUsername()).fields(user.getName(), user.getStatus().getCaption(), String.valueOf(user.getLogonFailures())));
            user.setLogonFailures(0);
            user.setUnlockDate(null);
            user.setNeedResetPassword(false);
            dao.save(user);
        }
        return result;
    }

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) throws BusinessLogicException {
        User user = dtoToDomainConverter.convert(userDto);
        user.setNew(true);
        user.setRegDate(new Date());
        user.setPassword(DigestEncoderHelper.encode(userDto.getPassword(), user.getUsername()));

        updateReferences(user, userDto);

        User saved = dao.save(user);
        userPasswordHistoryDao.save(new UserPasswordHistory(user.getUsername(), user.getPassword()));
        return domainToDtoConverter.convert(saved);
    }

    @Override
    @Transactional
    public UserDto save(UserDto userDto) throws BusinessLogicException {
        User user = getDomainUser(userDto.getUsername());
        if (userDto.getStatus().isActive() && user.getStatus().isBlocked()) {
            user.setNeedResetPassword(true);
        }
        updateReferences(user, userDto);
        dtoToDomainConverter.convertPrimitives(userDto, user);
        changeLogger.info("UPDATE", new ChangeLogMessage("USER", userDto.getUsername()).fields(user.getName(), user.getStatus().getCaption(), String.valueOf(user.getLogonFailures())));
        if (user.getStatus().isActive()) {
            user.setLogonFailures(0);
            user.setUnlockDate(null);
        }
        UserDto saved = domainToDtoConverter.convert(dao.save(user));
        userAuthoritiesHolder.discardAuthoritiesByUser(saved.getId());

        return saved;
    }

    @Override
    @Transactional
    public void delete(String id) throws BusinessLogicException {
        super.delete(id);
        userAuthoritiesHolder.discardAuthoritiesByUser(id);
    }

    @Override
    @Transactional
    public int authenticateFail(String username) {
        int updatedCount = dao.authenticateFail(username);
        if (updatedCount != 1) {
            log.warn("On authenticateFail not updated user details with username = " + username);
            return -1;
        }
        return dao.getFailuresCount(username);
    }

    @Override
    @Transactional
    public void authenticateSuccess(String username) {
        User user = dao.get(username);
        if (user != null) {
            user.setLogonFailures(0);
            user.setUnlockDate(null);
            user.setSmsCode(null);
            user.setLastlogonDate(new Date());
            user.setStatus(UserStatus.ACTIVE);
            dao.save(user);
        } else {
            log.warn("On authenticateSuccess not updated user details with username = " + username);
        }
    }

    @Override
    @Transactional
    public void twoFactorAuthenticationProcess(String username, String smsCode) {
        int updatedCount = dao.twoFactorAuthenticationProcess(username, DigestEncoderHelper.encode(smsCode, username));
        if (updatedCount != 1) {
            log.warn("On twoFactorAuthenticationProcess not updated user details with username = " + username);
        }
    }

    @Override
    @Transactional
    public void createRestorePasswordSmsCode(String username) throws ServiceException, BusinessLogicException {
        UserDto userDto = get(username);
        userPreAuthenticationChecks.checkUser(userDto);
        String smsCode = randomSequenceGeneratorRepository.generate();
        int updatedCount = dao.createRestorePasswordSmsCode(username, DigestEncoderHelper.encode(smsCode, username));
        if (updatedCount != 1) {
            log.warn("On saveRestorePasswordSmsCode not updated user details with username = " + username);
        } else {
            Map<String, Object> parametersTemplate = new HashMap<>();
            parametersTemplate.put("code", smsCode);
			try {
				smsRestClient.send("RESTORE_PASSWORD", userDto.getPhone(), parametersTemplate);
			} catch (ServiceException ex) {
				throw new BusinessLogicException(HttpStatus.INTERNAL_SERVER_ERROR, "admin.SMS_SEND_ERROR");
			}
        }
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkRestorePasswordSmsCode(String username, String smsCode) {
        String encryptedSmsCode = DigestEncoderHelper.encode(smsCode, username);
        return dao.checkRestorePasswordSmsCode(username, encryptedSmsCode);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existPasswordHistory(String username, String password) {
        return userPasswordHistoryDao.existPasswordHistory(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existUsernameHistory(String username) {
        return userPasswordHistoryDao.existUsernameHistory(username);
    }

    @Transactional
    @Override
    public void blockOverdueUserOrResetPassword() {
        int numberOfBlockedUsers = dao.blockOverdueUsers();
        if (log.isInfoEnabled()) {
            log.info("Number of blocked users due to overdue their time to change password - " + numberOfBlockedUsers);
        }
        int numberOfResetPasswordUsers = dao.resetUserPassword();
        if (log.isInfoEnabled()) {
            log.info("Number of users who had reset passwords - " + numberOfResetPasswordUsers);
        }
    }

    private void updateReferences(User domain, UserDto dto) throws BusinessLogicException {
        if (CollectionUtils.isEmpty(dto.getRoles())) {
            domain.setRoles(null);
        } else {
            domain.getRoles().clear();
            domain.getRoles().addAll(roleDao.listRoles(RoleListFilter.builder().roleCodes(dto.getRoleCodes()).unlimited().build()));
        }
    }

    private User getDomainUser(String username) throws BusinessLogicException {
        User loadedUser = dao.get(username);
        if (loadedUser == null) {
            throw new BusinessLogicException(HttpStatus.NOT_FOUND, "User with username '" + username + "' not found.");
        }
        return loadedUser;
    }

}