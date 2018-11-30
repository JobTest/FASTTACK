package com.cts.fasttack.core.data;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.core.dict.TokenStatus;

/**
 * Содержит историю всех запросов изменивших статус токена
 *
 * @author a.lipavets
 */
@Entity
@Table(name = "TOKEN_HISTORY")
public class TokenHistory implements Identifiable<Long> {

    @Id
    @GenericGenerator(
            name = "TOKEN_HISTORY_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "TOKEN_HISTORY_ID_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOKEN_HISTORY_ID_SEQ")
    private Long id = -1L;

    @Column(name = "TOKEN_REF_ID")
    private String tokenRefId;

    @Column(name = "TOKENREQUESTOR_ID")
    private String tokenRequestorId;

    @Column(name = "WPREQUEST_ID")
    private String wprequestId;

    @Column(name = "WPCONVERSATION_ID")
    private String wpconversationId;

    @Column(name = "TOKEN_EVENT_TYPE")
    private String tokenEventType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TOKEN_EVENT_DATE")
    private Date tokenEventDate;

    @Column(name = "TOKEN_EVENT_SOURCE")
    private String tokenEventSource;

    @Column(name = "TOKEN_EVENT_REASON")
    private String tokenEventReason;

    @Column(name = "MESSAGE_REASON_CODE")
    private String messageReasonCode;

    @Column(name = "EVENT_REF")
    private String eventRef;

    @Column(name = "MDES_REASON")
    private String mdesReason;

    @Column(name = "SUCCESS")
    private Boolean success;

    @Column(name = "TOKEN_STATUS")
    @Enumerated(EnumType.STRING)
    private TokenStatus tokenStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = "TOKEN_EXPDATE")
    private Date tokenExpdate;

    @Column(name = "REMINDER_PERIOD")
    private String reminderPeriod;

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

    public String getTokenRefId() {
        return tokenRefId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }

    public String getWprequestId() {
        return wprequestId;
    }

    public void setWprequestId(String wprequestId) {
        this.wprequestId = wprequestId;
    }

    public String getWpconversationId() {
        return wpconversationId;
    }

    public void setWpconversationId(String wpconversationId) {
        this.wpconversationId = wpconversationId;
    }

    public String getTokenEventType() {
        return tokenEventType;
    }

    public void setTokenEventType(String tokenEventType) {
        this.tokenEventType = tokenEventType;
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

    public String getTokenEventReason() {
        return tokenEventReason;
    }

    public void setTokenEventReason(String tokenEventReason) {
        this.tokenEventReason = tokenEventReason;
    }

    public String getMessageReasonCode() {
        return messageReasonCode;
    }

    public void setMessageReasonCode(String messageReasonCode) {
        this.messageReasonCode = messageReasonCode;
    }

    public String getEventRef() {
        return eventRef;
    }

    public void setEventRef(String eventRef) {
        this.eventRef = eventRef;
    }

    public String getMdesReason() {
        return mdesReason;
    }

    public void setMdesReason(String mdesReason) {
        this.mdesReason = mdesReason;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public TokenStatus getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(TokenStatus tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public Date getTokenExpdate() {
        return tokenExpdate;
    }

    public void setTokenExpdate(Date tokenExpdate) {
        this.tokenExpdate = tokenExpdate;
    }

    public String getReminderPeriod() {
        return reminderPeriod;
    }

    public void setReminderPeriod(String reminderPeriod) {
        this.reminderPeriod = reminderPeriod;
    }
}
