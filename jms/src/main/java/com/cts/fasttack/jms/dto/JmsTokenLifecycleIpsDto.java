package com.cts.fasttack.jms.dto;

/**
 * @author Dmitry Koval
 */
public class JmsTokenLifecycleIpsDto {

    private String vtsReasonCode;

    private String mdesReasonCode;

    private String userId;

    private String username;

    private String organization;

    private String tokenRefID;

    private String tokenRequestorID;

    private String comment;

    private String status;

    private String reasonSuspend;

    private String tokenReason;

    private String paymentAppInstanceId;

    private String activationCode;

    private String pan;

    private JmsCardHolderInfoRequestDto cardHolderInfo;

    private String panReferenceId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getTokenRefID() {
        return tokenRefID;
    }

    public void setTokenRefID(String tokenRefID) {
        this.tokenRefID = tokenRefID;
    }

    public String getTokenRequestorID() {
        return tokenRequestorID;
    }

    public void setTokenRequestorID(String tokenRequestorID) {
        this.tokenRequestorID = tokenRequestorID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getVtsReasonCode() {
        return vtsReasonCode;
    }

    public void setVtsReasonCode(String vtsReasonCode) {
        this.vtsReasonCode = vtsReasonCode;
    }

    public String getMdesReasonCode() {
        return mdesReasonCode;
    }

    public void setMdesReasonCode(String mdesReasonCode) {
        this.mdesReasonCode = mdesReasonCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReasonSuspend() {
        return reasonSuspend;
    }

    public void setReasonSuspend(String reasonSuspend) {
        this.reasonSuspend = reasonSuspend;
    }

    public String getTokenReason() {
        return tokenReason;
    }

    public void setTokenReason(String tokenReason) {
        this.tokenReason = tokenReason;
    }

    public String getPaymentAppInstanceId() {
        return paymentAppInstanceId;
    }

    public void setPaymentAppInstanceId(String paymentAppInstanceId) {
        this.paymentAppInstanceId = paymentAppInstanceId;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public JmsCardHolderInfoRequestDto getCardHolderInfo() {
        return cardHolderInfo;
    }

    public void setCardHolderInfo(JmsCardHolderInfoRequestDto cardHolderInfo) {
        this.cardHolderInfo = cardHolderInfo;
    }

    public String getPanReferenceId() {
        return panReferenceId;
    }

    public void setPanReferenceId(String panReferenceId) {
        this.panReferenceId = panReferenceId;
    }
}
