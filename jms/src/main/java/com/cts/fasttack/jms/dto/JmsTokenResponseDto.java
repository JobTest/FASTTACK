package com.cts.fasttack.jms.dto;

import java.util.Date;

import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;

/**
 * JMS token response DTO.
 *
 * @author v.semerkov
 */
public class JmsTokenResponseDto {

    private String accountPanSuffix;

    private String panExpirationDate;

    private String tokenUniqueReference;

    private String tokenSuffix;

    /**
     * Token expiration date.
     * Format "MMyy".
     */
    private String tokenExpirationDate;

    private String correlationId;

    private String currentStatusCode;

    private String currentStatusDescription;

    private Date currentStatusDateTime;

    private Date digitizationRequestDateTime;

    private String lastCommentId;

    private String paymentAppInstanceId;

    private String provisioningStatusCode;

    private String storageTechnology;

    private Date tokenActivatedDateTime;

    private String tokenRequestorId;

    private String tokenRequestorName;

    private String tokenType;

    private String panInternalId;

    private String panInternalGuid;

    private InternationalPaymentSystem ips;

    private JmsDeviceResponseDto device;

    public String getAccountPanSuffix() {
        return accountPanSuffix;
    }

    public void setAccountPanSuffix(String accountPanSuffix) {
        this.accountPanSuffix = accountPanSuffix;
    }

    public String getPanExpirationDate() {
        return panExpirationDate;
    }

    public void setPanExpirationDate(String panExpirationDate) {
        this.panExpirationDate = panExpirationDate;
    }

    public String getTokenUniqueReference() {
        return tokenUniqueReference;
    }

    public void setTokenUniqueReference(String tokenUniqueReference) {
        this.tokenUniqueReference = tokenUniqueReference;
    }

    public String getTokenSuffix() {
        return tokenSuffix;
    }

    public void setTokenSuffix(String tokenSuffix) {
        this.tokenSuffix = tokenSuffix;
    }

    public String getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public void setTokenExpirationDate(String tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
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

    public String getStorageTechnology() {
        return storageTechnology;
    }

    public void setStorageTechnology(String storageTechnology) {
        this.storageTechnology = storageTechnology;
    }

    public Date getTokenActivatedDateTime() {
        return tokenActivatedDateTime;
    }

    public void setTokenActivatedDateTime(Date tokenActivatedDateTime) {
        this.tokenActivatedDateTime = tokenActivatedDateTime;
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

    public InternationalPaymentSystem getIps() {
        return ips;
    }

    public void setIps(InternationalPaymentSystem ips) {
        this.ips = ips;
    }

    public JmsDeviceResponseDto getDevice() {
        return device;
    }

    public void setDevice(JmsDeviceResponseDto device) {
        this.device = device;
    }
}
