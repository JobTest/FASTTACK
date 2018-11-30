package com.cts.fasttack.jms.dto;

/**
 * Response DTO for getting card and token info.
 */
public class JmsCardDataUpdateResponseDto {

    private String requestId;

    private String code;

    private String errorMessage;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
