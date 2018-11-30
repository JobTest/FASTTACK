package com.cts.fasttack.jms.dto;

import java.util.Date;

/**
 * @author a.lipavets
 */
public class JmsTokenDetailsDto {
    private String token;
    private String panReferenceID;
    private String tokenReferenceID;
    private String tokenRequestorID;
    private String tokenRequestorName;
    private String walletAccountID;
    private String walletAccountEmailAddress;
    private String tokenAssuranceLevel;
    private String tokenExpiration;
    private String tokenState;
    private String tokenType;
    private Date deactivationDate;
    private Date lastTokenStatusUpdatedTime;
    private String entityOfLastAction;
    private String operatorID;
    private JmsRiskInformationDto riskInformation;
    private String otpCodeIndicator;
    private Date otpCodeExpiration;
    private String otpVerificationAttempts;
    private String otpVerificationRetryCounts;
    private String lastFourOfPan;
    private String lastFourOfPreviousPan;
    private JmsDeviceInformationDto deviceInformation;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPanReferenceID() {
        return panReferenceID;
    }

    public void setPanReferenceID(String panReferenceID) {
        this.panReferenceID = panReferenceID;
    }

    public String getTokenReferenceID() {
        return tokenReferenceID;
    }

    public void setTokenReferenceID(String tokenReferenceID) {
        this.tokenReferenceID = tokenReferenceID;
    }

    public String getTokenRequestorID() {
        return tokenRequestorID;
    }

    public void setTokenRequestorID(String tokenRequestorID) {
        this.tokenRequestorID = tokenRequestorID;
    }

    public String getTokenRequestorName() {
        return tokenRequestorName;
    }

    public void setTokenRequestorName(String tokenRequestorName) {
        this.tokenRequestorName = tokenRequestorName;
    }

    public String getWalletAccountID() {
        return walletAccountID;
    }

    public void setWalletAccountID(String walletAccountID) {
        this.walletAccountID = walletAccountID;
    }

    public String getWalletAccountEmailAddress() {
        return walletAccountEmailAddress;
    }

    public void setWalletAccountEmailAddress(String walletAccountEmailAddress) {
        this.walletAccountEmailAddress = walletAccountEmailAddress;
    }

    public String getTokenAssuranceLevel() {
        return tokenAssuranceLevel;
    }

    public void setTokenAssuranceLevel(String tokenAssuranceLevel) {
        this.tokenAssuranceLevel = tokenAssuranceLevel;
    }

    public String getTokenExpiration() {
        return tokenExpiration;
    }

    public void setTokenExpiration(String tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
    }

    public String getTokenState() {
        return tokenState;
    }

    public void setTokenState(String tokenState) {
        this.tokenState = tokenState;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Date getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(Date deactivationDate) {
        this.deactivationDate = deactivationDate;
    }

    public Date getLastTokenStatusUpdatedTime() {
        return lastTokenStatusUpdatedTime;
    }

    public void setLastTokenStatusUpdatedTime(Date lastTokenStatusUpdatedTime) {
        this.lastTokenStatusUpdatedTime = lastTokenStatusUpdatedTime;
    }

    public String getEntityOfLastAction() {
        return entityOfLastAction;
    }

    public void setEntityOfLastAction(String entityOfLastAction) {
        this.entityOfLastAction = entityOfLastAction;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public JmsRiskInformationDto getRiskInformation() {
        return riskInformation;
    }

    public void setRiskInformation(JmsRiskInformationDto riskInformation) {
        this.riskInformation = riskInformation;
    }

    public String getOtpCodeIndicator() {
        return otpCodeIndicator;
    }

    public void setOtpCodeIndicator(String otpCodeIndicator) {
        this.otpCodeIndicator = otpCodeIndicator;
    }

    public Date getOtpCodeExpiration() {
        return otpCodeExpiration;
    }

    public void setOtpCodeExpiration(Date otpCodeExpiration) {
        this.otpCodeExpiration = otpCodeExpiration;
    }

    public String getOtpVerificationAttempts() {
        return otpVerificationAttempts;
    }

    public void setOtpVerificationAttempts(String otpVerificationAttempts) {
        this.otpVerificationAttempts = otpVerificationAttempts;
    }

    public String getOtpVerificationRetryCounts() {
        return otpVerificationRetryCounts;
    }

    public void setOtpVerificationRetryCounts(String otpVerificationRetryCounts) {
        this.otpVerificationRetryCounts = otpVerificationRetryCounts;
    }

    public String getLastFourOfPan() {
        return lastFourOfPan;
    }

    public void setLastFourOfPan(String lastFourOfPan) {
        this.lastFourOfPan = lastFourOfPan;
    }

    public String getLastFourOfPreviousPan() {
        return lastFourOfPreviousPan;
    }

    public void setLastFourOfPreviousPan(String lastFourOfPreviousPan) {
        this.lastFourOfPreviousPan = lastFourOfPreviousPan;
    }

    public JmsDeviceInformationDto getDeviceInformation() {
        return deviceInformation;
    }

    public void setDeviceInformation(JmsDeviceInformationDto deviceInformation) {
        this.deviceInformation = deviceInformation;
    }
}
