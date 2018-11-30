package com.cts.fasttack.bank.server.pushprovisioning.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author d.ishchenko
 */
@JacksonXmlRootElement(localName = "CreateInAppProvisioningDataResponse")
@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "CreateInAppProvisioningDataResponse")
public class CreateInAppProvisioningDataResponseDto {

    public static final String SUCCESS_CODE = "0";
    public static final String ERROR_CODE = "1";

    private String encryptedPassData;

    private String activationData;

    private String ephemeralPublicKey;

    private String authcode;

    private String code = SUCCESS_CODE;

    private String errorMessage;

    public String getEncryptedPassData() {
        return encryptedPassData;
    }

    public void setEncryptedPassData(String encryptedPassData) {
        this.encryptedPassData = encryptedPassData;
    }

    public String getActivationData() {
        return activationData;
    }

    public void setActivationData(String activationData) {
        this.activationData = activationData;
    }

    public String getEphemeralPublicKey() {
        return ephemeralPublicKey;
    }

    public void setEphemeralPublicKey(String ephemeralPublicKey) {
        this.ephemeralPublicKey = ephemeralPublicKey;
    }

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode;
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
