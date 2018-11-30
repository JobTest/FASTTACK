package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Anton Leliuk
 */
public class TokenSuspendResponseWrapper extends AbstractTokenLifecycleResponseWrapper {

    @JsonProperty("TokenSuspendResponse")
    private TokenSuspendResponseDto responseDto;

    public TokenSuspendResponseDto getResponseDto() {
        return responseDto;
    }

    public void setResponseDto(TokenSuspendResponseDto responseDto) {
        this.responseDto = responseDto;
    }
}
