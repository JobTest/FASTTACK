package com.cts.fasttack.admin.web.security.userdetails;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.config.context.parameter.AdminWebSecurityParameters;
import com.cts.fasttack.admin.web.data.dto.UserDto;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;
import com.cts.fasttack.common.core.exception.BusinessLogicException;

@Component
public class UserPreAuthenticationChecks implements UserDetailsChecker {

    @Autowired
    private AdminWebSecurityParameters adminWebSecurityParameters;

    public void check(UserDetails userDetails) {
        UserAuthoritiesDto user = (UserAuthoritiesDto) userDetails;

        if (isLocked(user)) {
            throw new LockedException("User account is locked");
        }
        if (isBlocked(user)) {
            throw new DisabledException("User account is disabled");
        }
    }

    public void checkUser(UserDto user) throws BusinessLogicException {
        if (isLocked(user)) {
            throw new BusinessLogicException("LockedException");
        }

        if (isBlocked(user)) {
            throw new BusinessLogicException("DisabledException");
        }
    }

    private boolean isLocked(UserDto user) {
        return user.getLogonFailures() >= adminWebSecurityParameters.getMaxLogonFailures() || (user.getUnlockDate() != null && new Date().before(user.getUnlockDate()));
    }

    private boolean isBlocked(UserDto user) {
        return user.getStatus().isBlocked();
    }
}
