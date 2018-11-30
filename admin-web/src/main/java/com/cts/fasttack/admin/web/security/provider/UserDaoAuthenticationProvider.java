package com.cts.fasttack.admin.web.security.provider;

import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.cts.fasttack.admin.web.config.context.parameter.AdminWebSecurityParameters;
import com.cts.fasttack.admin.web.security.auth.DefaultAuthentication;
import com.cts.fasttack.admin.web.security.auth.WebAuthDetails;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;
import com.cts.fasttack.admin.web.security.exception.TwoFactorAuthenticationException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.util.JsonUtil;

/**
 * User dao authentication provider with Two factor authentication checks
 *
 * @author n.bizin
 */
public class UserDaoAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    private AdminWebSecurityParameters adminWebSecurityParameters;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        super.additionalAuthenticationChecks(userDetails, authentication);

        UserAuthoritiesDto user = (UserAuthoritiesDto) userDetails;
        if (adminWebSecurityParameters.isTwoFactorAuthenticationEnabled()) {
            WebAuthDetails webAuthDetails = (WebAuthDetails) authentication.getDetails();

            if (StringUtils.isEmpty(webAuthDetails.getSmsCode())) {
                throw new TwoFactorAuthenticationException(user.getPhone(), user.getPwdchDate() == null, true);
            }

            if (!getPasswordEncoder().isPasswordValid(user.getSmsCode(), webAuthDetails.getSmsCode(), userDetails.getUsername())) {
                throw new AuthenticationServiceException("Sms code not accepted");
            }
        }
        if (user.getPwdchDate() == null || user.isNeedResetPassword()) {
            throw new TwoFactorAuthenticationException(user.getPhone(), true, false);
        }
    }

    @Override
    protected Authentication createSuccessAuthentication(Object principal, Authentication authentication, UserDetails user) {
        DefaultAuthentication result = new DefaultAuthentication(principal, authentication.getCredentials(), user.getAuthorities());
        result.setDetails(authentication.getDetails());
        try {
            result.setAuthoritiesJson(JsonUtil.toJson(user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList())));
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
