package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Anton Leliuk
 */
public class TokenUnsuspendResponseWrapper extends AbstractTokenLifecycleResponseWrapper {

    @JsonProperty("TokenUnsuspendResponse")
    private TokenUnsuspendResponseDto responseDto;

    public TokenUnsuspendResponseDto getResponseDto() {
        return responseDto;
    }

    public void setResponseDto(TokenUnsuspendResponseDto responseDto) {
        this.responseDto = responseDto;
    }
}
