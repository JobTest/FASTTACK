package com.cts.fasttack.core.data;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.core.dict.OtpMethodPlatform;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author a.lipavets
 */
@Entity
@Table(name = "CARDHOLDER_VERIFICATION_METHOD")
public class CardholderVerificationMethod implements Identifiable<Long> {

    @Id
    @GenericGenerator(
            name = "CARDHOLDER_VERIF_MET_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "CARDHOLDER_VERIF_MET_ID_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARDHOLDER_VERIF_MET_ID_SEQ")
    private Long id = -1L;

    @Column(name = "REQUEST_ID")
    private String requestId;

    @Column(name = "TRANSACTION_DATE")
    private Date transactionDate;

    @Column(name = "TOKEN_REF_ID")
    private String tokenRefId;

    @Column(name = "CORRELATION_ID")
    private String correlationId;

    @Column(name = "TOKENREQUESTOR_ID")
    private String tokenRequestorId;

    @Column(name = "CELLPHONE")
    private String cellPhone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BANKAPP_NAME")
    private String bankAppName;

    @Column(name = "CUSTOMER_SERVICE")
    private String customerService;

    @Column(name = "OUTBOUND_CALL")
    private String outboundCall;

    @Column(name = "OTP_METHOD_PLATFORM")
    private OtpMethodPlatform otpMethodPlatform;

    @Column(name = "CVM_IDENTIFIER_OTP")
    private String cvmIdentifierOtp;

    @Column(name = "PAN_INTERNAL_ID")
    private String panInternalId;

    @Column(name = "PAN_INTERNAL_GUID")
    private String panInternalGUID;

    @Column(name = "MASKED_PAN")
    private String maskedPan;

    @Column(name = "TOKENIZATION_PATH")
    private String tokenizationPath;

    @Column(name = "WP_DEVICE_SCORE")
    private String wpDeviceScore;

    @Column(name = "WP_ACCOUNT_SCORE")
    private String wpAccountScore;

    @Column(name = "WP_PHONENUMBER_SCORE")
    private String wpPhonenumberScore;

    @Column(name = "WP_REASON_CODES")
    private String wpReasonCodes;

    @Column(name = "CLR_TOKENIZATION_STANDARD_VER")
    private String colorTokenizationStandardVersion;

    @Column(name = "DEVICE_TYPE")
    private String deviceType;

    @Column(name = "DEVICE_NAME")
    protected String deviceName;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null || id < 1;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTokenRefId() {
        return tokenRefId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
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

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankAppName() {
        return bankAppName;
    }

    public void setBankAppName(String bankAppName) {
        this.bankAppName = bankAppName;
    }

    public String getCustomerService() {
        return customerService;
    }

    public void setCustomerService(String customerService) {
        this.customerService = customerService;
    }

    public String getOutboundCall() {
        return outboundCall;
    }

    public void setOutboundCall(String outboundCall) {
        this.outboundCall = outboundCall;
    }

    public OtpMethodPlatform getOtpMethodPlatform() {
        return otpMethodPlatform;
    }

    public void setOtpMethodPlatform(OtpMethodPlatform otpMethodPlatform) {
        this.otpMethodPlatform = otpMethodPlatform;
    }

    public String getCvmIdentifierOtp() {
        return cvmIdentifierOtp;
    }

    public void setCvmIdentifierOtp(String cvmIdentifierOtp) {
        this.cvmIdentifierOtp = cvmIdentifierOtp;
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

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getTokenizationPath() {
        return tokenizationPath;
    }

    public void setTokenizationPath(String tokenizationPath) {
        this.tokenizationPath = tokenizationPath;
    }

    public String getWpDeviceScore() {
        return wpDeviceScore;
    }

    public void setWpDeviceScore(String wpDeviceScore) {
        this.wpDeviceScore = wpDeviceScore;
    }

    public String getWpAccountScore() {
        return wpAccountScore;
    }

    public void setWpAccountScore(String wpAccountScore) {
        this.wpAccountScore = wpAccountScore;
    }

    public String getWpPhonenumberScore() {
        return wpPhonenumberScore;
    }

    public void setWpPhonenumberScore(String wpPhonenumberScore) {
        this.wpPhonenumberScore = wpPhonenumberScore;
    }

    public String getWpReasonCodes() {
        return wpReasonCodes;
    }

    public void setWpReasonCodes(String wpReasonCodes) {
        this.wpReasonCodes = wpReasonCodes;
    }

    public String getColorTokenizationStandardVersion() {
        return colorTokenizationStandardVersion;
    }

    public void setColorTokenizationStandardVersion(String colorTokenizationStandardVersion) {
        this.colorTokenizationStandardVersion = colorTokenizationStandardVersion;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
