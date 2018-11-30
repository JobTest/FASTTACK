package com.cts.fasttack.admin.web.config.context.parameter;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@ConfigurationProperties("spring.admin.web.security")
public class AdminWebSecurityParameters {

    @NotNull
    private Integer minExpireAccountMinutes;

    @NotNull
    private Integer maxLogonFailures;

    @NotNull
    private Integer minExpireDaysToChangePassword;

    @NotNull
    private Integer minExpireDaysToNotifyChangePassword;

    @NotNull
    private Integer minDaysToChangePasswordAfterExpired;

    @NotNull
    private Integer checkLastChangePasswordCount;

    private boolean twoFactorAuthenticationEnabled;

    public Integer getMinExpireAccountMinutes() {
        return minExpireAccountMinutes;
    }

    public void setMinExpireAccountMinutes(Integer minExpireAccountMinutes) {
        this.minExpireAccountMinutes = minExpireAccountMinutes;
    }

    public Integer getMaxLogonFailures() {
        return maxLogonFailures;
    }

    public void setMaxLogonFailures(Integer maxLogonFailures) {
        this.maxLogonFailures = maxLogonFailures;
    }

    public Integer getMinExpireDaysToNotifyChangePassword() {
        return minExpireDaysToNotifyChangePassword;
    }

    public void setMinExpireDaysToNotifyChangePassword(Integer minExpireDaysToNotifyChangePassword) {
        this.minExpireDaysToNotifyChangePassword = minExpireDaysToNotifyChangePassword;
    }

    public Integer getMinExpireDaysToChangePassword() {
        return minExpireDaysToChangePassword;
    }

    public void setMinExpireDaysToChangePassword(Integer minExpireDaysToChangePassword) {
        this.minExpireDaysToChangePassword = minExpireDaysToChangePassword;
    }

    public Integer getMinDaysToChangePasswordAfterExpired() {
        return minDaysToChangePasswordAfterExpired;
    }

    public void setMinDaysToChangePasswordAfterExpired(Integer minDaysToChangePasswordAfterExpired) {
        this.minDaysToChangePasswordAfterExpired = minDaysToChangePasswordAfterExpired;
    }

    public Integer getCheckLastChangePasswordCount() {
        return checkLastChangePasswordCount;
    }

    public void setCheckLastChangePasswordCount(Integer checkLastChangePasswordCount) {
        this.checkLastChangePasswordCount = checkLastChangePasswordCount;
    }

    public boolean isTwoFactorAuthenticationEnabled() {
        return twoFactorAuthenticationEnabled;
    }

    public void setTwoFactorAuthenticationEnabled(boolean twoFactorAuthenticationEnabled) {
        this.twoFactorAuthenticationEnabled = twoFactorAuthenticationEnabled;
    }
}
