package com.cts.fasttack.admin.web.data.dto;

/**
 * Identifier for Token Info
 *
 * @author Dmitry Koval
 */
public class TokenInfoId {

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
