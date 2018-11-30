package com.cts.fasttack.admin.web.security.data;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.cts.fasttack.admin.web.data.dto.UserDto;

public class UserAuthoritiesDto extends UserDto implements UserDetails {

	private static final long serialVersionUID = 7114392001800215612L;

	private String password;

    // indicate that password has expired and user have to change password
    private boolean passwordExpire;

    private String smsCode;

    private Collection<? extends GrantedAuthority> authorities;

    private boolean needResetPassword;

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordExpire(boolean passwordExpire) {
        this.passwordExpire = passwordExpire;
    }

    public boolean isPasswordExpire() {
        return passwordExpire;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isNeedResetPassword() {
        return needResetPassword;
    }

    @Override
    public void setNeedResetPassword(boolean needResetPassword) {
        this.needResetPassword = needResetPassword;
    }
}
