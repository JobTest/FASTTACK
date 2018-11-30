package com.cts.fasttack.visa.vtis.server.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.cts.fasttack.common.core.dict.VisaErrorCode;
import com.cts.fasttack.common.core.validation.Minimal;

/**
 * @author Dmitry Koval
 */
public class TokenNotificationRequestDto {

    @Size(max = 256, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String messageReason;

    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Pattern(regexp = "^(3701|3702|3703|3711|3712|3713|3714|3715)$", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String messageReasonCode;

    @NotNull(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    private String dateTimeOfEvent;

    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(max = 32, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String panReferenceID;

    @Size(max = 48, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String deviceID;

    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(max = 7000, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String encryptedData;

    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Pattern(regexp = "^(00|05|85)$", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String actionCode;
    
    @Pattern(regexp = "^(VERIFICATION_SUCCESS|VERIFICATION_CODE_EXPIRED|VERIFICATION_CODE_FAILED|VERIFICATION_CODE_MISSING|VERIFICATION_CODE_RETRIES_EXCEEDED)$|^$", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String activationVerificationResult;
    
    public String getMessageReason() {
        return messageReason;
    }

    public void setMessageReason(String messageReason) {
        this.messageReason = messageReason;
    }

    public String getMessageReasonCode() {
        return messageReasonCode;
    }

    public void setMessageReasonCode(String messageReasonCode) {
        this.messageReasonCode = messageReasonCode;
    }

    public String getDateTimeOfEvent() {
        return dateTimeOfEvent;
    }

    public void setDateTimeOfEvent(String dateTimeOfEvent) {
        this.dateTimeOfEvent = dateTimeOfEvent;
    }

    public String getPanReferenceID() {
        return panReferenceID;
    }

    public void setPanReferenceID(String panReferenceID) {
        this.panReferenceID = panReferenceID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getActivationVerificationResult() {
		return activationVerificationResult;
	}

	public void setActivationVerificationResult(String activationVerificationResult) {
		this.activationVerificationResult = activationVerificationResult;
	}
}
