package com.cts.fasttack.bank.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Card Data Update response DTO.
 */
@JacksonXmlRootElement(localName = "CardDataUpdateResponse")
@XmlRootElement(name = "CardDataUpdateResponse")
public class CardDataUpdateResponseDto extends LifecycleTokenResponseDto {

    @JsonProperty
    @JacksonXmlProperty(localName = "requestId")
    private String requestId;

    @JacksonXmlProperty(localName = "code")
    private String code;

    @JacksonXmlProperty(localName = "errorMessage")
    private String errorMessage;

    @Override
    public String getRequestId() {
        return requestId;
    }

    @Override
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}