package com.cts.fasttack.admin.web.data.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Dmitry Koval
 */
public class TokenAddCommentDto {

    @NotEmpty
    private String tokenRefId;

    @NotEmpty
    private String tokenRequestorId;

    @NotEmpty
    @Size(max = 256)
    private String comment;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
