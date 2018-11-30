package com.cts.fasttack.admin.web.data.list;

import com.cts.fasttack.common.core.list.ListFilter;

/**
 * @author Dmitry Koval
 */
public class TokenHistoryFilter<T> extends ListFilter<T> {

    private String tokenRefId;

    private String tokenRequestorId;

    public String getTokenRefId() {
        return tokenRefId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }
}
