package com.cts.fasttack.admin.web.security.auth;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * Надстройка над {@link UsernamePasswordAuthenticationToken} позволяющая хранить json объект с привилегиями {@link DefaultAuthentication#getAuthorities()}
 */
public class DefaultAuthentication extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 3051239449715752490L;

	/**
     * Привилегии в виде json строки
     */
    private String authoritiesJson;

    public DefaultAuthentication(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public DefaultAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public String getAuthoritiesJson() {
        return authoritiesJson;
    }

    public void setAuthoritiesJson(String authoritiesJson) {
        this.authoritiesJson = authoritiesJson;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return super.getAuthorities();
    }
}
