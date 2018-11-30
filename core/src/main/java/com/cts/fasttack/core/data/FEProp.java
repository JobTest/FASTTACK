package com.cts.fasttack.core.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cts.fasttack.common.core.data.Identifiable;

/**
 * Bank settings.
 * <p>
 * Contains bank parameters, which not included to the main bank entity. Has key-value form.
 *
 * @author v.semerkov
 */
@Entity
@Table(name = "FEPROP")
public class FEProp implements Identifiable<String> {

    @Id
    @Column(name = "PROPNAME")
    private String propName;

    @Column(name = "PROPVALUE")
    private String propValue;

    @Transient
    private boolean isNew = false;

    @Override
    public String getId() {
        return propName;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }
}
