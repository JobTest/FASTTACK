package com.cts.fasttack.jms.dto;

/**
 * @author Dmitry Koval
 */
public class TokenLifecycleJmsResponse {

    private String codeStatus = "00";

    private String message;

    private String errorCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
