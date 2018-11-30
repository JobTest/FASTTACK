package com.cts.fasttack.visa.client.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author a.lipavets
 */
@XmlRootElement(name = "tokenInquiryReq", namespace = "http://vnts.visa.com/tpcas/v1")
public class TokenInquiryRequestDto {

    private String requestID;

    private String operatorID;

    private String token;

    private String tokenReferenceID;

    private String tokenRequestorID;

    private String panReferenceID;

    private CardholderInfoDto cardholderInfo;

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getPanReferenceID() {
        return panReferenceID;
    }

    public void setPanReferenceID(String panReferenceID) {
        this.panReferenceID = panReferenceID;
    }

    public CardholderInfoDto getCardholderInfo() {
        return cardholderInfo;
    }

    public void setCardholderInfo(CardholderInfoDto cardholderInfo) {
        this.cardholderInfo = cardholderInfo;
    }
}
