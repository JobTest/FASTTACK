package com.cts.fasttack.jms.dto;

import java.util.Date;

/**
 * @author a.lipavets
 */
public class JmsSendPasscodeDto {

    private String tokenRequestorID;

    private String wpRequestId;

    private String wpConversationId;

    private String walletAccountID;

    private String lifeCycleTraceID;

    private String tokenReferenceID;

    private String panReferenceID;

    private String token;

    private String secureElementID;

    private String deviceType;

    private String deviceNumber;

    private String deviceName;

    private String otpMethodIdentifier;

    private String otpCode;

    private Date otpCodeExp;

    private String version;

    private String encryptionKeyIndex;

    private String encryptedData;

    /* getters and setters */

    public String getTokenRequestorID() {
        return tokenRequestorID;
    }

    public void setTokenRequestorID(String tokenRequestorID) {
        this.tokenRequestorID = tokenRequestorID;
    }

    public String getWpRequestId() {
        return wpRequestId;
    }

    public void setWpRequestId(String wpRequestId) {
        this.wpRequestId = wpRequestId;
    }

    public String getWpConversationId() {
        return wpConversationId;
    }

    public void setWpConversationId(String wpConversationId) {
        this.wpConversationId = wpConversationId;
    }

    public String getWalletAccountID() {
        return walletAccountID;
    }

    public void setWalletAccountID(String walletAccountID) {
        this.walletAccountID = walletAccountID;
    }

    public String getLifeCycleTraceID() {
        return lifeCycleTraceID;
    }

    public void setLifeCycleTraceID(String lifeCycleTraceID) {
        this.lifeCycleTraceID = lifeCycleTraceID;
    }

    public String getTokenReferenceID() {
        return tokenReferenceID;
    }

    public void setTokenReferenceID(String tokenReferenceID) {
        this.tokenReferenceID = tokenReferenceID;
    }

    public String getPanReferenceID() {
        return panReferenceID;
    }

    public void setPanReferenceID(String panReferenceID) {
        this.panReferenceID = panReferenceID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSecureElementID() {
        return secureElementID;
    }

    public void setSecureElementID(String secureElementID) {
        this.secureElementID = secureElementID;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getOtpMethodIdentifier() {
        return otpMethodIdentifier;
    }

    public void setOtpMethodIdentifier(String otpMethodIdentifier) {
        this.otpMethodIdentifier = otpMethodIdentifier;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public Date getOtpCodeExp() {
        return otpCodeExp;
    }

    public void setOtpCodeExp(Date otpCodeExp) {
        this.otpCodeExp = otpCodeExp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEncryptionKeyIndex() {
        return encryptionKeyIndex;
    }

    public void setEncryptionKeyIndex(String encryptionKeyIndex) {
        this.encryptionKeyIndex = encryptionKeyIndex;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }
}
