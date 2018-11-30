package com.cts.fasttack.bank.server.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Olexandr Lypivets
 */
@JacksonXmlRootElement(localName = "TokenLifecycleResponse")
@XmlRootElement(name = "TokenLifecycleResponse")
public class LifecycleTokenResponseDto extends CommonTokenResponseDto {

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
