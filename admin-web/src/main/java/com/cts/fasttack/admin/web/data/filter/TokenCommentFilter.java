package com.cts.fasttack.admin.web.data.filter;

import com.cts.fasttack.common.core.list.ListFilter;

/**
 * @author Dmitry Koval
 */
public class TokenCommentFilter<T> extends ListFilter<T> {

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
