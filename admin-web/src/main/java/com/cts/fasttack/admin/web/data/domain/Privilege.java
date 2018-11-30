package com.cts.fasttack.admin.web.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import com.cts.fasttack.common.core.data.Identifiable;

@Entity
@Table(name = "USRPRIV")
public class Privilege implements Identifiable<String>, Comparable<Privilege> {

    @Id
    @Column(name = "privcode")
    private String id;

    @Column(name = "descr")
    private String description;

    public Privilege() {}

    public Privilege(String id, String description) {
        setId(id);
        setDescription(description);
    }

    @Override
    public int compareTo(Privilege o) {
        if (o != null) {
            return getId().compareToIgnoreCase(o.getId());
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Privilege)) {
            return false;
        }
        Privilege other = (Privilege) obj;
        return getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
        return StringUtils.isNotEmpty(id);
    }
}
