package com.cts.fasttack.admin.web.security.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import com.cts.fasttack.admin.web.security.AjaxDetectionHelper;

public class AjaxAwareAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private Http403ForbiddenEntryPoint forbiddenEntryPoint = new Http403ForbiddenEntryPoint();

    public AjaxAwareAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if (AjaxDetectionHelper.isAjax(request)) {
            forbiddenEntryPoint.commence(request, response, authException);
        }
        super.commence(request, response, authException);
    }
}
