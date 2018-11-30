package com.cts.fasttack.admin.web.data.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import com.cts.fasttack.admin.web.data.dict.UserStatus;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.common.core.util.CustomJsonDateDeserializer;
import com.cts.fasttack.common.core.util.CustomJsonDateSerializer;
import com.cts.fasttack.admin.web.validation.common.UniqueIdentifier;
import com.cts.fasttack.admin.web.validation.operation.EntityCreateOperation;
import com.cts.fasttack.admin.web.validation.operation.EntityPasswordCheckHistoryOperation;
import com.cts.fasttack.admin.web.validation.operation.EntityPasswordRequiredOperation;
import com.cts.fasttack.admin.web.validation.operation.UsernameExistsOperation;
import com.cts.fasttack.admin.web.validation.user.UserPasswordConstraint;
import com.cts.fasttack.admin.web.validation.user.UserPasswordHistoryCheck;
import com.cts.fasttack.admin.web.validation.user.UsernameHistoryCheck;
import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@UserPasswordHistoryCheck(groups = EntityPasswordCheckHistoryOperation.class)
@UserPasswordConstraint(groups = EntityPasswordRequiredOperation.class, message = "{cts.validation.message.password}")
public class UserDto extends IdentifierDto<String> implements UserPasswordAwareDto {

    private boolean _new = false;

    @NotEmpty
    @UsernameHistoryCheck(groups = UsernameExistsOperation.class)
    @UniqueIdentifier(groups = EntityCreateOperation.class, service = UserService.class, message = "{users.validation.unique}")
    private String username;

    @NotEmpty(groups = {EntityPasswordRequiredOperation.class})
    private String password;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String name;

    @JsonDeserialize(using = CustomJsonDateDeserializer.DateTime.class)
    @JsonSerialize(using = CustomJsonDateSerializer.DateTime.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date regDate;

    private UserStatus status;

    @JsonDeserialize(using = CustomJsonDateDeserializer.DateTime.class)
    @JsonSerialize(using = CustomJsonDateSerializer.DateTime.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date unlockDate;

    @JsonDeserialize(using = CustomJsonDateDeserializer.DateTime.class)
    @JsonSerialize(using = CustomJsonDateSerializer.DateTime.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date pwdchDate;

    @JsonDeserialize(using = CustomJsonDateDeserializer.DateTime.class)
    @JsonSerialize(using = CustomJsonDateSerializer.DateTime.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date lastlogonDate;

    private int logonFailures;

    @NotEmpty(message = "{users.validation.empty.role}")
    private Set<RoleDto> roles = new HashSet<>();

    private boolean needResetPassword;

    @Override
    public void setId(String id) {
        super.setId(id);
        this.setUsername(id);
    }

    @Override
    public String getId() {
        return username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String getNewPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public UserStatus getStatus() {
        return status;
    }

    public String getStatusCaption() {
        return status != null ? status.getCaption() : null;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Date getUnlockDate() {
        return unlockDate;
    }

    public void setUnlockDate(Date unlockDate) {
        this.unlockDate = unlockDate;
    }

    public Date getPwdchDate() {
        return pwdchDate;
    }

    public void setPwdchDate(Date pwdchDate) {
        this.pwdchDate = pwdchDate;
    }

    public Date getLastlogonDate() {
        return lastlogonDate;
    }

    public void setLastlogonDate(Date lastlogonDate) {
        this.lastlogonDate = lastlogonDate;
    }

    public int getLogonFailures() {
        return logonFailures;
    }

    public void setLogonFailures(int logonFailures) {
        this.logonFailures = logonFailures;
    }

    @Override
    public boolean isNew() {
        return _new;
    }

    public void setNew(boolean new_){
        _new = new_;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    public String getRoleDescriptions() {
        return this.roles.stream().map(RoleDto::getDescription).collect(Collectors.joining(", "));
    }

    public List<String> getRoleCodes() {
        return this.roles.stream().map(RoleDto::getId).collect(Collectors.toList());
    }

    public boolean isNeedResetPassword() {
        return needResetPassword;
    }

    public void setNeedResetPassword(boolean needResetPassword) {
        this.needResetPassword = needResetPassword;
    }
}
