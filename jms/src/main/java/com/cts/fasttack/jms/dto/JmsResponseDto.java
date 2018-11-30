package com.cts.fasttack.jms.dto;

/**
 * Abstract JMS response DTO.
 *
 * @author v.semerkov
 */
public abstract class JmsResponseDto {

    /**
     * Error code
     */
    private String errorCode;

    /**
     * Error message
     */
    private String errorMessage;

    /**
     * Details
     */
    private String details;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
