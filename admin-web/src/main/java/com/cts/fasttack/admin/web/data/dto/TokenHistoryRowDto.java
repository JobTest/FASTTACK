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
public class TokenHistoryRowDto {

    private TokenInfoId tokenId;

    @JsonDeserialize(using = CustomJsonDateDeserializer.DateTime.class)
    @JsonSerialize(using = CustomJsonDateSerializer.DateTime.class)
    private Date tokenEventDate;

    private String tokenEventSource;

    private String tokenEventType;

    private String comment;

    private TokenStatus tokenStatus;

    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    @DateTimeFormat(pattern = "MM.yyyy")
    private Date tokenExpdate;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
