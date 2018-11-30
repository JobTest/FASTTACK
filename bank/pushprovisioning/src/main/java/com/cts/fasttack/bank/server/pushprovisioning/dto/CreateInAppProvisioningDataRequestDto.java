package com.cts.fasttack.bank.server.pushprovisioning.dto;

import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.validation.ValidEnum;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author d.ishchenko
 */
@XmlRootElement(name = "CreateInAppProvisioningDataRequest")
public class CreateInAppProvisioningDataRequestDto {

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private String requestId;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 13, max = 19, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String pan;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 2, max = 2, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Digits(integer = 2, fraction = 0, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String expiryMonth;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 2, max = 2, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Digits(integer = 2, fraction = 0, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String expiryYear;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 27, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String cardholderName;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @ValidEnum(enumType = InternationalPaymentSystem.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String ips;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private String nonce;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private String nonceSignature;

    @JacksonXmlElementWrapper(localName = "certificates")
    @JacksonXmlProperty(localName = "certificate")
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private List<String> certificates;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getNonceSignature() {
        return nonceSignature;
    }

    public void setNonceSignature(String nonceSignature) {
        this.nonceSignature = nonceSignature;
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

}
