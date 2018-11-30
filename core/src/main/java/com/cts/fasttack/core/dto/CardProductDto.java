package com.cts.fasttack.core.dto;


import com.cts.fasttack.common.core.dto.IdentifierDto;

import java.util.Objects;

public class CardProductDto extends IdentifierDto<Long> {

    private Long id;

    private String productConfigId;

    private Long beginRange;

    private Long endRange;

    @Override
    public boolean isNew() {
        return id == null || id < 1;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardProductDto that = (CardProductDto) o;
        return Objects.equals(beginRange, that.beginRange) &&
                Objects.equals(endRange, that.endRange);
    }

    @Override
    public int hashCode() {

        return Objects.hash(beginRange, endRange);
    }
}
