package com.cts.fasttack.admin.web.data.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.cts.fasttack.admin.web.data.dict.TokenStatus;
import com.cts.fasttack.common.core.util.CustomJsonDateSerializer;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Dto for Token Info
 *
 * @author Dmitry Koval
 */
public class TokenInfoDto {

    /**
     * identifier
     */
    private TokenInfoId id;

    /**
     * PAN internal number
     */
    private String panInternalId;

    /**
     * PAN second internal number
     */
    private String panInternalGuid;

    /**
     * Unique ID for the PAN
     */
    private String panRefId;

    /**
     * Masked card number
     */
    private String maskedPan;

    /**
     * Masked token number
     */
    private String maskedToken;

    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date tokenExpdate;

    /**
     * Trace ID
     */
    private String lifecycleTraceId;

    /**
     * Source of the PAN
     */
    private String panSource;

    /**
     * The number of active tokens
     * that already exist for the PAN based on the token type
     */
    private String activeTokenCount;

    /**
     * Token Type
     */
    private String tokenType;

    /**
     * Token status
     */
    private TokenStatus tokenStatus;

    /**
     * Date of create token
     */
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date digitizeDate;

    /**
     * Date of update status token
     */
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date tokenStatusUpdate;

    /**
     * Unique customer identifier
     */
    private String customerId;

    /**
     * Customer phone
     */
    private String customerPhone;

    /**
     * International Payment System
     */
    private InternationalPaymentSystem ips;

    /**
     * Mastercard - The identifier of the Payment App instance
     * VISA -Consumer ID identifying the wallet accountholder entity
     */
    private String clientWalletAccountId;

    private DeviceInfoDto deviceInfo;
    
    /**
     * BIN карты, для которой создан токен
     */
    private Long bin;

    private String reminderPeriod;

    /**
     * отражает в МПС маршрут токенизации (GREEN/YELLOW/ORANGE)
     */
    private String tokenizationPath;

    private String wpDeviceScore;

    private String wpAccountScore;

    private String wpPhonenumberScore;

    private String wpReasonCodes;

    private String colorTokenizationStandardVersion;

    private String tokenRequestorTitle;

    public String getPanInternalId() {
        return panInternalId;
    }

    public void setPanInternalId(String panInternalId) {
        this.panInternalId = panInternalId;
    }

    public String getPanInternalGuid() {
        return panInternalGuid;
    }

    public void setPanInternalGuid(String panInternalGuid) {
        this.panInternalGuid = panInternalGuid;
    }

    public String getPanRefId() {
        return panRefId;
    }

    public void setPanRefId(String panRefId) {
        this.panRefId = panRefId;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getMaskedToken() {
        return maskedToken;
    }

    public void setMaskedToken(String maskedToken) {
        this.maskedToken = maskedToken;
    }

    public Date getTokenExpdate() {
        return tokenExpdate;
    }

    public void setTokenExpdate(Date tokenExpdate) {
        this.tokenExpdate = tokenExpdate;
    }

    public String getLifecycleTraceId() {
        return lifecycleTraceId;
    }

    public void setLifecycleTraceId(String lifecycleTraceId) {
        this.lifecycleTraceId = lifecycleTraceId;
    }

    public String getPanSource() {
        return panSource;
    }

    public void setPanSource(String panSource) {
        this.panSource = panSource;
    }

    public String getActiveTokenCount() {
        return activeTokenCount;
    }

    public void setActiveTokenCount(String activeTokenCount) {
        this.activeTokenCount = activeTokenCount;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public TokenStatus getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(TokenStatus tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public Date getDigitizeDate() {
        return digitizeDate;
    }

    public void setDigitizeDate(Date digitizeDate) {
        this.digitizeDate = digitizeDate;
    }

    public Date getTokenStatusUpdate() {
        return tokenStatusUpdate;
    }

    public void setTokenStatusUpdate(Date tokenStatusUpdate) {
        this.tokenStatusUpdate = tokenStatusUpdate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public InternationalPaymentSystem getIps() {
        return ips;
    }

    public void setIps(InternationalPaymentSystem ips) {
        this.ips = ips;
    }

    public String getClientWalletAccountId() {
        return clientWalletAccountId;
    }

    public void setClientWalletAccountId(String clientWalletAccountId) {
        this.clientWalletAccountId = clientWalletAccountId;
    }

    public TokenInfoId getId() {
        return id;
    }

    public void setId(TokenInfoId id) {
        this.id = id;
    }

    public DeviceInfoDto getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfoDto deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public Long getBin() {
        return bin;
    }

    public void setBin(Long bin) {
        this.bin = bin;
    }

    public String getReminderPeriod() {
        return reminderPeriod;
    }

    public void setReminderPeriod(String reminderPeriod) {
        this.reminderPeriod = reminderPeriod;
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

    public String getTokenRequestorTitle() {
        return tokenRequestorTitle;
    }

    public void setTokenRequestorTitle(String tokenRequestorTitle) {
        this.tokenRequestorTitle = tokenRequestorTitle;
    }
}
