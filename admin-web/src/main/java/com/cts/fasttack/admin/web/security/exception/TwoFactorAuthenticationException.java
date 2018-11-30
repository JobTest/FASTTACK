package com.cts.fasttack.admin.web.security.exception;

import org.springframework.security.authentication.InsufficientAuthenticationException;

public class TwoFactorAuthenticationException extends InsufficientAuthenticationException {

	private static final long serialVersionUID = 1164010311318330058L;

	private String phone;

    private boolean needChangePassword;

    private boolean needSendSms;

    public TwoFactorAuthenticationException(String msg) {
        super(msg);
    }

    public TwoFactorAuthenticationException(String phone, boolean needChangePassword) {
        super("Two factor authentication exception");
        this.phone = phone;
        this.needChangePassword = needChangePassword;
    }

    public TwoFactorAuthenticationException(String phone, boolean needChangePassword, boolean needSendSms) {
        this(phone, needChangePassword);
        this.needSendSms = needSendSms;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isNeedChangePassword() {
        return needChangePassword;
    }

    public boolean isNeedSendSms() {
        return needSendSms;
    }
}
