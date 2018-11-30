package com.cts.fasttack.visa.vnts.server.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.cts.fasttack.common.core.dict.VisaErrorCode;
import com.cts.fasttack.common.core.validation.Minimal;

/**
 * Wallet Provider Message Tracing object
 *
 * @author a.lipavets
 */
public class WalletProviderMsgTracingDto {

    /**
     * ID assigned to the Initiator of the Token Request
     */
    @NotEmpty(message = VisaErrorCode.Codes.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(max = 11, min = 1, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @Digits(integer = 11, fraction = 0, message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
    @Min(value = 0L, message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
    private String tokenRequestorID;

    /**
     * ID for this message. Should be used by issuer in event/message logging to correlate between issuer, DWP, and Visa systems
     */
    @NotEmpty(message = VisaErrorCode.Codes.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(max = 64, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    private String wpRequestId;

    /**
     * A message identifier that may be used to link some messages associated with a provisioning request.
     */
    @NotEmpty(message = VisaErrorCode.Codes.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(max = 64, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    private String wpConversationId;

    /* getters and setters */

    public String getTokenRequestorID() {
        return tokenRequestorID;
    }

    public void setTokenRequestorID(String tokenRequestorID) {
        this.tokenRequestorID = tokenRequestorID;
    }

    public String getWpRequestId() {
        return wpRequestId;
    }

    public void setWpRequestId(String wpRequestId) {
        this.wpRequestId = wpRequestId;
    }

    public String getWpConversationId() {
        return wpConversationId;
    }

    public void setWpConversationId(String wpConversationId) {
        this.wpConversationId = wpConversationId;
    }
}
