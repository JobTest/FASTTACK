package com.cts.fasttack.jms.dto;

/**
 * @author Dmitry Koval
 */
public class JmsTokenInfoEventRefDto {

    private String tokenRefId;

    private String tokenRequestorId;

    private String eventRef;

    public JmsTokenInfoEventRefDto(){
    }

    public JmsTokenInfoEventRefDto(String tokenRefId, String tokenRequestorId, String eventRef) {
        this.tokenRefId = tokenRefId;
        this.tokenRequestorId = tokenRequestorId;
        this.eventRef = eventRef;
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

    public String getEventRef() {
        return eventRef;
    }

    public void setEventRef(String eventRef) {
        this.eventRef = eventRef;
    }
}
