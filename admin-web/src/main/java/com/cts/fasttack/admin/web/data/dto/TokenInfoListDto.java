package com.cts.fasttack.admin.web.data.dto;

import com.cts.fasttack.admin.web.data.dict.TokenStatus;
import com.cts.fasttack.common.core.util.CustomJsonDateDeserializer;
import com.cts.fasttack.common.core.util.CustomJsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * @author Anton Leliuk
 */
public class TokenInfoListDto {

    private TokenInfoId tokenId;

    @JsonDeserialize(using = CustomJsonDateDeserializer.DateTime.class)
    @JsonSerialize(using = CustomJsonDateSerializer.DateTime.class)
    private Date tokenEventDate;

    private String tokenEventSource;

    private String tokenEventType;

    private String customerId;

    private String ips;

    private String maskedPan;

    private String deviceName;

    private String customerPhone;

    private String panInternalId;

    private String panInternalGuid;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date digitizeDate;

    @JsonFormat(pattern = "MM.yyyy")
    private Date tokenExpdate;

    private String panSource;

    private TokenStatus tokenStatus;
    
    private Long bin;

    private String reminderPeriod;

    private String tokenizationPath;

    private String wpDeviceScore;

    private String wpAccountScore;

    private String wpPhonenumberScore;

    private String wpReasonCodes;

    private String clrTokenizationStandardVer;

    private String tokenRequestorTitle;

    public TokenInfoId getTokenId() {
        return tokenId;
    }

    public void setTokenId(TokenInfoId tokenId) {
        this.tokenId = tokenId;
    }

    public Date getTokenEventDate() {
        return tokenEventDate;
    }

    public void setTokenEventDate(Date tokenEventDate) {
        this.tokenEventDate = tokenEventDate;
    }

    public String getTokenEventSource() {
        return tokenEventSource;
    }

    public void setTokenEventSource(String tokenEventSource) {
        this.tokenEventSource = tokenEventSource;
    }

    public String getTokenEventType() {
        return tokenEventType;
    }

    public void setTokenEventType(String tokenEventType) {
        this.tokenEventType = tokenEventType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

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

    public Date getDigitizeDate() {
        return digitizeDate;
    }

    public void setDigitizeDate(Date digitizeDate) {
        this.digitizeDate = digitizeDate;
    }

    public Date getTokenExpdate() {
        return tokenExpdate;
    }

    public void setTokenExpdate(Date tokenExpdate) {
        this.tokenExpdate = tokenExpdate;
    }

    public String getPanSource() {
        return panSource;
    }

    public void setPanSource(String panSource) {
        this.panSource = panSource;
    }

    public TokenStatus getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(TokenStatus tokenStatus) {
        this.tokenStatus = tokenStatus;
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

    public String getClrTokenizationStandardVer() {
        return clrTokenizationStandardVer;
    }

    public void setClrTokenizationStandardVer(String clrTokenizationStandardVer) {
        this.clrTokenizationStandardVer = clrTokenizationStandardVer;
    }

    public String getTokenRequestorTitle() {
        return tokenRequestorTitle;
    }

    public void setTokenRequestorTitle(String tokenRequestorTitle) {
        this.tokenRequestorTitle = tokenRequestorTitle;
    }
}
