package com.cts.fasttack.bank.server.pushprovisioning.dto;

import com.cts.fasttack.bank.server.pushprovisioning.dict.Intent;
import com.cts.fasttack.bank.server.pushprovisioning.validation.ClientAppId;
import com.cts.fasttack.bank.server.pushprovisioning.validation.ClientDeviceId;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.validation.ValidEnum;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Anton Leliuk
 */
@XmlRootElement(name = "CreateOpaquePaymentCardRequest")
@ClientDeviceId(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
@ClientAppId(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
public class CreateOpaquePaymentCardRequestDto {

    /**
     * unique identifier of request
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private String requestId;

    /**
     * Card number
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 13, max = 19, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String pan;

    /**
     * Card expiry month
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 2, max = 2, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Digits(integer = 2, fraction = 0, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String expiryMonth;

    /**
     * Card expiry year
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 2, max = 2, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Digits(integer = 2, fraction = 0, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String expiryYear;

    /**
     * Country code in format according to ISO-3166-1
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 2, max = 2, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String country;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @ValidEnum(enumType = Intent.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String intent;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 50, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "[0-9A-Za-z-_]*", message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String clientWalletProvider;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 24, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "[0-9A-Za-z-_]*", message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String clientWalletAccountID;

    @Size(max = 24, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "[0-9A-Za-z-_]*", message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String clientDeviceID;

    @Size(max = 36, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "[A-Za-z0-9- ]*", message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String clientAppID;

    private boolean isIDnV;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 37, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String cardholderName;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @ValidEnum(enumType = InternationalPaymentSystem.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String ips;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getClientWalletProvider() {
        return clientWalletProvider;
    }

    public void setClientWalletProvider(String clientWalletProvider) {
        this.clientWalletProvider = clientWalletProvider;
    }

    public String getClientWalletAccountID() {
        return clientWalletAccountID;
    }

    public void setClientWalletAccountID(String clientWalletAccountID) {
        this.clientWalletAccountID = clientWalletAccountID;
    }

    public String getClientDeviceID() {
        return clientDeviceID;
    }

    public void setClientDeviceID(String clientDeviceID) {
        this.clientDeviceID = clientDeviceID;
    }

    public String getClientAppID() {
        return clientAppID;
    }

    public void setClientAppID(String clientAppID) {
        this.clientAppID = clientAppID;
    }

    public boolean isIDnV() {
        return isIDnV;
    }

    public void setIDnV(boolean IDnV) {
        isIDnV = IDnV;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }
}
