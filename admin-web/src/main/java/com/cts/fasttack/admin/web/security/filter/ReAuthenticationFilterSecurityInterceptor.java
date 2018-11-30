package com.cts.fasttack.admin.web.security.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import com.cts.fasttack.admin.web.security.auth.ReAuthenticationCredentialsToken;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;
import com.cts.fasttack.admin.web.security.service.CurrentUserService;
import com.cts.fasttack.admin.web.security.service.UserAuthoritiesHolder;

/**
 * Filter which reAuthenticate
 *
 * @author Anton Leliuk
 */
public class ReAuthenticationFilterSecurityInterceptor implements Filter {

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserAuthoritiesHolder userAuthoritiesHolder;

    @Autowired
    private CurrentUserService currentUserService;

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        reAuthenticateIfRequired(request);
        filterChain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    private synchronized void reAuthenticateIfRequired(ServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserAuthoritiesDto) {
            boolean doReAuthenticate = !userAuthoritiesHolder.isCurrentUserAuthoritiesUpToDate();
            if (doReAuthenticate) {
                try {
                    UserAuthoritiesDto user = currentUserService.getCurrentUser();
                    ReAuthenticationCredentialsToken token = new ReAuthenticationCredentialsToken(user.getUsername());
                    token.setDetails(authentication.getDetails());
                    authentication = authenticationManager.authenticate(token);
                } catch (AuthenticationException e) {
                    userAuthoritiesHolder.removeAuthorities(RequestContextHolder.currentRequestAttributes().getSessionId());
                    throw e;
                }
                SecurityContextHolder.getContext().setAuthentication(authentication);
                userAuthoritiesHolder.refreshAuthorities(request);
            }
        }
    }
}
