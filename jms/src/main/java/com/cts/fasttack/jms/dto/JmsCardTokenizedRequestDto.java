package com.cts.fasttack.jms.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JmsCardTokenizedRequestDto {

    private String requestId;

    private String conversationId;

    private String tokenRequestorId;

    private String tokenRefId;

    private String status;

    private String panInternalId;

    private String panInternalGUID;

    private String pan;

    private String expiryMonth;

    private String expiryYear;

    private String token;

    private String tokenExpiryMonth;

    private String tokenExpiryYear;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date tokenActivationDate;

    private String ips;

    private String panSource;

    private String paymentAppInstId;

    private String deviceType;

    private String storageTechnology;

    private String deviceName;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }

    public String getTokenRefId() {
        return tokenRefId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public Date getTokenActivationDate() {
        return tokenActivationDate;
    }

    public void setTokenActivationDate(Date tokenActivationDate) {
        this.tokenActivationDate = tokenActivationDate;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getPanSource() {
        return panSource;
    }

    public void setPanSource(String panSource) {
        this.panSource = panSource;
    }

    public String getPaymentAppInstId() {
        return paymentAppInstId;
    }

    public void setPaymentAppInstId(String paymentAppInstId) {
        this.paymentAppInstId = paymentAppInstId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getStorageTechnology() {
        return storageTechnology;
    }

    public void setStorageTechnology(String storageTechnology) {
        this.storageTechnology = storageTechnology;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
