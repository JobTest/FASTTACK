package com.cts.fasttack.admin.web.security.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class ReAuthenticationCredentialsToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = -7994355991068814935L;

	private String username;

    public ReAuthenticationCredentialsToken(String username) {
        super(null);
        this.username = username;
    }

    @Override
    public Object getCredentials() {
        return username;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }
}
