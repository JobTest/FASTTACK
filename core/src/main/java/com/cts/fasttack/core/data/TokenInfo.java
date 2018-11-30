package com.cts.fasttack.core.data;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.dict.PanSourceType;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dict.TokenType;


/**
 * Содержит информацию о статусе токена оцифрованной карты
 *
 * @author a.lipavets
 */
@Entity
@Table(name = "TOKEN_INFO")
public class TokenInfo implements Identifiable<TokenInfoId>{

    @EmbeddedId
    private TokenInfoId id;

    @Column(name = "PAN_INTERNAL_ID")
    private String panInternalId;

    @Column(name = "PAN_INTERNAL_GUID")
    private String panInternalGuid;

    @Column(name = "PAN_REF_ID")
    private String panRefId;

    @Column(name = "MASKED_PAN")
    private String maskedPan;

    @Column(name = "MASKED_TOKEN")
    private String maskedToken;

    @Temporal(TemporalType.DATE)
    @Column(name = "TOKEN_EXPDATE")
    private Date tokenExpdate;

    @Column(name = "LIFECYCLE_TRACE_ID")
    private String lifecycleTraceId;

    @Column(name = "PAN_SOURCE")
    @Enumerated(EnumType.STRING)
    private PanSourceType panSource;

    @Column(name = "ACTIVE_TOKEN_COUNT")
    private String activeTokenCount;

    @Column(name = "TOKEN_TYPE")
    @Enumerated(EnumType.STRING)
    private TokenType tokenType;

    @Column(name = "TOKEN_STATUS")
    @Enumerated(EnumType.STRING)
    private TokenStatus tokenStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DIGITIZE_DATE")
    private Date digitizeDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TOKEN_STATUS_UPDATE")
    private Date tokenStatusUpdate;

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "CUSTOMER_PHONE")
    private String customerPhone;

    @Column(name = "IPS")
    @Enumerated(EnumType.STRING)
    private InternationalPaymentSystem ips;

    @Column(name = "CLIENT_WALLET_ACCOUNT_ID")
    private String clientWalletAccountId;

    /** BIN (в BIN_SETUP) карты, к которой создан токен */
    @Column(name = "BIN")
    private Long bin;

    @Column(name = "REMINDER_PERIOD")
    private String reminderPeriod;

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

    @Transient
    private boolean isNew = false;

    @Override
    public TokenInfoId getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setId(TokenInfoId id) {
        this.id = id;
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

    public String getTokenizationPath() {
        return tokenizationPath;
    }

    public void setTokenizationPath(String tokenizationPath) {
        this.tokenizationPath = tokenizationPath;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getReminderPeriod() {
        return reminderPeriod;
    }

    public void setReminderPeriod(String reminderPeriod) {
        this.reminderPeriod = reminderPeriod;
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
}
