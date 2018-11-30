package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Dmitry Koval
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MdesErrorDto {

    @JsonProperty("Source")
    @XmlElement(name = "Source")
    private String source;

    @JsonProperty("ReasonCode")
    @XmlElement(name = "ReasonCode")
    private String reasonCode;

    @JsonProperty("Description")
    @XmlElement(name = "Description")
    private String description;

    @JsonProperty("Recoverable")
    @XmlElement(name = "Recoverable")
    private Boolean recoverable;

    @JsonProperty("Details")
    @XmlElement(name = "Details")
    private MdesErrorDetailsDto detail;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRecoverable() {
        return recoverable;
    }

    public void setRecoverable(Boolean recoverable) {
        this.recoverable = recoverable;
    }

    public MdesErrorDetailsDto getDetail() {
        return detail;
    }

    public void setDetail(MdesErrorDetailsDto detail) {
        this.detail = detail;
    }
}
