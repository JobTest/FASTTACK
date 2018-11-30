package com.cts.fasttack.admin.web.security.data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.cts.fasttack.admin.web.data.dto.RoleDto;
import com.cts.fasttack.admin.web.data.dto.UserDto;

public class UserAuthoritiesData {

    private String userId;

    private boolean upToDate;

    private String userIp;

    private Set<String> roles = new HashSet<>();

    public UserAuthoritiesData(UserDto user, String userIp) {
        this(user, true, userIp);
    }

    private UserAuthoritiesData(UserDto user, boolean upToDate, String userIp) {
        this.userId = user.getId();
        this.upToDate = upToDate;
        this.userIp = userIp;
        copyRolesIds(user.getRoles());
    }


    public UserAuthoritiesData upToDate() {
        setUpToDate(true);
        return this;
    }

    public UserAuthoritiesData discard() {
        setUpToDate(false);
        return this;
    }

    private void copyRolesIds(Set<RoleDto> roles) {
        this.roles.addAll(roles.stream().map(RoleDto::getId).collect(Collectors.toList()));
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isUpToDate() {
        return upToDate;
    }

    public void setUpToDate(boolean upToDate) {
        this.upToDate = upToDate;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
