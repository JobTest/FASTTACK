package com.cts.fasttack.jms.dto;

/**
 * @author Dmitry Koval
 */
public class JmsUpdateTokenDto {

    private String tokenRefId;

    private String tokenRequestorId;

    private String comment;

    private String userId;

    private String username;

    private String oldPan;

    private String newPan;

    private String oldExpDate;

    private String newExpDate;

    private String tokenEventStatus;

    private String tokenReason;

    private String panInternalId;

    private String panInternalGuid;

    private String newPanInternalId;

    private String newPanInternalGuid;

    private boolean receivedCurrentPan = true;

    private String updateWalletProviderIndicator;

    private boolean skipOldPan;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

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

    public String getNewPan() {
        return newPan;
    }

    public void setNewPan(String newPan) {
        this.newPan = newPan;
    }

    public String getNewExpDate() {
        return newExpDate;
    }

    public void setNewExpDate(String newExpDate) {
        this.newExpDate = newExpDate;
    }

    public String getTokenEventStatus() {
        return tokenEventStatus;
    }

    public void setTokenEventStatus(String tokenEventStatus) {
        this.tokenEventStatus = tokenEventStatus;
    }

    public String getTokenReason() {
        return tokenReason;
    }

    public void setTokenReason(String tokenReason) {
        this.tokenReason = tokenReason;
    }

    public String getPanInternalId() {
        return panInternalId;
    }

    public void setPanInternalId(String panInternalId) {
        this.panInternalId = panInternalId;
    }

    public String getPanInternalGuid() {
        return panInternalGuid;
    }

    public void setPanInternalGuid(String panInternalGuid) {
        this.panInternalGuid = panInternalGuid;
    }

    public boolean isReceivedCurrentPan() {
        return receivedCurrentPan;
    }

    public void setReceivedCurrentPan(boolean receivedCurrentPan) {
        this.receivedCurrentPan = receivedCurrentPan;
    }

    public String getUpdateWalletProviderIndicator() {
        return updateWalletProviderIndicator;
    }

    public void setUpdateWalletProviderIndicator(String updateWalletProviderIndicator) {
        this.updateWalletProviderIndicator = updateWalletProviderIndicator;
    }

    public String getOldPan() {
        return oldPan;
    }

    public void setOldPan(String oldPan) {
        this.oldPan = oldPan;
    }

    public String getNewPanInternalId() {
        return newPanInternalId;
    }

    public void setNewPanInternalId(String newPanInternalId) {
        this.newPanInternalId = newPanInternalId;
    }

    public String getNewPanInternalGuid() {
        return newPanInternalGuid;
    }

    public void setNewPanInternalGuid(String newPanInternalGuid) {
        this.newPanInternalGuid = newPanInternalGuid;
    }

    public String getOldExpDate() {
        return oldExpDate;
    }

    public void setOldExpDate(String oldExpDate) {
        this.oldExpDate = oldExpDate;
    }

    public boolean isSkipOldPan() {
        return skipOldPan;
    }

    public void setSkipOldPan(boolean skipOldPan) {
        this.skipOldPan = skipOldPan;
    }
}
