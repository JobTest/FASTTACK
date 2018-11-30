package com.cts.fasttack.jms.dto;

import java.util.List;

/**
 * @author a.lipavets
 */
public class JmsAuthorizeServiceResponseDto extends CommonMdesJmsResponseDto {

    private String responseId;

    private String[] services;

    private String decision;

    private List<ActivationMethodDto> activationMethods;

    private String panSequenceNumber;

    private String issuerProductConfigId;

    private String publicKeyFingerprint;

    private String encryptedKey;

    private String oaepHashingAlgorithm;

    private String iv;

    private String encryptedData;

    private String cvcResponse;

    private String avsResponse;

    private String tokenRequestorId;

    private String errorCode;

    private String errorDescription;

    /* getters and setters */

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

    public String getPublicKeyFingerprint() {
        return publicKeyFingerprint;
    }

    public void setPublicKeyFingerprint(String publicKeyFingerprint) {
        this.publicKeyFingerprint = publicKeyFingerprint;
    }

    public String getEncryptedKey() {
        return encryptedKey;
    }

    public void setEncryptedKey(String encryptedKey) {
        this.encryptedKey = encryptedKey;
    }

    public String getOaepHashingAlgorithm() {
        return oaepHashingAlgorithm;
    }

    public void setOaepHashingAlgorithm(String oaepHashingAlgorithm) {
        this.oaepHashingAlgorithm = oaepHashingAlgorithm;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getCvcResponse() {
        return cvcResponse;
    }

    public void setCvcResponse(String cvcResponse) {
        this.cvcResponse = cvcResponse;
    }

    public String getAvsResponse() {
        return avsResponse;
    }

    public void setAvsResponse(String avsResponse) {
        this.avsResponse = avsResponse;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }

    public List<ActivationMethodDto> getActivationMethods() {
        return activationMethods;
    }

    public void setActivationMethods(List<ActivationMethodDto> activationMethods) {
        this.activationMethods = activationMethods;
    }

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
}
