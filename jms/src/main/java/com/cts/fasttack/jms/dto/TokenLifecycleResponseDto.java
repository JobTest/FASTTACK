package com.cts.fasttack.jms.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dmitry Koval
 */
@XmlRootElement(name = "Token")
@XmlAccessorType(XmlAccessType.FIELD)
public class TokenLifecycleResponseDto {

    @JsonProperty("TokenUniqueReference")
    @XmlElement(name = "TokenUniqueReference")
    private String tokenUniqueReference;

    @JsonProperty("CommentId")
    @XmlElement(name = "CommentId")
    private String commentId;

    public String getTokenUniqueReference() {
        return tokenUniqueReference;
    }

    public void setTokenUniqueReference(String tokenUniqueReference) {
        this.tokenUniqueReference = tokenUniqueReference;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
}
