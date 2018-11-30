package com.cts.fasttack.admin.web.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.cts.fasttack.common.core.data.Identifiable;

@Entity
@Table(name = "CARD_PRODUCT")
public class CardProduct implements Identifiable<Long> {

    @Id
    @GenericGenerator(
            name = "CARD_PRODUCT_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "CARD_PRODUCT_ID_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARD_PRODUCT_ID_SEQ")
    private Long id = -1L;

    @Column(name = "PRODUCT_CONFIG_ID")
    private String productConfigId;

    @Column(name = "BEGIN_RANGE")
    private Long beginRange;

    @Column(name = "END_RANGE")
    private Long endRange;

    @Override
    public boolean isNew() {
        return id == null || id < 1;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
