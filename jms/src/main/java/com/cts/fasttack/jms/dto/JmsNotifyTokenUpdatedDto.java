package com.cts.fasttack.jms.dto;

import java.util.Date;
import java.util.List;

/**
 * @author a.lipavets
 */
public class JmsNotifyTokenUpdatedDto {

    private String requestId;

    private String reasonCode;

    private List<JmsTokenDto> tokens;

    private String tokenEventType;

    private Date tokenEventDate;

    /* getters and setters */

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public List<JmsTokenDto> getTokens() {
        return tokens;
    }

    public void setTokens(List<JmsTokenDto> tokens) {
        this.tokens = tokens;
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
}
