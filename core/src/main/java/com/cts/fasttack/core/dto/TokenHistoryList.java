package com.cts.fasttack.core.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;
import org.springframework.format.annotation.DateTimeFormat;

import com.cts.fasttack.common.core.util.CustomJsonDateDeserializer;
import com.cts.fasttack.common.core.util.CustomJsonDateSerializer;
import com.cts.fasttack.core.data.TokenHistoryInfoId;
import com.cts.fasttack.core.dict.TokenStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Dmitry Koval
 */

@Entity
@Subselect(
        "SELECT th.id as ID, th.token_ref_id AS TOKEN_REF_ID, th.tokenrequestor_id AS TOKENREQUESTOR_ID, " +
                "th.token_event_date, th.token_event_source, th.token_event_type, th.token_status, th.token_expdate, th.reminder_period, tc.comcontent " +
                "FROM TOKEN_HISTORY th " +
                "LEFT JOIN TOKEN_COMMENT tc ON tc.event_ref = th.event_ref ")
@Synchronize({"TOKEN_HISTORY", "TOKEN_COMMENT"})
public class TokenHistoryList {

    @EmbeddedId
    private TokenHistoryInfoId tokenId;

    @JsonDeserialize(using = CustomJsonDateDeserializer.DateTime.class)
    @JsonSerialize(using = CustomJsonDateSerializer.DateTime.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date tokenEventDate;

    private String tokenEventSource;

    private String tokenEventType;

    @Enumerated(EnumType.STRING)
    private TokenStatus tokenStatus;

    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    @DateTimeFormat(pattern = "MM.yyyy")
    private Date tokenExpdate;

    @Column(name = "COMCONTENT")
    private String comment;

    @Column(name = "REMINDER_PERIOD")
    private String reminderPeriod;

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

    public TokenHistoryInfoId getTokenId() {
        return tokenId;
    }

    public void setTokenId(TokenHistoryInfoId tokenId) {
        this.tokenId = tokenId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReminderPeriod() {
        return reminderPeriod;
    }

    public void setReminderPeriod(String reminderPeriod) {
        this.reminderPeriod = reminderPeriod;
    }
}
