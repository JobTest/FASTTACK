package com.cts.fasttack.bank.server.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.bank.server.validation.ValidateTokenUpdate;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;

/**
 * @author a.lipavets
 */
@ValidateTokenUpdate(message = StandardErrorCodes.Names.INVALID_JSON)
public class TokenUpdateRequestDto extends CommonTokenLifecycleRequestDto {

    @Size(min = 24, max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String tokenRefId;

    @Size(min = 11, max = 11, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String tokenRequestorId;

    @Size(min = 1, max = 30, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String panInternalId;

    @Size(min = 1, max = 32, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String panInternalGUID;

    @Size(min = 1, max = 30, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String newPanInternalId;

    @Size(min = 1, max = 32, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String newPanInternalGUID;

    @Size(min = 13, max = 19, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String oldAccountPan;

    @Size(min = 13, max = 19, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String newAccountPan;

    @Size(min = 2, max = 2, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String oldExpiryMonth;

    @Size(min = 2, max = 2, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String oldExpiryYear;

    @Size(min = 2, max = 2, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String newExpiryMonth;

    @Size(min = 2, max = 2, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String newExpiryYear;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 1, max = 1, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String ips;

    @Size(min = 1, max = 500, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String commentText;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private String reasonCode;

    @Valid
    @NotNull(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private AuditInfoDto auditInfo;

    @Pattern(regexp = "^(1|0)$|^$", message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String updateWalletProviderIndicator;

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

    public String getNewAccountPan() {
        return newAccountPan;
    }

    public void setNewAccountPan(String newAccountPan) {
        this.newAccountPan = newAccountPan;
    }

    public String getNewExpiryMonth() {
        return newExpiryMonth;
    }

    public void setNewExpiryMonth(String newExpiryMonth) {
        this.newExpiryMonth = newExpiryMonth;
    }

    public String getNewExpiryYear() {
        return newExpiryYear;
    }

    public void setNewExpiryYear(String newExpiryYear) {
        this.newExpiryYear = newExpiryYear;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public AuditInfoDto getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(AuditInfoDto auditInfo) {
        this.auditInfo = auditInfo;
    }

    public String getOldAccountPan() {
        return oldAccountPan;
    }

    public void setOldAccountPan(String oldAccountPan) {
        this.oldAccountPan = oldAccountPan;
    }

    public String getUpdateWalletProviderIndicator() {
        return updateWalletProviderIndicator;
    }

    public void setUpdateWalletProviderIndicator(String updateWalletProviderIndicator) {
        this.updateWalletProviderIndicator = updateWalletProviderIndicator;
    }

    public String getNewPanInternalId() {
        return newPanInternalId;
    }

    public void setNewPanInternalId(String newPanInternalId) {
        this.newPanInternalId = newPanInternalId;
    }

    public String getNewPanInternalGUID() {
        return newPanInternalGUID;
    }

    public void setNewPanInternalGUID(String newPanInternalGUID) {
        this.newPanInternalGUID = newPanInternalGUID;
    }

    public String getOldExpiryMonth() {
        return oldExpiryMonth;
    }

    public void setOldExpiryMonth(String oldExpiryMonth) {
        this.oldExpiryMonth = oldExpiryMonth;
    }

    public String getOldExpiryYear() {
        return oldExpiryYear;
    }

    public void setOldExpiryYear(String oldExpiryYear) {
        this.oldExpiryYear = oldExpiryYear;
    }
}
