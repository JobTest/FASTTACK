package com.cts.fasttack.visa.vnts.server.dto;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.cts.fasttack.common.core.dict.VisaErrorCode;
import com.cts.fasttack.common.core.validation.Minimal;
import com.cts.fasttack.visa.common.dto.CommonVisaRequestDto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author a.lipavets
 */
@XmlRootElement(name = "getCardHolderVerificationMethodsReq", namespace = "http://vnts.visa.com/tpcas/v1")
public class CardholderVerificationMethodsRequestDto extends CommonVisaRequestDto {

    /**
     * OTP Reason
     * 01 – Provisioning
     * 02 – FPAN Notifications
     */
    @NotEmpty(message = VisaErrorCode.Codes.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(min = 2, max = 2, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "0[1-2]", message = VisaErrorCode.Codes.DATA_ELEMENT_NOT_VALID)
    private String otpReason;

    /**
     * This field describes whether the Token has exceeded the number OTP
     * requests and so is no longer a supported method for that token
     */
    private boolean otpMaxReached;

    @Valid
    private RiskInformationDto riskInformation;

    /**
     * This optional element is supported for issuers that participate in 0100 TAR.
     * The issuer can send values for this element in the 0100 TAR response. If
     * the issuer sends a value in the 0100 TAR, it will be sent in this element of
     * the Get CVM. If no value is sent in 0100 TAR or the issuer does not participate
     * in TAR, this element will not be present.
     */
    @Size(max = 100, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @Digits(integer = 100, fraction = 0, message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
    private String issuerSpecialConditionCodes;

    /**
     * Wallet Provider Message Tracing object
     */
    @Valid
    private WalletProviderMsgTracingDto walletProviderMsgTracing;

    /**
     * Positive Integer. Also known as TranID in ISO messages.
     */
    @NotEmpty(message = VisaErrorCode.Codes.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(max = 15, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @Digits(integer = 15, fraction = 0, message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
    private String lifeCycleTraceID;

    /**
     * Unique ID for the Token associated with the PAN.
     */
    @NotEmpty(message = VisaErrorCode.Codes.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(min = 1, max = 32, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    private String tokenReferenceID;

    /**
     * Unique ID for the PAN.
     */
    @NotEmpty(message = VisaErrorCode.Codes.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(min = 1, max = 32, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    private String panReferenceID;

    /**
     * Token value assigned to the PAN.
     */
    @NotEmpty(message = VisaErrorCode.Codes.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(min = 1, max = 19, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @Digits(integer = 19, fraction = 0, message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
    private String token;

    /**
     * Device Info object
     */
    @Valid
    private DeviceInfoDto deviceInfo;

    /**
     * Cardholder Info object
     */
    @Valid
    private CardholderInfoDto cardholderInfo;

    /**
     * Identifies a wallet account of the wallet provider
     */
    @Size(max = 32, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    private String walletAccountID;

    /* getters and setters */

    public String getOtpReason() {
        return otpReason;
    }

    public void setOtpReason(String otpReason) {
        this.otpReason = otpReason;
    }

    public boolean isOtpMaxReached() {
        return otpMaxReached;
    }

    public void setOtpMaxReached(boolean otpMaxReached) {
        this.otpMaxReached = otpMaxReached;
    }

    public RiskInformationDto getRiskInformation() {
        return riskInformation;
    }

    public void setRiskInformation(RiskInformationDto riskInformation) {
        this.riskInformation = riskInformation;
    }

    public String getIssuerSpecialConditionCodes() {
        return issuerSpecialConditionCodes;
    }

    public void setIssuerSpecialConditionCodes(String issuerSpecialConditionCodes) {
        this.issuerSpecialConditionCodes = issuerSpecialConditionCodes;
    }

    public WalletProviderMsgTracingDto getWalletProviderMsgTracing() {
        return walletProviderMsgTracing;
    }

    public void setWalletProviderMsgTracing(WalletProviderMsgTracingDto walletProviderMsgTracing) {
        this.walletProviderMsgTracing = walletProviderMsgTracing;
    }

    public String getLifeCycleTraceID() {
        return lifeCycleTraceID;
    }

    public void setLifeCycleTraceID(String lifeCycleTraceID) {
        this.lifeCycleTraceID = lifeCycleTraceID;
    }

    public String getTokenReferenceID() {
        return tokenReferenceID;
    }

    public void setTokenReferenceID(String tokenReferenceID) {
        this.tokenReferenceID = tokenReferenceID;
    }

    public String getPanReferenceID() {
        return panReferenceID;
    }

    public void setPanReferenceID(String panReferenceID) {
        this.panReferenceID = panReferenceID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DeviceInfoDto getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfoDto deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public CardholderInfoDto getCardholderInfo() {
        return cardholderInfo;
    }

    public void setCardholderInfo(CardholderInfoDto cardholderInfo) {
        this.cardholderInfo = cardholderInfo;
    }

    public String getWalletAccountID() {
        return walletAccountID;
    }

    public void setWalletAccountID(String walletAccountID) {
        this.walletAccountID = walletAccountID;
    }
}
