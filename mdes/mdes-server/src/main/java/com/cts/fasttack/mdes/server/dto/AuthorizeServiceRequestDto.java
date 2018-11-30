package com.cts.fasttack.mdes.server.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.validation.ValidEnum;
import com.cts.fasttack.mdes.server.dict.TokenType;
import com.cts.fasttack.mdes.server.validation.NotEmptyFields;

/**
 * Authorize service request DTO
 *
 * @author Dmitry Koval
 */
@XmlRootElement(name = "request")
public class AuthorizeServiceRequestDto extends CommonMdesRequestDto {

    /**
     * Array of services that are being requested for the account
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @NotEmptyFields(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private List<String> services;


    /**
     * Contains card information of the card to be digitized
     */
    @NotNull(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Valid
    private CardInfo cardInfo;

    /**
     * Value linking pre-digitization messages generated during provisioning
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 14, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String correlationId;


    /**
     * The party that requested the digitization
     */
    @Size(max = 11, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "\\d+|^$", message = StandardErrorCodes.Names.INVALID_FIELD_FORMAT)
    private String tokenRequestorId;

    /**
     * The identifier of the Wallet Provider who requested the digitization
     */
    @Size(max = 3, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String walletId;

    /**
     * The identifier of the Payment App instance within a device that will be provisioned with a token
     */
    @Size(max = 48, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String paymentAppInstanceId;

    /**
     * SHA-256 hash of the Cardholder's account ID with the Payment App Provider
     */
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "^[A-Fa-f0-9]{0,64}$|^$", message = StandardErrorCodes.Names.INVALID_FIELD_FORMAT)
    private String accountIdHash;

    /**
     * The last few digits (typically four) of the device's mobile phone number
     */
    private Integer mobileNumberSuffix;

    /**
     * The number of active tokens that already exist for the PAN based on the token type
     */
    private Integer activeTokenCount;

    /**
     * Contains information about the target device to be provisioned
     */
    @Valid
    private DeviceInfo deviceInfo;

    /**
     * Contains information about the decision recommended by the Wallet Provider
     */
    @Valid
    private WalletProviderDecisioningInfo walletProviderDecisioningInfo;

    /**
     * The type of token requested for this digitization
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @ValidEnum(enumType = TokenType.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String tokenType;

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getPaymentAppInstanceId() {
        return paymentAppInstanceId;
    }

    public void setPaymentAppInstanceId(String paymentAppInstanceId) {
        this.paymentAppInstanceId = paymentAppInstanceId;
    }

    public String getAccountIdHash() {
        return accountIdHash;
    }

    public void setAccountIdHash(String accountIdHash) {
        this.accountIdHash = accountIdHash;
    }

    public Integer getMobileNumberSuffix() {
        return mobileNumberSuffix;
    }

    public void setMobileNumberSuffix(Integer mobileNumberSuffix) {
        this.mobileNumberSuffix = mobileNumberSuffix;
    }

    public Integer getActiveTokenCount() {
        return activeTokenCount;
    }

    public void setActiveTokenCount(Integer activeTokenCount) {
        this.activeTokenCount = activeTokenCount;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public WalletProviderDecisioningInfo getWalletProviderDecisioningInfo() {
        return walletProviderDecisioningInfo;
    }

    public void setWalletProviderDecisioningInfo(WalletProviderDecisioningInfo walletProviderDecisioningInfo) {
        this.walletProviderDecisioningInfo = walletProviderDecisioningInfo;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
