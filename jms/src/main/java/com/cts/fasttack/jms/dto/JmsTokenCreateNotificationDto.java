package com.cts.fasttack.jms.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Dmitry Koval
 */
public class JmsTokenCreateNotificationDto implements Serializable {

	private static final long serialVersionUID = -8609710202363683825L;

	private String messageReason;

    private String messageReasonCode;

    private Date dateTimeOfEvent;

    private String panReferenceID;

    private String walletAccountEmailAddressHash;

    private String clientWalletAccountID;

    private String visaTokenScore;

    private String visaTokenDecisioning;

    private String panSource;

    private String addressVerificationResultCode;

    private String cvv2ResultsCode;

    private String consumerEntryMode;

    private String locale;

    private JmsVtsDeviceInfo deviceInfo;

    private JmsVisaEncryptedDataDto encryptedData;

    private JmsTermsAndConditions termsAndConditions;

    private String issuerSpecialConditionCodes;

    private String tokenReferenceID;

    private String tokenRequestorID;

    private String eventType;

    private String eventID;

    public String getMessageReason() {
        return messageReason;
    }

    public void setMessageReason(String messageReason) {
        this.messageReason = messageReason;
    }

    public String getMessageReasonCode() {
        return messageReasonCode;
    }

    public void setMessageReasonCode(String messageReasonCode) {
        this.messageReasonCode = messageReasonCode;
    }

    public Date getDateTimeOfEvent() {
        return dateTimeOfEvent;
    }

    public void setDateTimeOfEvent(Date dateTimeOfEvent) {
        this.dateTimeOfEvent = dateTimeOfEvent;
    }

    public String getPanReferenceID() {
        return panReferenceID;
    }

    public void setPanReferenceID(String panReferenceID) {
        this.panReferenceID = panReferenceID;
    }

    public String getWalletAccountEmailAddressHash() {
        return walletAccountEmailAddressHash;
    }

    public void setWalletAccountEmailAddressHash(String walletAccountEmailAddressHash) {
        this.walletAccountEmailAddressHash = walletAccountEmailAddressHash;
    }

    public String getClientWalletAccountID() {
        return clientWalletAccountID;
    }

    public void setClientWalletAccountID(String clientWalletAccountID) {
        this.clientWalletAccountID = clientWalletAccountID;
    }

    public String getVisaTokenScore() {
        return visaTokenScore;
    }

    public void setVisaTokenScore(String visaTokenScore) {
        this.visaTokenScore = visaTokenScore;
    }

    public String getVisaTokenDecisioning() {
        return visaTokenDecisioning;
    }

    public void setVisaTokenDecisioning(String visaTokenDecisioning) {
        this.visaTokenDecisioning = visaTokenDecisioning;
    }

    public String getPanSource() {
        return panSource;
    }

    public void setPanSource(String panSource) {
        this.panSource = panSource;
    }

    public String getAddressVerificationResultCode() {
        return addressVerificationResultCode;
    }

    public void setAddressVerificationResultCode(String addressVerificationResultCode) {
        this.addressVerificationResultCode = addressVerificationResultCode;
    }

    public String getCvv2ResultsCode() {
        return cvv2ResultsCode;
    }

    public void setCvv2ResultsCode(String cvv2ResultsCode) {
        this.cvv2ResultsCode = cvv2ResultsCode;
    }

    public String getConsumerEntryMode() {
        return consumerEntryMode;
    }

    public void setConsumerEntryMode(String consumerEntryMode) {
        this.consumerEntryMode = consumerEntryMode;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public JmsVtsDeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(JmsVtsDeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public JmsVisaEncryptedDataDto getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(JmsVisaEncryptedDataDto encryptedData) {
        this.encryptedData = encryptedData;
    }

    public JmsTermsAndConditions getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(JmsTermsAndConditions termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public String getIssuerSpecialConditionCodes() {
        return issuerSpecialConditionCodes;
    }

    public void setIssuerSpecialConditionCodes(String issuerSpecialConditionCodes) {
        this.issuerSpecialConditionCodes = issuerSpecialConditionCodes;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }
}
