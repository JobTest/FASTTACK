package com.cts.fasttack.admin.web.security.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import com.cts.fasttack.admin.web.security.AjaxDetectionHelper;
import com.cts.fasttack.admin.web.security.data.AuthenticationResponseDto;
import com.cts.fasttack.admin.web.security.service.UserAuthoritiesHolder;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.util.JsonUtil;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthoritiesHolder userAuthoritiesHolder;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        userService.authenticateSuccess(authentication.getName());
        userAuthoritiesHolder.refreshAuthorities(request);
        if (AjaxDetectionHelper.isAjax(request)) {
            response.setStatus(HttpServletResponse.SC_OK);
            try {
                response.getWriter().print(JsonUtil.toJson(new AuthenticationResponseDto()));
            } catch (ServiceException e) {
                throw new ServletException(e);
            }
            response.getWriter().flush();
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
