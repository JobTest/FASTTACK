package com.cts.fasttack.admin.web.data.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.cts.fasttack.admin.web.data.dict.TokenStatus;
import com.cts.fasttack.common.core.util.CustomJsonDateDeserializer;
import com.cts.fasttack.common.core.util.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Dmitry Koval
 */
public class TokenHistoryDto {

    private String tokenRefId;

    private String tokenRequestorId;

    private String wprequestId;

    private String wpconversationId;

    private String tokenEventType;

    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date tokenEventDate;

    private String tokenEventSource;

    private String tokenEventReason;

    private String messageReasonCode;

    private String eventRef;

    private TokenStatus tokenStatus;

    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    @DateTimeFormat(pattern = "MM.yyyy")
    private Date tokenExpdate;

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
}
