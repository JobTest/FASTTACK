package com.cts.fasttack.admin.web.data.domain;

import com.cts.fasttack.common.core.data.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CARD_PRODUCT")
public class CardProduct implements Identifiable<String> {

    @Id
    @Column(name = "PRODUCT_CONFIG_ID")
    private String productConfigId;

    @Column(name = "BEGIN_RANGE")
    private Long beginRange;

    @Column(name = "END_RANGE")
    private Long endRange;

    @Transient
    private boolean isNew = false;

    @Override
    public String getId() {
        return productConfigId;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public String getProductConfigId() {
        return productConfigId;
    }

    public void setProductConfigId(String productConfigId) {
        this.productConfigId = productConfigId;
    }

    public Long getBeginRange() {
        return beginRange;
    }

    public void setBeginRange(Long beginRange) {
        this.beginRange = beginRange;
    }

    public Long getEndRange() {
        return endRange;
    }

    public void setEndRange(Long endRange) {
        this.endRange = endRange;
    }
}
