package com.cts.fasttack.core.data;

import com.cts.fasttack.common.core.util.CustomJsonDateDeserializer;
import com.cts.fasttack.common.core.util.CustomJsonDateSerializer;
import com.cts.fasttack.core.dict.TokenStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * @author Anton Leliuk
 */
@Entity
@Subselect(
        "SELECT ti.token_ref_id AS TOKEN_REF_ID, ti.tokenrequestor_id AS TOKENREQUESTOR_ID, th.token_event_date, " +
        "th.token_event_source, th.token_event_type, ti.pan_internal_id, ti.pan_internal_guid, ti.token_status, " +
        "ti.customer_id, ti.client_wallet_account_id, ti.masked_pan, ti.ips, di.device_name, ti.customer_phone, " +
                "ti.token_expdate, ti.digitize_date, ti.pan_source, ti.bin, ti.reminder_period, ti.tokenization_path, " +
                "ti.wp_device_score, ti.wp_account_score, ti.wp_phonenumber_score, ti.wp_reason_codes, ti.clr_tokenization_standard_ver, " +
                "ti.tokenrequestor_id AS token_requestor_title, " +
                "ti.digitize_date AS date_from, ti.token_status_update AS date_till " +
        "FROM TOKEN_INFO ti " +
        "LEFT JOIN ( " +
        "   SELECT MAX(th.token_event_date) AS token_event_date, MAX(th.token_event_source) AS token_event_source, " +
        "   MAX(th.token_event_type) AS token_event_type, th.token_ref_id, th.tokenrequestor_id " +
        "   FROM TOKEN_HISTORY th " +
        "   GROUP BY th.token_ref_id, th.tokenrequestor_id " +
        ") th ON th.token_ref_id = ti.token_ref_id AND th.tokenrequestor_id = ti.tokenrequestor_id " +
        "LEFT JOIN DEVICE_INFO di ON di.token_ref_id = ti.token_ref_id ")
@Synchronize({"TOKEN_INFO", "TOKEN_HISTORY", "DEVICE_INFO"})
public class TokenInfoList {

    @EmbeddedId
    private TokenInfoId tokenId;

    @JsonDeserialize(using = CustomJsonDateDeserializer.DateTime.class)
    @JsonSerialize(using = CustomJsonDateSerializer.DateTime.class)
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date tokenEventDate;

    private String tokenEventSource;

    private String tokenEventType;

    private String panInternalId;

    private String panInternalGuid;

    @Enumerated(EnumType.STRING)
    private TokenStatus tokenStatus;

    private String customerId;

    private String maskedPan;

    private String ips;

    private String deviceName;

    private String customerPhone;

    private String clientWalletAccountId;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date digitizeDate;

    @JsonFormat(pattern = "MM.yyyy")
    @DateTimeFormat(pattern = "MM.yyyy")
    private Date tokenExpdate;

    private String panSource;
    
    private Long bin;

    private String reminderPeriod;

    private String tokenizationPath;

    private String wpDeviceScore;

    private String wpAccountScore;

    private String wpPhonenumberScore;

    private String wpReasonCodes;

    private String clrTokenizationStandardVer;

    private String tokenRequestorTitle;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateFrom;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateTill;

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

    public TokenStatus getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(TokenStatus tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
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

    public String getClientWalletAccountId() {
        return clientWalletAccountId;
    }

    public void setClientWalletAccountId(String clientWalletAccountId) {
        this.clientWalletAccountId = clientWalletAccountId;
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

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTill() {
        return dateTill;
    }

    public void setDateTill(Date dateTill) {
        this.dateTill = dateTill;
    }
}
