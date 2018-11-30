package com.cts.fasttack.core.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.cts.fasttack.common.core.util.CustomJsonDateDeserializer;
import com.cts.fasttack.common.core.util.CustomJsonDateSerializer;
import com.cts.fasttack.core.dict.TokenStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * DTO for {@link com.cts.fasttack.core.data.TokenHistory}
 *
 * @author a.lipavets
 */
public class TokenHistoryDto extends IdentifierDto<Long> {

    private String tokenRefId;

    private String tokenRequestorId;

    private String wprequestId;

    private String wpconversationId;

    private String tokenEventType;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date tokenEventDate;

    private String tokenEventSource;

    private String tokenEventReason;

    private String messageReasonCode;

    private String eventRef;

    private String mdesReason;

    private Boolean success;
    
    private TokenStatus tokenStatus;
    
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    @DateTimeFormat(pattern = "MM.yyyy")
    private Date tokenExpdate;

    private String reminderPeriod;

    /** getters and setters */

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
