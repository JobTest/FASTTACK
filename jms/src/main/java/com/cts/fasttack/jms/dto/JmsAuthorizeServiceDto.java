package com.cts.fasttack.jms.dto;

import java.util.List;

/**
 * @author a.lipavets
 */
public class JmsAuthorizeServiceDto {

    private String requestId;

    private List<String> services;

    private String correlationId;

    private String tokenRequestorId;

    private String walletId;

    private String paymentAppInstanceId;

    private String accountIdHash;

    private Integer mobileNumberSuffix;

    private Integer activeTokenCount;

    private String tokenType;

    private String encryptedData;

    private String publicKeyFingerprint;

    private String encryptedKey;

    private String oaepHashingAlgorithm;

    private String iv;

    private String panUniqueReference;

    private String deviceName;

    private String serialNumber;

    private String formFactor;

    private String isoDeviceType;

    private String osName;

    private String osVersion;

    private String imei;

    private String msisdn;

    private List<String> paymentTypes;

    private String storageTechnology;

    private String recommendedDecision;

    private String recommendationStandardVersion;

    private Integer deviceScore;

    private String accountScore;

    private String phoneNumberScore;

    private String[] recommendationReasons;

    /* getters and setters */

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
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

    public String getAccountIdHash() {
        return accountIdHash;
    }

    public void setAccountIdHash(String accountIdHash) {
        this.accountIdHash = accountIdHash;
    }

    public Integer getMobileNumberSuffix() {
        return mobileNumberSuffix;
    }

    public void setMobileNumberSuffix(Integer mobileNumberSuffix) {
        this.mobileNumberSuffix = mobileNumberSuffix;
    }

    public Integer getActiveTokenCount() {
        return activeTokenCount;
    }

    public void setActiveTokenCount(Integer activeTokenCount) {
        this.activeTokenCount = activeTokenCount;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getIsoDeviceType() {
        return isoDeviceType;
    }

    public void setIsoDeviceType(String isoDeviceType) {
        this.isoDeviceType = isoDeviceType;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public List<String> getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(List<String> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    public String getStorageTechnology() {
        return storageTechnology;
    }

    public void setStorageTechnology(String storageTechnology) {
        this.storageTechnology = storageTechnology;
    }

    public String getRecommendedDecision() {
        return recommendedDecision;
    }

    public void setRecommendedDecision(String recommendedDecision) {
        this.recommendedDecision = recommendedDecision;
    }

    public String getRecommendationStandardVersion() {
        return recommendationStandardVersion;
    }

    public void setRecommendationStandardVersion(String recommendationStandardVersion) {
        this.recommendationStandardVersion = recommendationStandardVersion;
    }

    public Integer getDeviceScore() {
        return deviceScore;
    }

    public void setDeviceScore(Integer deviceScore) {
        this.deviceScore = deviceScore;
    }

    public String getAccountScore() {
        return accountScore;
    }

    public void setAccountScore(String accountScore) {
        this.accountScore = accountScore;
    }

    public String getPhoneNumberScore() {
        return phoneNumberScore;
    }

    public void setPhoneNumberScore(String phoneNumberScore) {
        this.phoneNumberScore = phoneNumberScore;
    }

    public String[] getRecommendationReasons() {
        return recommendationReasons;
    }

    public void setRecommendationReasons(String[] recommendationReasons) {
        this.recommendationReasons = recommendationReasons;
    }
}
