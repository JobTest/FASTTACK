package com.cts.fasttack.visa.client.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dmitry Koval
 */
@XmlRootElement(name = "submitLifeCycleCommandReq", namespace = "http://vnts.visa.com/tpcas/v1")
public class TokenLifecycleRequestDto {

    private String requestID;

    private String operatorID;

    private String messageReasonCode;

    private String tokenReferenceID;

    private String token;

    private String tokenRequestorID;

    private String panReferenceID;

    private String requestReason;

    private String activationCode;

    private String operationType;

    private CardholderInfoRequestDto cardholderInfo;

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getMessageReasonCode() {
        return messageReasonCode;
    }

    public void setMessageReasonCode(String messageReasonCode) {
        this.messageReasonCode = messageReasonCode;
    }

    public String getTokenRequestorID() {
        return tokenRequestorID;
    }

    public void setTokenRequestorID(String tokenRequestorID) {
        this.tokenRequestorID = tokenRequestorID;
    }

    public String getRequestReason() {
        return requestReason;
    }

    public void setRequestReason(String requestReason) {
        this.requestReason = requestReason;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getTokenReferenceID() {
        return tokenReferenceID;
    }

    public void setTokenReferenceID(String tokenReferenceID) {
        this.tokenReferenceID = tokenReferenceID;
    }

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

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public CardholderInfoRequestDto getCardholderInfo() {
        return cardholderInfo;
    }

    public void setCardholderInfo(CardholderInfoRequestDto cardholderInfo) {
        this.cardholderInfo = cardholderInfo;
    }
}
