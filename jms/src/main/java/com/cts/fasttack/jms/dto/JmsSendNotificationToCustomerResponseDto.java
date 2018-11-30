package com.cts.fasttack.jms.dto;

public class JmsSendNotificationToCustomerResponseDto {

    private String requestId;

    private String code;

    private String errorMessage;

    public JmsSendNotificationToCustomerResponseDto() {

    }

    public JmsSendNotificationToCustomerResponseDto(String requestId, String code, String errorMessage) {
        this.requestId = requestId;
        this.code = code;
        this.errorMessage = errorMessage;
    }

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
