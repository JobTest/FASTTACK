package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Anton Leliuk
 */
public class TokenUpdateResponseWrapper {

    @JsonProperty("TokenUpdateResponse")
    private TokenUpdateResponseDto responseDto;

    public TokenUpdateResponseDto getResponseDto() {
        return responseDto;
    }

    public void setResponseDto(TokenUpdateResponseDto responseDto) {
        this.responseDto = responseDto;
    }
}
