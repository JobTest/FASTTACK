package com.cts.fasttack.mdes.server.dto;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.mdes.server.dict.Decision;
import com.cts.fasttack.mdes.server.dict.DecisionMadeBy;
import com.cts.fasttack.mdes.server.dict.TokenType;
import com.cts.fasttack.common.core.validation.ValidEnum;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Notify Service Activated
 *
 * @author a.lipavets
 */
@XmlRootElement(name = "request")
public class NotifyServiceActivatedRequestDto extends CommonMdesRequestDto {

    /**
     * Array of services that are being requested for the account
     */
    @NotNull(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 1, message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private String[] services;

    /**
     * Contains card and token information of the card to be digitized
     */
    @NotNull(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Valid
    private CardAndTokenInfo cardAndToken​;

    /**
     * Contains information about the target device to be provisioned
     */
    @Valid
    private DeviceInfo deviceInfo;

    /**
     * The party that requested the digitization
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 11, max = 11, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "\\d+", message = StandardErrorCodes.Names.INVALID_FIELD_FORMAT)
    private String tokenRequestorId;

    /**
     * Value linking pre-digitization messages generated during provisioning
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 14, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String correlationId;

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
     * The type of token requested for this digitization
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 16, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @ValidEnum(enumType = TokenType.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String tokenType;

    /**
     * The identifier of the Secure Element to be provisioned with the token
     */
    @Size(max = 128, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String secureElementId;

    /**
     * The last few digits (typically four) of the Account PAN being digitized
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 8, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String accountPanSuffix;


    /**
     * The date and time the service for the PAN was requested
     */
    @NotNull(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private Date serviceRequestDateTime;

    /**
     * The Terms and Conditions as presented to and accepted by the Cardholder
     */
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String termsAndConditionsAssetId;

    /**
     * The date and time the Terms and Conditions were accepted by the Cardholder
     */
    private Date termsAndConditionsAcceptedTimestamp;

    /**
     * Freeform identifier for the product configuration as assigned by the Issuer
     */
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String productConfigurationId;

    /**
     * Language preference selected by the consumer
     */
    @Size(max = 2, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String consumerLanguage;

    /**
     * The authorization decision for the service request
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @ValidEnum(enumType = Decision.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String decision;

    /**
     * The process that determined the final authorization decision for the request
     */
    @Size(max = 32, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @ValidEnum(enumType = DecisionMadeBy.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String decisionMadeBy;

    /**
     * The date where tokens were activated
     */
    @NotNull(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private Date tokenActivatedDateTime;

    /**
     * The number of times an Activation Code was received to activate the token
     */
    @Size(min = 1, max = 1, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "\\d+|^$", message = StandardErrorCodes.Names.INVALID_FIELD_FORMAT)
    private String numberOfActivationAttempts;

    /**
     * The number of active tokens for the Primary Account Number
     */
    @Size(max = 2, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "\\d+|^$", message = StandardErrorCodes.Names.INVALID_FIELD_FORMAT)
    private String numberOfActiveTokens;

    /**
     * The assurance level assigned to the token
     */
    @Size(max = 2, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "\\d+|^$", message = StandardErrorCodes.Names.INVALID_FIELD_FORMAT)
    private String tokenAssuranceLevel;

    /** getters and setters */
    public String[] getServices() {
        return services;
    }

    public void setServices(String[] services) {
        this.services = services;
    }

    public CardAndTokenInfo getCardAndToken​() {
        return cardAndToken​;
    }

    public void setCardAndToken​(CardAndTokenInfo cardAndToken​) {
        this.cardAndToken​ = cardAndToken​;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
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

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getSecureElementId() {
        return secureElementId;
    }

    public void setSecureElementId(String secureElementId) {
        this.secureElementId = secureElementId;
    }

    public String getAccountPanSuffix() {
        return accountPanSuffix;
    }

    public void setAccountPanSuffix(String accountPanSuffix) {
        this.accountPanSuffix = accountPanSuffix;
    }

    public Date getServiceRequestDateTime() {
        return serviceRequestDateTime;
    }

    public void setServiceRequestDateTime(Date serviceRequestDateTime) {
        this.serviceRequestDateTime = serviceRequestDateTime;
    }

    public String getTermsAndConditionsAssetId() {
        return termsAndConditionsAssetId;
    }

    public void setTermsAndConditionsAssetId(String termsAndConditionsAssetId) {
        this.termsAndConditionsAssetId = termsAndConditionsAssetId;
    }

    public Date getTermsAndConditionsAcceptedTimestamp() {
        return termsAndConditionsAcceptedTimestamp;
    }

    public void setTermsAndConditionsAcceptedTimestamp(Date termsAndConditionsAcceptedTimestamp) {
        this.termsAndConditionsAcceptedTimestamp = termsAndConditionsAcceptedTimestamp;
    }

    public String getProductConfigurationId() {
        return productConfigurationId;
    }

    public void setProductConfigurationId(String productConfigurationId) {
        this.productConfigurationId = productConfigurationId;
    }

    public String getConsumerLanguage() {
        return consumerLanguage;
    }

    public void setConsumerLanguage(String consumerLanguage) {
        this.consumerLanguage = consumerLanguage;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getDecisionMadeBy() {
        return decisionMadeBy;
    }

    public void setDecisionMadeBy(String decisionMadeBy) {
        this.decisionMadeBy = decisionMadeBy;
    }

    public Date getTokenActivatedDateTime() {
        return tokenActivatedDateTime;
    }

    public void setTokenActivatedDateTime(Date tokenActivatedDateTime) {
        this.tokenActivatedDateTime = tokenActivatedDateTime;
    }

    public String getNumberOfActivationAttempts() {
        return numberOfActivationAttempts;
    }

    public void setNumberOfActivationAttempts(String numberOfActivationAttempts) {
        this.numberOfActivationAttempts = numberOfActivationAttempts;
    }

    public String getNumberOfActiveTokens() {
        return numberOfActiveTokens;
    }

    public void setNumberOfActiveTokens(String numberOfActiveTokens) {
        this.numberOfActiveTokens = numberOfActiveTokens;
    }

    public String getTokenAssuranceLevel() {
        return tokenAssuranceLevel;
    }

    public void setTokenAssuranceLevel(String tokenAssuranceLevel) {
        this.tokenAssuranceLevel = tokenAssuranceLevel;
    }
}
