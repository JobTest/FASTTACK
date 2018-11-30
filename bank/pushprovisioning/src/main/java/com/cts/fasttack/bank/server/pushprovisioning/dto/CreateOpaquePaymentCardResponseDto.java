package com.cts.fasttack.bank.server.pushprovisioning.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author Anton Leliuk
 */
@JacksonXmlRootElement(localName = "CreateOpaquePaymentCardResponse")
@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "CreateOpaquePaymentCardResponse")
public class CreateOpaquePaymentCardResponseDto {

    public static final String SUCCESS_CODE = "0";
    public static final String ERROR_CODE = "1";

    private String opaqueBody;

    private String code = SUCCESS_CODE;

    private String errorMessage;

    public String getOpaqueBody() {
        return opaqueBody;
    }

    public void setOpaqueBody(String opaqueBody) {
        this.opaqueBody = opaqueBody;
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
