package com.cts.fasttack.admin.web.data.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.context.SecurityContextHolder;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;
import com.cts.fasttack.admin.web.validation.user.ProfilePasswordMatching;
import com.cts.fasttack.admin.web.validation.user.UserPasswordConstraint;
import com.cts.fasttack.admin.web.validation.user.UserPasswordHistoryCheck;

@ProfilePasswordMatching
@UserPasswordHistoryCheck
@UserPasswordConstraint(message = "{cts.validation.message.password}")
public class ProfileDto implements UserPasswordAwareDto {

    private String username;

    @NotEmpty
    private String currentPassword;

    @NotEmpty
    private String newPassword;

    public ProfileDto() {
        this.username = ((UserAuthoritiesDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    /** getters and setters */

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    @Override
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
