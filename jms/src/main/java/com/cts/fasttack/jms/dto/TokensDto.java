package com.cts.fasttack.jms.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author a.lipavets
 */
public class TokensDto {
    @JsonProperty("Token")
    private List<TokenLifecycleResponseDto> token;

    public List<TokenLifecycleResponseDto> getToken() {
        return token;
    }

    public void setToken(List<TokenLifecycleResponseDto> token) {
        this.token = token;
    }
}
