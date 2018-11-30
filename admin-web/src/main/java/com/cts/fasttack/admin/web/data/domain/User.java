package com.cts.fasttack.admin.web.data.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import com.cts.fasttack.admin.web.data.dict.UserStatus;
import com.cts.fasttack.common.core.data.Identifiable;

@Entity
@Table(name = User.TABLE_NAME)
public class User implements Identifiable<String> {

    public static final String TABLE_NAME = "USRDET";

    @Id
    private String username;

    @Column(name = "passwd")
    private String password;

    /**
     * Номер телефона
     */
    @Column
    private String phone;

    /**
     * ФИО
     */
    @Column
    private String name;

    /**
     * Дата регистрации
     */
    @Column(name = "regdate")
    private Date regDate;

    @Column(name = "statcode")
    @Type(type = "com.cts.fasttack.admin.web.data.domain.mapper.UserStatusMapper")
    private UserStatus status;

    /**
     * Дата срока действия блокировки
     */
    @Column(name = "unlockdate")
    private Date unlockDate;

    /**
     * Дата последней смены пароля
     */
    @Column(name = "pwdchdate")
    private Date pwdchDate;

    /**
     * Дата последнего входа в систему
     */
    @Column(name = "lastlogondate")
    private Date lastlogonDate;

    /**
     * Число неверно введённых попыток ввода логина/пароля и (или) кода подтверждения из SMS при входе в систему. После успешного входа счётчик обнуляется.
     */
    @Column(name = "logonfailures")
    private int logonFailures;

    @Column(name = "smscode")
    private String smsCode;

    /**
     * Неперсистентное свойство, которе, если установлено в true, сигнализирует о том, что объект еще не сохранен в БД.
     */
    @Transient
    private boolean _new = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USR_USRROLE", joinColumns = {
            @JoinColumn(name = "username", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "rolecode",
                    nullable = false, updatable = false)})
    private Set<Role> roles = new HashSet<>();

    /**
     * Признак о необходимости сбросить пароль при входе
     */
    @Column(name = "need_reset_password")
    private boolean needResetPassword;

    /**
     * Getters and Setters
     */
    @Override
    public String getId() {
        return username;
    }

    public String getUsername() {
        return username;
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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regdate) {
        this.regDate = regdate;
    }

    public UserStatus getStatus() {
        return status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNew(boolean _new) {
        this._new = _new;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isNeedResetPassword() {
        return needResetPassword;
    }

    public void setNeedResetPassword(boolean needResetPassword) {
        this.needResetPassword = needResetPassword;
    }
}
