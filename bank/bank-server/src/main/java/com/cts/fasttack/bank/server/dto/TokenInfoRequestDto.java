package com.cts.fasttack.bank.server.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.bank.server.validation.ValidateLifecycleTokenRequest;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.validation.ValidEnum;

/**
 * Request DTO for getting token info.
 * <p>
 * Contains common token request fields at universal issuer API.
 *
 * @author v.semerkov
 */
@ValidateLifecycleTokenRequest(message = StandardErrorCodes.Names.INVALID_JSON)
public class TokenInfoRequestDto extends CommonTokenLifecycleRequestDto {

    /**
     * Unique ID for the token associated with the PAN.
     * This ID can be used in lieu of the token for subsequent calls, such as life cycle events
     */
    @Size(min = 1, max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String tokenRefId;

    /**
     * Unique ID assigned to the initiator of the token request
     */
    @Size(min = 11, max = 11, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String tokenRequestorId;

    /**
     * Unique card identifier in bank system
     */
    @Size(min = 1, max = 30, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String panInternalId;

    /**
     * Unique card identifier in bank system
     */
    @Size(min = 1, max = 32, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String panInternalGUID;

    /**
     * Card number
     */
    @Size(min = 13, max = 19, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "\\d+|^$", message = StandardErrorCodes.Names.INVALID_FIELD_FORMAT)
    private String pan;

    /**
     * Unique client wallet identifier
     */
    @Pattern(regexp = "[0-9a-zA-Z_-]+|^$")
    @Size(min = 1, max = 48, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String paymentAppInstanceId;

    /**
     * International payment system
     */
    @Size(min = 1, max = 1, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @ValidEnum(enumType = InternationalPaymentSystem.class, message = StandardErrorCodes.Names.INVALID_FIELD_FORMAT)
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private String ips;

    /**
     * Audit info
     */
    @Valid
    @NotNull(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private AuditInfoDto auditInfo;

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

    public AuditInfoDto getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(AuditInfoDto auditInfo) {
        this.auditInfo = auditInfo;
    }
}
