package com.cts.fasttack.jms.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dmitry Koval
 */
public class TokenSearchAccountTokensDto {

    @JsonProperty("Token")
    private List<TokenSearchAccountTokenDto> tokens;

    public List<TokenSearchAccountTokenDto> getTokens() {
        return tokens;
    }

    public void setTokens(List<TokenSearchAccountTokenDto> tokens) {
        this.tokens = tokens;
    }
}
