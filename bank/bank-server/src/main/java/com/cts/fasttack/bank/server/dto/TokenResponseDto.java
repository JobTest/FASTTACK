package com.cts.fasttack.bank.server.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Token info response DTO.
 *
 * @author v.semerkov
 * @author d.ishchenko
 */
public class TokenResponseDto {

    private String accountPanSuffix;

    private String panExpirationDate;

    private String tokenRefId;

    private String tokenSuffix;

    private String tokenExpiryMonth;

    private String tokenExpiryYear;

    private String correlationId;

    private String currentStatusCode;

    private String currentStatusDescription;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date currentStatusDateTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date digitizationRequestDateTime;

    private String lastCommentId;

    private String paymentAppInstanceId;

    private String provisioningStatusCode;

    private String storageTechnology;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date tokenActivatedDateTime;

    private String tokenRequestorId;

    private String tokenRequestorName;

    private String tokenType;

    private String panInternalId;

    private String panInternalGUID;

    private String ips;

    private DeviceResponseDto device;

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

    public String getTokenRefId() {
        return tokenRefId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
    }

    public String getTokenSuffix() {
        return tokenSuffix;
    }

    public void setTokenSuffix(String tokenSuffix) {
        this.tokenSuffix = tokenSuffix;
    }

    public String getTokenExpiryMonth() {
        return tokenExpiryMonth;
    }

    public void setTokenExpiryMonth(String tokenExpiryMonth) {
        this.tokenExpiryMonth = tokenExpiryMonth;
    }

    public String getTokenExpiryYear() {
        return tokenExpiryYear;
    }

    public void setTokenExpiryYear(String tokenExpiryYear) {
        this.tokenExpiryYear = tokenExpiryYear;
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

    public String getPanInternalGUID() {
        return panInternalGUID;
    }

    public void setPanInternalGUID(String panInternalGUID) {
        this.panInternalGUID = panInternalGUID;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public DeviceResponseDto getDevice() {
        return device;
    }

    public void setDevice(DeviceResponseDto device) {
        this.device = device;
    }
}
