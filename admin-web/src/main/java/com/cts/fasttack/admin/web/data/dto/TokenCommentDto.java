package com.cts.fasttack.admin.web.data.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.cts.fasttack.common.core.util.CustomJsonDateDeserializer;
import com.cts.fasttack.common.core.util.CustomJsonDateSerializer;
import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Dmitry Koval
 */
public class TokenCommentDto extends IdentifierDto<Long> {

    private String tokenRefId;

    private String tokenRequestorId;

    private String eventRef;

    @JsonDeserialize(using = CustomJsonDateDeserializer.DateTime.class)
    @JsonSerialize(using = CustomJsonDateSerializer.DateTime.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date comData;

    private String comment;

    private String usrname;

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
}
