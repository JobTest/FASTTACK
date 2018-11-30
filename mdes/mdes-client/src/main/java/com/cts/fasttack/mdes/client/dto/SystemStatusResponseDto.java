package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

/**
 * @author Anton Leliuk
 */
@XmlRootElement(name = "SystemStatusResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SystemStatusResponseDto {

    @XmlElement(name = "CommentText")
    @JsonProperty("CommentText")
    private String commentText;

    @XmlElement(name = "LastStatusDateTime")
    @JsonProperty("LastStatusDateTime")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Calendar lastStatusDateTime;

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Calendar getLastStatusDateTime() {
        return lastStatusDateTime;
    }

    public void setLastStatusDateTime(Calendar lastStatusDateTime) {
        this.lastStatusDateTime = lastStatusDateTime;
    }
}
