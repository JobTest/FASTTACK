package com.cts.fasttack.admin.web.security.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import com.cts.fasttack.admin.web.security.AjaxDetectionHelper;

public class AjaxAwareAccessDeniedHandler extends AccessDeniedHandlerImpl {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        if (AjaxDetectionHelper.isAjax(request)) {
            // For AJAX requests set the 403 status code without any redirection to error page
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            super.handle(request, response, accessDeniedException);
        }
    }
}
