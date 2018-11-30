package com.cts.fasttack.admin.web.data.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.admin.web.util.CustomJsonExpDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author a.lipavets
 */
public class TokenUpdateDto {

    private String tokenRefId;
    private String tokenRequestorId;

    @Pattern(regexp = "^([\\d]{16}|[\\d]{19})$", message = "{token.update.pan.invalid}")
    private String newPan;

    @JsonDeserialize(using = CustomJsonExpDateDeserializer.class)
    @NotEmpty(message = "{token.update.expDate.invalid}")
    @Pattern(regexp = "^(0[1-9]|1[0-2])[0-9][0-9]$", message = "{token.update.expDate.incorrect}")
    private String newExpDate;
    private String tokenReason;
    private String comment;

    private String ips;

    private String panInternalId;

    private String panInternalGuid;

    private boolean updateWalletProviderIndicator;

    public String getTokenRefId() {
        return tokenRefId;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
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

    public String getTokenReason() {
        return tokenReason;
    }

    public void setTokenReason(String tokenReason) {
        this.tokenReason = tokenReason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
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

    public boolean isUpdateWalletProviderIndicator() {
        return updateWalletProviderIndicator;
    }

    public void setUpdateWalletProviderIndicator(boolean updateWalletProviderIndicator) {
        this.updateWalletProviderIndicator = updateWalletProviderIndicator;
    }
}
