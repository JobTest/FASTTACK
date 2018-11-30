package com.cts.fasttack.admin.web.security.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * A holder of selected HTTP details related to a web authentication request
 *
 * @author n.bizin
 */
public class WebAuthDetails extends WebAuthenticationDetails {

	private static final long serialVersionUID = 7438485368020749950L;

	private final String smsCode;

    public WebAuthDetails(HttpServletRequest request) {
        super(request);
        this.smsCode = request.getParameter("j_smscode");
    }

    public String getSmsCode() {
        return smsCode;
    }
}
