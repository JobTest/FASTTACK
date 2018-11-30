package com.cts.fasttack.visa.vnts.server.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cts.fasttack.common.core.dict.VisaErrorCode;


/**
 * RiskInformation object
 * @author a.lipavets
 */
public class RiskInformationDto {

    /**
     * From 0100 f125 (SupportingInformation), dsi02 (Wallet Provider), tag07 (Wallet provider reason codes).
     * Up to 10 2-byte hex reason codes from 01 to 0E, comma separated.
     */
    @Size(max = 100, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    private String wpReasonCodes;

    /**
     * From 0100 f125 (Supporting Information), dsi02 (Wallet Provider), tag08 (Pan Source). 2-byte hex values:
     * 01 – Key entered
     * 02 – On file
     * 03 – Mobile Banking Application
     */
    @Size(max = 2, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "0[1-3]|^$", message = VisaErrorCode.Codes.DATA_ELEMENT_NOT_VALID)
    private String panSource;

    /**
     * From 0100 f125 (Supporting Information), dsi02 (Wallet Provider), tag05 (Wallet Provider Device Score).
     * Valid values: From 1 (least trusted) to 5(most trusted).
     */
    @Size(max = 2, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @Digits(integer = 2, fraction = 0, message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
    @Pattern(regexp = "[1-5]|^$", message = VisaErrorCode.Codes.DATA_ELEMENT_NOT_VALID)
    private String wpDeviceScore;

    /**
     * From 0100 f125 (Supporting Information), dsi02 (Wallet Provider), tag06 (Wallet Provider Account Score).
     * Valid values: From 1 (least trusted) to 5 (most trusted).
     */
    @Size(max = 2, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @Digits(integer = 2, fraction = 0, message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
    @Pattern(regexp = "[1-5]|^$", message = VisaErrorCode.Codes.DATA_ELEMENT_NOT_VALID)
    private String wpAccountScore;

    /**
     * From 0100 f62.21 (Online Risk Assessment Risk Score and Reason Codes) positions 1, 2 (Risk Score).
     * Valid value: From 01–99.
     */
    @Size(max = 2, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @Digits(integer = 2, fraction = 0, message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
    private String riskAssessmentScore;

    /**
     * From 0100 f123 (Verification Data), dsi68 (Token Data), tag10 (Visa Token Score).
     * Value from 01–99.
     */
    @Size(max = 2, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @Digits(integer = 2, fraction = 0, message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
    private String tokenProvisioningScore;

    /* getters and setters */

    public String getWpReasonCodes() {
        return wpReasonCodes;
    }

    public void setWpReasonCodes(String wpReasonCodes) {
        this.wpReasonCodes = wpReasonCodes;
    }

    public String getPanSource() {
        return panSource;
    }

    public void setPanSource(String panSource) {
        this.panSource = panSource;
    }

    public String getWpDeviceScore() {
        return wpDeviceScore;
    }

    public void setWpDeviceScore(String wpDeviceScore) {
        this.wpDeviceScore = wpDeviceScore;
    }

    public String getWpAccountScore() {
        return wpAccountScore;
    }

    public void setWpAccountScore(String wpAccountScore) {
        this.wpAccountScore = wpAccountScore;
    }

    public String getRiskAssessmentScore() {
        return riskAssessmentScore;
    }

    public void setRiskAssessmentScore(String riskAssessmentScore) {
        this.riskAssessmentScore = riskAssessmentScore;
    }

    public String getTokenProvisioningScore() {
        return tokenProvisioningScore;
    }

    public void setTokenProvisioningScore(String tokenProvisioningScore) {
        this.tokenProvisioningScore = tokenProvisioningScore;
    }
}
