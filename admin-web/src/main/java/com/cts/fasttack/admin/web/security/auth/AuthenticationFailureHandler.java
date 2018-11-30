package com.cts.fasttack.admin.web.security.auth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import com.cts.fasttack.admin.web.config.AdminWebApplication;
import com.cts.fasttack.admin.web.config.context.parameter.AdminWebSecurityParameters;
import com.cts.fasttack.admin.web.security.AjaxDetectionHelper;
import com.cts.fasttack.admin.web.security.data.AuthenticationResponseDto;
import com.cts.fasttack.admin.web.security.exception.TwoFactorAuthenticationException;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.admin.web.service.impl.RandomSequenceGeneratorRepository;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.messages.MessageSourceService;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;
import com.cts.fasttack.sms.client.rest.SmsRestClient;

public class AuthenticationFailureHandler extends ExceptionMappingAuthenticationFailureHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private AlertLogService alertLogService;

    @Autowired
    private MessageSourceService messageSourceService;

    @Autowired
    private SmsRestClient smsRestClient;

    @Autowired
    private AdminWebSecurityParameters adminWebSecurityParameters;

    @Autowired
    private RandomSequenceGeneratorRepository randomSequenceGeneratorRepository;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        AuthenticationResponseDto responseDto = new AuthenticationResponseDto();
        String username = request.getParameter("j_username");
        String defaultException = exception.getClass().getSimpleName();
        boolean needChangePassword = false;
        boolean requiredOtp = false;

        if (exception instanceof TwoFactorAuthenticationException) {
            TwoFactorAuthenticationException tfe = (TwoFactorAuthenticationException) exception;
            requiredOtp = tfe.isNeedSendSms();
            needChangePassword = tfe.isNeedChangePassword();
            if (tfe.isNeedSendSms()) {
                String smsCode = randomSequenceGeneratorRepository.generate();
                // если включена Two factor authentication, то сначала отправим код через СМС, а только потом проверим пароль
                try {
                    Map<String, Object> parametersTemplate = new HashMap<>();
                    parametersTemplate.put("code", smsCode);
                    smsRestClient.send("AUTHENTICATION", tfe.getPhone(), parametersTemplate);
                } catch (ServiceException e) {
                    defaultException = "common.error.message";
                    requiredOtp = false;
                }
                userService.twoFactorAuthenticationProcess(username, smsCode);
            }
        } else {
            try {
                int failuresCount = userService.authenticateFail(username);
                /* Write to alertLog every time before limit is exceeded */
                if (failuresCount != -1 && failuresCount <= adminWebSecurityParameters.getMaxLogonFailures()) {
                    alertLogService.save(new AlertLogDto()
                            .event("AUTHENTICATION_FAIL")
                            .data(messageSourceService.getMessage("login.fail", username))
                            .originator(AdminWebApplication.ORIGINATOR));
                }
            } catch (Exception e) {
                defaultException = "common.error.message";
                requiredOtp = false;
            }
        }

        if (AjaxDetectionHelper.isAjax(request)) {
            responseDto.setSuccess(false);
            responseDto.setNeedChangePassword(needChangePassword);
            responseDto.setException(defaultException);
            responseDto.setRequiredOtp(requiredOtp);

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            try {
                response.getWriter().print(JsonUtil.toJson(responseDto));
            } catch (ServiceException e) {
                throw new ServletException(e);
            }
            response.getWriter().flush();
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
