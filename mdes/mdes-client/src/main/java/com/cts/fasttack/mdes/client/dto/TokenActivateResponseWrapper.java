package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Anton Leliuk
 */
public class TokenActivateResponseWrapper extends AbstractTokenLifecycleResponseWrapper {

    @JsonProperty("TokenActivateResponse")
    private TokenActivateResponseDto responseDto;

    public TokenActivateResponseDto getResponseDto() {
        return responseDto;
    }

    public void setResponseDto(TokenActivateResponseDto responseDto) {
        this.responseDto = responseDto;
    }
}
