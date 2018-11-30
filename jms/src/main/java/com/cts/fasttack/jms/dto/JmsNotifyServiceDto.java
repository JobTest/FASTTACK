package com.cts.fasttack.jms.dto;

import java.util.Date;

/**
 * @author a.lipavets
 */
public class JmsNotifyServiceDto {

    private String  requestId;

    private String[] services;

    private String tokenRequestorId;

    private String correlationId;

    private String walletId;

    private String paymentAppInstanceId;

    private String tokenType;

    private String secureElementId;

    private String accountPanSuffix;

    private Date serviceRequestDateTime;

    private String termsAndConditionsAssetId;

    private Date termsAndConditionsAcceptedTimestamp;

    private String productConfigurationId;

    private String consumerLanguage;

    private String decision;

    private String decisionMadeBy;

    private Date tokenActivatedDateTime;

    private String numberOfActivationAttempts;

    private String numberOfActiveTokens;

    private String tokenAssuranceLevel;

    private String encryptedData;

    private String publicKeyFingerprint;

    private String encryptedKey;

    private String oaepHashingAlgorithm;

    private String iv;

    private String panUniqueReference;

    private String tokenUniqueReference;

    private JmsNotifyServiceDeviceInfoDto deviceInfo;

    private Date tokenEventDate;

    private String tokenEventType;

    /** getters and setters */
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String[] getServices() {
        return services;
    }

    public void setServices(String[] services) {
        this.services = services;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getPaymentAppInstanceId() {
        return paymentAppInstanceId;
    }

    public void setPaymentAppInstanceId(String paymentAppInstanceId) {
        this.paymentAppInstanceId = paymentAppInstanceId;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getSecureElementId() {
        return secureElementId;
    }

    public void setSecureElementId(String secureElementId) {
        this.secureElementId = secureElementId;
    }

    public String getAccountPanSuffix() {
        return accountPanSuffix;
    }

    public void setAccountPanSuffix(String accountPanSuffix) {
        this.accountPanSuffix = accountPanSuffix;
    }

    public Date getServiceRequestDateTime() {
        return serviceRequestDateTime;
    }

    public void setServiceRequestDateTime(Date serviceRequestDateTime) {
        this.serviceRequestDateTime = serviceRequestDateTime;
    }

    public String getTermsAndConditionsAssetId() {
        return termsAndConditionsAssetId;
    }

    public void setTermsAndConditionsAssetId(String termsAndConditionsAssetId) {
        this.termsAndConditionsAssetId = termsAndConditionsAssetId;
    }

    public Date getTermsAndConditionsAcceptedTimestamp() {
        return termsAndConditionsAcceptedTimestamp;
    }

    public void setTermsAndConditionsAcceptedTimestamp(Date termsAndConditionsAcceptedTimestamp) {
        this.termsAndConditionsAcceptedTimestamp = termsAndConditionsAcceptedTimestamp;
    }

    public String getProductConfigurationId() {
        return productConfigurationId;
    }

    public void setProductConfigurationId(String productConfigurationId) {
        this.productConfigurationId = productConfigurationId;
    }

    public String getConsumerLanguage() {
        return consumerLanguage;
    }

    public void setConsumerLanguage(String consumerLanguage) {
        this.consumerLanguage = consumerLanguage;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getDecisionMadeBy() {
        return decisionMadeBy;
    }

    public void setDecisionMadeBy(String decisionMadeBy) {
        this.decisionMadeBy = decisionMadeBy;
    }

    public Date getTokenActivatedDateTime() {
        return tokenActivatedDateTime;
    }

    public void setTokenActivatedDateTime(Date tokenActivatedDateTime) {
        this.tokenActivatedDateTime = tokenActivatedDateTime;
    }

    public String getNumberOfActivationAttempts() {
        return numberOfActivationAttempts;
    }

    public void setNumberOfActivationAttempts(String numberOfActivationAttempts) {
        this.numberOfActivationAttempts = numberOfActivationAttempts;
    }

    public String getNumberOfActiveTokens() {
        return numberOfActiveTokens;
    }

    public void setNumberOfActiveTokens(String numberOfActiveTokens) {
        this.numberOfActiveTokens = numberOfActiveTokens;
    }

    public String getTokenAssuranceLevel() {
        return tokenAssuranceLevel;
    }

    public void setTokenAssuranceLevel(String tokenAssuranceLevel) {
        this.tokenAssuranceLevel = tokenAssuranceLevel;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
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

    public String getPanUniqueReference() {
        return panUniqueReference;
    }

    public void setPanUniqueReference(String panUniqueReference) {
        this.panUniqueReference = panUniqueReference;
    }

    public String getTokenUniqueReference() {
        return tokenUniqueReference;
    }

    public void setTokenUniqueReference(String tokenUniqueReference) {
        this.tokenUniqueReference = tokenUniqueReference;
    }

    public JmsNotifyServiceDeviceInfoDto getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(JmsNotifyServiceDeviceInfoDto deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public Date getTokenEventDate() {
        return tokenEventDate;
    }

    public void setTokenEventDate(Date tokenEventDate) {
        this.tokenEventDate = tokenEventDate;
    }

    public String getTokenEventType() {
        return tokenEventType;
    }

    public void setTokenEventType(String tokenEventType) {
        this.tokenEventType = tokenEventType;
    }
}
