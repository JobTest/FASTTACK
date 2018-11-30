package com.cts.fasttack.visa.vtis.server.dto;

import java.util.Date;

/**
 * @author Dmitry Koval
 */
public class TokenNotificationDto {

    private String messageReason;

    private String messageReasonCode;

    private Date dateTimeOfEvent;

    private String panReferenceID;

    private String deviceID;

    private VisaEncryptedData encryptedData;

    private String tokenRequestorID;

    private String tokenReferenceID;

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

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public VisaEncryptedData getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(VisaEncryptedData encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getTokenRequestorID() {
        return tokenRequestorID;
    }

    public void setTokenRequestorID(String tokenRequestorID) {
        this.tokenRequestorID = tokenRequestorID;
    }

    public String getTokenReferenceID() {
        return tokenReferenceID;
    }

    public void setTokenReferenceID(String tokenReferenceID) {
        this.tokenReferenceID = tokenReferenceID;
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
