package com.cts.fasttack.admin.web.data.domain;

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

import com.cts.fasttack.common.core.data.Identifiable;

@Entity
@Table(name = "USRROLE")
public class Role implements Identifiable<String> {

    private static final int DESCRIPTION_MAX_LENGTH = 255;

    @Id
    @Column(name = "rolecode")
    protected String id;

    @Column(name = "descr")
    private String description = "";

    @ManyToMany(
            targetEntity = Privilege.class,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "USRROLE_USRPRIV",
            joinColumns = @JoinColumn(name = "rolecode", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "privcode", nullable = false, updatable = false)
    )
    private Set<Privilege> privileges = new HashSet<>();

    /**
     * Неперсистентное свойство, которе, если установлено в true, сигнализирует о том, что объект еще не сохранен в БД.
     */
    @Transient
    private boolean _new = false;

    public Role() {}

    public Role(String id) {
        this.id = id;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() > DESCRIPTION_MAX_LENGTH) {
            description = description.substring(0, DESCRIPTION_MAX_LENGTH);
        }
        this.description = description;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return _new;
    }

    public void setNew(boolean new_) {
        _new = new_;
    }
}
