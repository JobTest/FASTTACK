package com.cts.fasttack.core.data.list;

import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.core.data.CardProduct;

public class CardProductListFilter extends ListFilter<CardProduct> {

    private String productConfigId;

    public String getProductConfigId() {
        return productConfigId;
    }

    public void setProductConfigId(String productConfigId) {
        this.productConfigId = productConfigId;
    }
}
