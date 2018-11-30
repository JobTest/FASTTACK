package com.cts.fasttack.core.dto;

import java.util.Date;

import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.cts.fasttack.core.dict.OtpMethodPlatform;

/**
 * DTO for {@link com.cts.fasttack.core.data.CardholderVerificationMethod}
 *
 * @author a.lipavets
 */
public class CardholderVerificationMethodDto extends IdentifierDto<Long> {

    private Date transactionDate;

    private String requestId;

    private String tokenRefId;

    private String correlationId;

    private String tokenRequestorId;

    private String cellPhone;

    private String email;

    private String bankappName;

    private String customerService;

    private String outboundCall;

    private OtpMethodPlatform otpMethodPlatform;

    private String cvmIdentifierOtp;

    private String panInternalId;

    private String panInternalGUID;

    private String maskedPan;

    private String tokenizationPath;

    private String wpDeviceScore;

    private String wpAccountScore;

    private String wpPhonenumberScore;

    private String wpReasonCodes;

    private String colorTokenizationStandardVersion;

    private String deviceType;

    protected String deviceName;

    /** getters and setters */

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public String getBankappName() {
        return bankappName;
    }

    public void setBankappName(String bankappName) {
        this.bankappName = bankappName;
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
