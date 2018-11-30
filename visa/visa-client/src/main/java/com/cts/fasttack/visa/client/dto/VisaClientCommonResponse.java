package com.cts.fasttack.visa.client.dto;

/**
 * @author a.lipavets
 */
public abstract class VisaClientCommonResponse {

    private String actionCode;

    private String errorCode;

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
