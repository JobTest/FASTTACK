package com.cts.fasttack.jms.dto;

/**
 * @author Dmitry Koval
 */
public class JmsTokenLifecycleDto {

    private String tokenReferenceID;

    private String tokenRequestorID;

    private String comment;

    private String status;

    private String reasonSuspend;

    private String username;

    private String userId;

    private String tokenReason;

    private String mdesReason;

    private String eventRef;

    private String tokenStatusUpdateReason;

    private String pan;

    private String paymentAppInstanceId;

    private JmsCardHolderInfoRequestDto jmsCardHolderInfoRequestDto;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTokenReason() {
        return tokenReason;
    }

    public void setTokenReason(String tokenReason) {
        this.tokenReason = tokenReason;
    }

    public String getMdesReason() {
        return mdesReason;
    }

    public void setMdesReason(String mdesReason) {
        this.mdesReason = mdesReason;
    }

    public String getEventRef() {
        return eventRef;
    }

    public void setEventRef(String eventRef) {
        this.eventRef = eventRef;
    }

    public JmsCardHolderInfoRequestDto getJmsCardHolderInfoRequestDto() {
        return jmsCardHolderInfoRequestDto;
    }

    public void setJmsCardHolderInfoRequestDto(JmsCardHolderInfoRequestDto jmsCardHolderInfoRequestDto) {
        this.jmsCardHolderInfoRequestDto = jmsCardHolderInfoRequestDto;
    }

    public String getTokenStatusUpdateReason() {
        return tokenStatusUpdateReason;
    }

    public void setTokenStatusUpdateReason(String tokenStatusUpdateReason) {
        this.tokenStatusUpdateReason = tokenStatusUpdateReason;
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
}
