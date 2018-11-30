package com.cts.fasttack.visa.vnts.server.dto;

import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cts.fasttack.common.core.dict.VisaErrorCode;
import com.cts.fasttack.common.core.validation.Minimal;
import com.cts.fasttack.visa.common.dto.CommonVisaRequestDto;
import com.cts.fasttack.visa.vnts.server.validation.ValidateIfFieldsAreEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * SendPasscodeReq request
 *
 * @author a.lipavets
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sendPasscodeReq", namespace = "http://vnts.visa.com/tpcas/v1")
@ValidateIfFieldsAreEmpty(message = VisaErrorCode.Codes.MISSING_REQUIRED_FIELD)
public class SendPasscodeRequestDto extends CommonVisaRequestDto {

    /**
     * Unique and opaque identifer for the delivery method
     * selected by the cardholder
     */
    @Size(min = 1, max = 32, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @NotEmpty(message = VisaErrorCode.Codes.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    private String otpMethodIdentifier;

    /**
     * OTP value. In the initial release it will be populated
     * with 6 digit values; in the future, the value may be
     * expanded up to 8 digit length
     */
    @Size(min = 1, max = 8, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @NotEmpty(message = VisaErrorCode.Codes.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @XmlElement(name = "OTPCode")
    @JsonProperty("OTPCode")
    private String otpCode;

    /**
     * OTP Code Expiration
     */
    @XmlElement(name = "OTPCodeExp")
    @JsonProperty("OTPCodeExp")
    @Future(message = VisaErrorCode.Codes.RESOLUTION_METHOD_ID_IS_NOT_VALID_ANY_MORE)
    private Date otpCodeExp;

    /**
     * Wallet Provider Message Tracing object
     */
    @Valid
    @NotNull(message = VisaErrorCode.Codes.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    private WalletProviderMsgTracingDto walletProviderMsgTracing;

    /**
     * Positive Integer. Also known as TranID in ISO messages.
     */
    @NotEmpty(message = VisaErrorCode.Codes.MISSING_REQUIRED_FIELD, groups = Minimal.class)
    @Size(max = 15, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @Digits(integer = 15, fraction = 0, message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
    @Min(value = 0L, message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
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

    public String getOtpMethodIdentifier() {
        return otpMethodIdentifier;
    }

    public void setOtpMethodIdentifier(String otpMethodIdentifier) {
        this.otpMethodIdentifier = otpMethodIdentifier;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public Date getOtpCodeExp() {
        return otpCodeExp;
    }

    public void setOtpCodeExp(Date otpCodeExp) {
        this.otpCodeExp = otpCodeExp;
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
