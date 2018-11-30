package com.cts.fasttack.jms.dto;

/**
 * Response from queues in bank
 *
 * @author a.lipavets
 */
public class BankJmsResponseDto {
    private String code;
    private String errorMessage;

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
