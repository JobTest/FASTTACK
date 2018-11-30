package com.cts.fasttack.admin.web.security.data;

public class AuthenticationResponseDto {

    private boolean success = true;

    private String exception;

    private boolean requiredOtp;

    private boolean needChangePassword;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public boolean isRequiredOtp() {
        return requiredOtp;
    }

    public void setRequiredOtp(boolean requiredOtp) {
        this.requiredOtp = requiredOtp;
    }

    public boolean isNeedChangePassword() {
        return needChangePassword;
    }

    public void setNeedChangePassword(boolean needChangePassword) {
        this.needChangePassword = needChangePassword;
    }
}
