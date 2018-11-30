package com.cts.fasttack.visa.common.dict;

/**
 * @author Dmitry Koval
 */
public enum VisaErrorReasonCode {
    invalidParameter(400, "Input parameters validation failed"),
    invalidRequest(400, "Input request validation failed"),
    serviceError(500, "Server error");

    private int status;

    private String message;

    VisaErrorReasonCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
