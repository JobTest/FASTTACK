package com.cts.fasttack.core.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Dmitry Koval
 */
public class TokenCommentDto {

    private Long id;

    private String tokenRefId;

    private String tokenRequestorId;

    private String eventRef;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date comData;

    private String comment;

    private String usrname;

    public Long getId() {
        return id;
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

    public String getEventRef() {
        return eventRef;
    }

    public void setEventRef(String eventRef) {
        this.eventRef = eventRef;
    }

    public Date getComData() {
        return comData;
    }

    public void setComData(Date comData) {
        this.comData = comData;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }
}
