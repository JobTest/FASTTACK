package com.cts.fasttack.bank.server.dto;

import com.cts.fasttack.bank.server.validation.ValidateCardDataUpdate;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Card Data Update request DTO.
 */
@ValidateCardDataUpdate(message = StandardErrorCodes.Names.INVALID_JSON)
public class CardDataUpdateRequestDto extends CommonTokenLifecycleRequestDto {

    /**
     * Unique ID for the token associated with the PAN.
     * This ID can be used in lieu of the token for subsequent calls, such as life cycle events
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 1, max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String tokenRefId;

    /**
     * Unique ID assigned to the initiator of the token request
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 11, max = 11, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String tokenRequestorId;

    /**
     * Card number
     */
    @Size(min = 13, max = 19, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "\\d+|^$", message = StandardErrorCodes.Names.INVALID_FIELD_FORMAT)
    private String newAccountPan;

    /**
     * Unique card identifier in bank system
     */
    @Size(min = 1, max = 30, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String newPanInternalId;

    /**
     * Unique card identifier in bank system
     */
    @Size(min = 1, max = 32, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String newPanInternalGUID;

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

    public String getNewAccountPan() {
        return newAccountPan;
    }

    public void setNewAccountPan(String newAccountPan) {
        this.newAccountPan = newAccountPan;
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
}
