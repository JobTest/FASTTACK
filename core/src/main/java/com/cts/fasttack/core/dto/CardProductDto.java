package com.cts.fasttack.core.dto;


import com.cts.fasttack.common.core.dto.IdentifierDto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class CardProductDto extends IdentifierDto<Long> implements Comparable<CardProductDto> {

    private Long id;

    private String productConfigId;

    private Long beginRange;

    private Long endRange;

    private Long length;

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

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
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

    @Override
    public int compareTo(CardProductDto that) {
        length = endRange - beginRange;

        if ((id) > (that.id))
            return 1;
        if ((id) < (that.id))
            return -1;
        return 0;
    }

    public static void sortByLengthRange(List<CardProductDto> cardProductDtos) {
        Collections.sort(cardProductDtos, new Comparator<CardProductDto>() {
            @Override
            public int compare(CardProductDto o1, CardProductDto o2) {
                o1.setLength(o1.getEndRange()-o1.getBeginRange());
                o2.setLength(o2.getEndRange()-o2.getBeginRange());

                if ((o1.getLength()) > (o2.getLength()))
                    return 1;
                if ((o1.getLength()) < (o2.getLength()))
                    return -1;
                return 0;
            }});
    }

    @Override
    public String toString() {
        return "{" +
                "Range='" + productConfigId + '\'' +
                ", length=" + length +
                ", begin=" + beginRange +
                ", end=" + endRange +
                '}';
    }
}
