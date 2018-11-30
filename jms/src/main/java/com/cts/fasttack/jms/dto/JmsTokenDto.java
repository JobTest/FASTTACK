package com.cts.fasttack.jms.dto;

import java.util.List;

/**
 * @author a.lipavets
 */
public class JmsTokenDto {
    private String tokenUniqueReference;

    private String status;

    private String tokenExpiry;

    private List<String> suspendedBy;

    /* getters and setters */

    public String getTokenUniqueReference() {
        return tokenUniqueReference;
    }

    public void setTokenUniqueReference(String tokenUniqueReference) {
        this.tokenUniqueReference = tokenUniqueReference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTokenExpiry() {
        return tokenExpiry;
    }

    public void setTokenExpiry(String tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }

    public List<String> getSuspendedBy() {
        return suspendedBy;
    }

    public void setSuspendedBy(List<String> suspendedBy) {
        this.suspendedBy = suspendedBy;
    }
}
