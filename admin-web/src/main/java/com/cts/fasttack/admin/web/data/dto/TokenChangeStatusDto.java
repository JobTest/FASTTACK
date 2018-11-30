package com.cts.fasttack.admin.web.data.dto;

import com.cts.fasttack.admin.web.validation.token.ValidateTokenComment;
import com.cts.fasttack.common.core.dict.TokenEventStatus;

/**
 * @author Dmitry Koval
 */
@ValidateTokenComment(message = "{token.comment.empty}")
public class TokenChangeStatusDto {

    private String tokenRefId;

    private String tokenRequestorId;

    private String pan;

    private String comment;

    private String tokenReason;

    private TokenEventStatus tokenEventStatus;

    private String eventRef;

    private String panInternalId;

    private String panInternalGuid;

    private String ips;

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

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTokenReason() {
        return tokenReason;
    }

    public void setTokenReason(String tokenReason) {
        this.tokenReason = tokenReason;
    }

    public TokenEventStatus getTokenEventStatus() {
        return tokenEventStatus;
    }

    public void setTokenEventStatus(TokenEventStatus tokenEventStatus) {
        this.tokenEventStatus = tokenEventStatus;
    }

    public String getEventRef() {
        return eventRef;
    }

    public void setEventRef(String eventRef) {
        this.eventRef = eventRef;
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

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }
}
