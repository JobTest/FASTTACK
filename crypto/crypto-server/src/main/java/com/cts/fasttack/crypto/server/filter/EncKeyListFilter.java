package com.cts.fasttack.crypto.server.filter;

import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.crypto.server.data.EncKey;

public class EncKeyListFilter extends ListFilter<EncKey> {

    private String refCode;

    private String keyType;

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }


}
