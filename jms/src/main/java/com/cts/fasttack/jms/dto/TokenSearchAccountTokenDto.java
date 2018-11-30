package com.cts.fasttack.jms.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dmitry Koval
 */
public class TokenSearchAccountTokenDto {

    @JsonProperty("TokenUniqueReference")
    private String tokenUniqueReference;

    @JsonProperty("PrimaryAccountNumberUniqueReference")
    private String primaryAccountNumberUniqueReference;

    @JsonProperty("TokenSuffix")
    private String tokenSuffix;

    @JsonProperty("ExpirationDate")
    private String expirationDate;

    @JsonProperty("AccountPanSequenceNumber")
    private String accountPanSequenceNumber;

    @JsonProperty("ActivationCodeExpirationDateTime")
    private Date activationCodeExpirationDateTime;

    @JsonProperty("CorrelationId")
    private String correlationId;

    @JsonProperty("CurrentStatusCode")
    private String currentStatusCode;

    @JsonProperty("CurrentStatusDescription")
    private String currentStatusDescription;

    @JsonProperty("CurrentStatusDateTime")
    private Date currentStatusDateTime;

    @JsonProperty("DigitizationRequestDateTime")
    private Date digitizationRequestDateTime;

    @JsonProperty("FinalTokenizationDecision")
    private String finalTokenizationDecision;

    @JsonProperty("LastCommentId")
    private String lastCommentId;

    @JsonProperty("PaymentAppInstanceId")
    private String paymentAppInstanceId;

    @JsonProperty("ProvisioningStatusCode")
    private String provisioningStatusCode;

    @JsonProperty("ProvisioningStatusDescription")
    private String provisioningStatusDescription;

    @JsonProperty("StorageTechnology")
    private String storageTechnology;

    @JsonProperty("Suspenders")
    private TokenSearchAccountTokenSuspendersDto suspender;

    @JsonProperty("TokenActivatedDateTime")
    private Date tokenActivatedDateTime;

    @JsonProperty("TokenAssuranceLevel")
    private String tokenAssuranceLevel;

    @JsonProperty("TokenRequestorId")
    private String tokenRequestorId;

    @JsonProperty("TokenRequestorName")
    private String tokenRequestorName;

    @JsonProperty("TokenType")
    private String tokenType;

    @JsonProperty("WalletId")
    private String walletId;

    @JsonProperty("Device")
    private TokenSearchAccountTokenDeviceDto device;

    @JsonProperty("TokenDeletedFromConsumerApp")
    private Boolean tokenDeletedFromConsumerApp;

    public String getTokenUniqueReference() {
        return tokenUniqueReference;
    }

    public void setTokenUniqueReference(String tokenUniqueReference) {
        this.tokenUniqueReference = tokenUniqueReference;
    }

    public String getPrimaryAccountNumberUniqueReference() {
        return primaryAccountNumberUniqueReference;
    }

    public void setPrimaryAccountNumberUniqueReference(String primaryAccountNumberUniqueReference) {
        this.primaryAccountNumberUniqueReference = primaryAccountNumberUniqueReference;
    }

    public String getTokenSuffix() {
        return tokenSuffix;
    }

    public void setTokenSuffix(String tokenSuffix) {
        this.tokenSuffix = tokenSuffix;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAccountPanSequenceNumber() {
        return accountPanSequenceNumber;
    }

    public void setAccountPanSequenceNumber(String accountPanSequenceNumber) {
        this.accountPanSequenceNumber = accountPanSequenceNumber;
    }

    public Date getActivationCodeExpirationDateTime() {
        return activationCodeExpirationDateTime;
    }

    public void setActivationCodeExpirationDateTime(Date activationCodeExpirationDateTime) {
        this.activationCodeExpirationDateTime = activationCodeExpirationDateTime;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getCurrentStatusCode() {
        return currentStatusCode;
    }

    public void setCurrentStatusCode(String currentStatusCode) {
        this.currentStatusCode = currentStatusCode;
    }

    public String getCurrentStatusDescription() {
        return currentStatusDescription;
    }

    public void setCurrentStatusDescription(String currentStatusDescription) {
        this.currentStatusDescription = currentStatusDescription;
    }

    public Date getCurrentStatusDateTime() {
        return currentStatusDateTime;
    }

    public void setCurrentStatusDateTime(Date currentStatusDateTime) {
        this.currentStatusDateTime = currentStatusDateTime;
    }

    public Date getDigitizationRequestDateTime() {
        return digitizationRequestDateTime;
    }

    public void setDigitizationRequestDateTime(Date digitizationRequestDateTime) {
        this.digitizationRequestDateTime = digitizationRequestDateTime;
    }

    public String getFinalTokenizationDecision() {
        return finalTokenizationDecision;
    }

    public void setFinalTokenizationDecision(String finalTokenizationDecision) {
        this.finalTokenizationDecision = finalTokenizationDecision;
    }

    public String getLastCommentId() {
        return lastCommentId;
    }

    public void setLastCommentId(String lastCommentId) {
        this.lastCommentId = lastCommentId;
    }

    public String getPaymentAppInstanceId() {
        return paymentAppInstanceId;
    }

    public void setPaymentAppInstanceId(String paymentAppInstanceId) {
        this.paymentAppInstanceId = paymentAppInstanceId;
    }

    public String getProvisioningStatusCode() {
        return provisioningStatusCode;
    }

    public void setProvisioningStatusCode(String provisioningStatusCode) {
        this.provisioningStatusCode = provisioningStatusCode;
    }

    public String getProvisioningStatusDescription() {
        return provisioningStatusDescription;
    }

    public void setProvisioningStatusDescription(String provisioningStatusDescription) {
        this.provisioningStatusDescription = provisioningStatusDescription;
    }

    public String getStorageTechnology() {
        return storageTechnology;
    }

    public void setStorageTechnology(String storageTechnology) {
        this.storageTechnology = storageTechnology;
    }

    public TokenSearchAccountTokenSuspendersDto getSuspender() {
        return suspender;
    }

    public void setSuspender(TokenSearchAccountTokenSuspendersDto suspender) {
        this.suspender = suspender;
    }

    public Date getTokenActivatedDateTime() {
        return tokenActivatedDateTime;
    }

    public void setTokenActivatedDateTime(Date tokenActivatedDateTime) {
        this.tokenActivatedDateTime = tokenActivatedDateTime;
    }

    public String getTokenAssuranceLevel() {
        return tokenAssuranceLevel;
    }

    public void setTokenAssuranceLevel(String tokenAssuranceLevel) {
        this.tokenAssuranceLevel = tokenAssuranceLevel;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }

    public String getTokenRequestorName() {
        return tokenRequestorName;
    }

    public void setTokenRequestorName(String tokenRequestorName) {
        this.tokenRequestorName = tokenRequestorName;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public TokenSearchAccountTokenDeviceDto getDevice() {
        return device;
    }

    public void setDevice(TokenSearchAccountTokenDeviceDto device) {
        this.device = device;
    }

    public Boolean getTokenDeletedFromConsumerApp() {
        return tokenDeletedFromConsumerApp;
    }

    public void setTokenDeletedFromConsumerApp(Boolean tokenDeletedFromConsumerApp) {
        this.tokenDeletedFromConsumerApp = tokenDeletedFromConsumerApp;
    }
}
