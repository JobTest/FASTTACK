package com.cts.fasttack.admin.web.security.provider;

import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.cts.fasttack.admin.web.security.auth.DefaultAuthentication;
import com.cts.fasttack.admin.web.security.auth.ReAuthenticationCredentialsToken;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.util.JsonUtil;

public class ReAuthenticationDaoAuthenticationProvider extends UserDaoAuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ReAuthenticationCredentialsToken token = (ReAuthenticationCredentialsToken) authentication;
        UsernamePasswordAuthenticationToken usernameToken = new UsernamePasswordAuthenticationToken(token.getPrincipal(), token.getCredentials());
        usernameToken.setDetails(token.getDetails());
        return super.authenticate(usernameToken);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ReAuthenticationCredentialsToken.class.equals(authentication);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

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
