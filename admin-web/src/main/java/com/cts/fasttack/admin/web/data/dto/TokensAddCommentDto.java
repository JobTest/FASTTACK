package com.cts.fasttack.admin.web.data.dto;

import java.util.List;

/**
 * @author Dmitry Koval
 */
public class TokensAddCommentDto {

    private List<TokenInfoId> tokens;

    private String comment;

    public List<TokenInfoId> getTokens() {
        return tokens;
    }

    public void setTokens(List<TokenInfoId> tokens) {
        this.tokens = tokens;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
