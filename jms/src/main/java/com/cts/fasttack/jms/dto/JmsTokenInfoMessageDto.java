package com.cts.fasttack.jms.dto;

/**
 * JMS message DTO for getting token info.
 *
 * @author v.semerkov
 */
public class JmsTokenInfoMessageDto {

    /**
     * Unique ID for the token associated with the PAN
     */
    private String requestId;

    /**
     * Unique ID for the token associated with the PAN.
     * This ID can be used in lieu of the token for subsequent calls, such as life cycle events
     */
    private String tokenRefId;

    /**
     * Unique ID assigned to the initiator of the token request
     */
    private String tokenRequestorId;

    /**
     * Unique card identifier in bank system
     */
    private String panInternalId;

    /**
     * Unique card identifier in bank system
     */
    private String panInternalGUID;

    /**
     * Card number
     */
    private String pan;

    /**
     * Unique client wallet identifier
     */
    private String paymentAppInstanceId;

    /**
     * International payment system
     */
    private String ips;

    /**
     * Audit info.
     * User ID (as assigned by the Issuer/Processor) of the Customer Service Representative who triggered the API request.
     */
    private String userId;

    /**
     * Audit info.
     * User Name of the Customer Service Representative who triggered the API request.
     */
    private String userName;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTokenRefId() {
        return tokenRefId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
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

    public String getPaymentAppInstanceId() {
        return paymentAppInstanceId;
    }

    public void setPaymentAppInstanceId(String paymentAppInstanceId) {
        this.paymentAppInstanceId = paymentAppInstanceId;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
