package com.cts.fasttack.core.dto;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.dict.PanSourceType;
import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dict.TokenType;

/**
 * DTO for {@link com.cts.fasttack.core.data.TokenInfo}
 *
 * @author a.lipavets
 */
public class TokenInfoDto extends IdentifierDto<TokenInfoId> {

    private String panInternalId;

    private String panInternalGuid;

    private String panRefId;

    private String maskedPan;

    private String maskedToken;

    private Date tokenExpdate;

    private String lifecycleTraceId;

    private PanSourceType panSource;

    private String activeTokenCount;

    private TokenType tokenType;

    private TokenStatus tokenStatus;

    private Date digitizeDate;

    private Date tokenStatusUpdate;

    private String customerId;

    private String customerPhone;

    private InternationalPaymentSystem ips;

    private String clientWalletAccountId;

    private Long bin;

    private String reminderPeriod;

    private String tokenizationPath;

    private String wpDeviceScore;

    private String wpAccountScore;

    private String wpPhonenumberScore;

    private String wpReasonCodes;

    private String clrTokenizationStandardVer;

    private String tokenRequestorTitle;

    @Override
    public boolean isNew() {
        return StringUtils.isBlank(getId().getTokenRefId()) || StringUtils.isBlank(getId().getTokenRequestorId());
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

    public PanSourceType getPanSource() {
        return panSource;
    }

    public void setPanSource(PanSourceType panSource) {
        this.panSource = panSource;
    }

    public String getActiveTokenCount() {
        return activeTokenCount;
    }

    public void setActiveTokenCount(String activeTokenCount) {
        this.activeTokenCount = activeTokenCount;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
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
