package com.cts.fasttack.mdes.server.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * CommonMdesResponseDto response
 *
 * @author a.lipavets
 */
@XmlRootElement(name = "response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonMdesResponseDto {

    /**
     * The id of the response returned
     */
    private String responseId;

    /**
     * Error Code for the reason the operation failed
     */
    private String errorCode;

    /**
     * Error description of the reason the operation failed
     */
    private String errorDescription;

    @JsonIgnore
    @XmlTransient
    private String maskedPan;

    @JsonIgnore
    @XmlTransient
    private String panSource;

    @JsonIgnore
    @XmlTransient
    private String panInternalId;

    @JsonIgnore
    @XmlTransient
    private String panInternalGuid;

    /** getters and setters */
    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getPanSource() {
        return panSource;
    }

    public void setPanSource(String panSource) {
        this.panSource = panSource;
    }

    public String getPanInternalId() {
        return panInternalId;
    }

    public void setPanInternalId(String panInternalId) {
        this.panInternalId = panInternalId;
    }

    public String getPanInternalGuid() {
        return panInternalGuid;
    }

    public void setPanInternalGuid(String panInternalGuid) {
        this.panInternalGuid = panInternalGuid;
    }
}
