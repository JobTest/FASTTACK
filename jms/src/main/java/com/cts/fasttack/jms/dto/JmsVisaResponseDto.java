package com.cts.fasttack.jms.dto;

/**
 * Common fields for VISA JMS response DTO.
 *
 * @author v.semerkov
 */
public abstract class JmsVisaResponseDto {

    /**
     * Valid values:
     * <ul>
     * <li>00 – Success</li>
     * <li>01 – Failure</li>
     * </ul>
     * <p>
     * Default value: "00".
     */
    private String actionCode = "00";

    /**
     * Error code
     */
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
