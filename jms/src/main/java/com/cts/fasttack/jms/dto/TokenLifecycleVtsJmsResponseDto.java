package com.cts.fasttack.jms.dto;

/**
 * @author Dmitry Koval
 */
public class TokenLifecycleVtsJmsResponseDto {

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
