package com.cts.fasttack.bank.server.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlRootElement;

@JacksonXmlRootElement(localName = "TokenUpdateResponse")
@XmlRootElement(name = "TokenUpdateResponse")
public class TokenUpdateResponseDto extends CommonTokenResponseDto {

    public String getRequestId() {
        return super.getRequestId();
    }

    public void setRequestId(String requestId) {
        super.setRequestId(requestId);
    }

    public String getCode() {
        return super.getCode();
    }

    public void setCode(String code) {
        super.setCode(code);
    }

    public String getErrorMessage() {
        return super.getErrorMessage();
    }

    public void setErrorMessage(String errorMessage) {
        super.setErrorMessage(errorMessage);
    }
}
