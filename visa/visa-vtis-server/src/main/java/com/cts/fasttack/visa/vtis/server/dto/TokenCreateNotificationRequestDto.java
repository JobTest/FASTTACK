package com.cts.fasttack.visa.vtis.server.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.cts.fasttack.common.core.dict.VisaErrorCode;
import com.cts.fasttack.common.core.validation.Minimal;
import com.cts.fasttack.common.core.validation.ValidEnum;
import com.cts.fasttack.visa.vtis.server.dict.ConsumerEntryModeType;
import com.cts.fasttack.visa.vtis.server.dict.PanSourceType;

/**
 * @author Dmitry Koval
 */
public class TokenCreateNotificationRequestDto {

    @Size(max = 256, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String messageReason;

    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Pattern(regexp = "^(3700)$", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String messageReasonCode;

    @NotNull(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    private String dateTimeOfEvent;

    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(max = 32, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String panReferenceID;

    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(max = 64, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String walletAccountEmailAddressHash;

    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(max = 32, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String clientWalletAccountID;

    @Pattern(regexp = "^(?!0)|(?!00)[0-9]{2}?$|^$", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String visaTokenScore;

    @Pattern(regexp = "^(00|05|85)$|^$", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String visaTokenDecisioning;

    @ValidEnum(enumType = PanSourceType.class, message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String panSource;

    @Size(max = 1, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String addressVerificationResultCode;

    @Size(max = 1, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String cvv2ResultsCode;

    @ValidEnum(enumType = ConsumerEntryModeType.class, message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String consumerEntryMode;

    @Size(max = 5, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String locale;

    @Valid
    private VisaDeviceInfo deviceInfo;

    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(max = 7000, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String encryptedData;

    @Valid
    private TermsAndConditions termsAndConditions;

    @Size(max = 100, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String issuerSpecialConditionCodes;

    @NotEmpty(message = VisaErrorCode.Names.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Pattern(regexp = "^(00|05|85)$", message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String actionCode;
    
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

    public String getWalletAccountEmailAddressHash() {
        return walletAccountEmailAddressHash;
    }

    public void setWalletAccountEmailAddressHash(String walletAccountEmailAddressHash) {
        this.walletAccountEmailAddressHash = walletAccountEmailAddressHash;
    }

    public String getClientWalletAccountID() {
        return clientWalletAccountID;
    }

    public void setClientWalletAccountID(String clientWalletAccountID) {
        this.clientWalletAccountID = clientWalletAccountID;
    }

    public String getVisaTokenScore() {
        return visaTokenScore;
    }

    public void setVisaTokenScore(String visaTokenScore) {
        this.visaTokenScore = visaTokenScore;
    }

    public String getVisaTokenDecisioning() {
        return visaTokenDecisioning;
    }

    public void setVisaTokenDecisioning(String visaTokenDecisioning) {
        this.visaTokenDecisioning = visaTokenDecisioning;
    }

    public String getPanSource() {
        return panSource;
    }

    public void setPanSource(String panSource) {
        this.panSource = panSource;
    }

    public String getAddressVerificationResultCode() {
        return addressVerificationResultCode;
    }

    public void setAddressVerificationResultCode(String addressVerificationResultCode) {
        this.addressVerificationResultCode = addressVerificationResultCode;
    }

    public String getCvv2ResultsCode() {
        return cvv2ResultsCode;
    }

    public void setCvv2ResultsCode(String cvv2ResultsCode) {
        this.cvv2ResultsCode = cvv2ResultsCode;
    }

    public String getConsumerEntryMode() {
        return consumerEntryMode;
    }

    public void setConsumerEntryMode(String consumerEntryMode) {
        this.consumerEntryMode = consumerEntryMode;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public VisaDeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(VisaDeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public TermsAndConditions getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(TermsAndConditions termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public String getIssuerSpecialConditionCodes() {
        return issuerSpecialConditionCodes;
    }

    public void setIssuerSpecialConditionCodes(String issuerSpecialConditionCodes) {
        this.issuerSpecialConditionCodes = issuerSpecialConditionCodes;
    }

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
}
