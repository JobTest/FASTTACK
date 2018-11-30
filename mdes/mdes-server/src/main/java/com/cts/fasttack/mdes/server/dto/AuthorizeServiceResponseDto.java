package com.cts.fasttack.mdes.server.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.cts.fasttack.mdes.server.dict.AddressValidationStatus;
import com.cts.fasttack.mdes.server.dict.CvcValidationStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Authorize service response DTO
 *
 * @author Dmitry Koval
 */
@XmlRootElement(name="response")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AuthorizeServiceResponseDto extends CommonMdesResponseDto {


    /**
     * Array of services for the account that the authorization decision applies to
     */
    private String[] services;

    /**
     * The authorization decision for the authorization of the requested services
     */
    private String decision;

    /**
     * Specifies the activation method type
     */
    private List<ActivationMethod> activationMethods;

    /**
     * The pan sequence number for the card
     */
    private String panSequenceNumber;

    /**
     * The unique Issuer identifier assigned to the product configuration in BPMS
     */
    private String issuerProductConfigId;

    /**
     * Contains the encrypted AuthroizeServiceResponseData object
     */
    private EncryptedPayload encryptedPayload;

    /**
     * The result of the CVC2 validation performed against the value provided by the cardholder
     */
    private CvcValidationStatus cvcResponse;

    /**
     * The result of the address validation performed against the values provided by the cardholder
     */
    private AddressValidationStatus avsResponse;

    /**
     * The party that requested the digitization
     */
    private String tokenRequestorId;

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

    public String[] getServices() {
        return services;
    }

    public void setServices(String[] services) {
        this.services = services;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public List<ActivationMethod> getActivationMethods() {
        return activationMethods;
    }

    public void setActivationMethods(List<ActivationMethod> activationMethods) {
        this.activationMethods = activationMethods;
    }

    public String getPanSequenceNumber() {
        return panSequenceNumber;
    }

    public void setPanSequenceNumber(String panSequenceNumber) {
        this.panSequenceNumber = panSequenceNumber;
    }

    public String getIssuerProductConfigId() {
        return issuerProductConfigId;
    }

    public void setIssuerProductConfigId(String issuerProductConfigId) {
        this.issuerProductConfigId = issuerProductConfigId;
    }

    public EncryptedPayload getEncryptedPayload() {
        return encryptedPayload;
    }

    public void setEncryptedPayload(EncryptedPayload encryptedPayload) {
        this.encryptedPayload = encryptedPayload;
    }

    public CvcValidationStatus getCvcResponse() {
        return cvcResponse;
    }

    public void setCvcResponse(CvcValidationStatus cvcResponse) {
        this.cvcResponse = cvcResponse;
    }

    public AddressValidationStatus getAvsResponse() {
        return avsResponse;
    }

    public void setAvsResponse(AddressValidationStatus avsResponse) {
        this.avsResponse = avsResponse;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
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
