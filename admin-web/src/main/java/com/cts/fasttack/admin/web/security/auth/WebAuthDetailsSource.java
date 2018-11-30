package com.cts.fasttack.admin.web.security.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;


/**
 * Provides a {@link org.springframework.security.core.Authentication#getDetails()} object for a given web request
 *
 * @author n.bizin
 */
public class WebAuthDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthDetails> {

    public WebAuthDetails buildDetails(HttpServletRequest context) {
        return new WebAuthDetails(context);
    }
}
