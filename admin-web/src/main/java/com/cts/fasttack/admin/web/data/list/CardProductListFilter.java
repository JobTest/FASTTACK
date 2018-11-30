package com.cts.fasttack.admin.web.data.list;

import com.cts.fasttack.admin.web.data.dto.CardProductDto;
import com.cts.fasttack.common.core.list.ListFilter;

public class CardProductListFilter extends ListFilter<CardProductDto> {
    private String productConfigId;

    public String getProductConfigId() {
        return productConfigId;
    }

    public void setProductConfigId(String productConfigId) {
        this.productConfigId = productConfigId;
    }
}
