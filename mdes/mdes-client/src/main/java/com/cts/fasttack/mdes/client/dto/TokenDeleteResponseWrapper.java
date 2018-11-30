package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author a.lipavets
 */
public class TokenDeleteResponseWrapper extends AbstractTokenLifecycleResponseWrapper {

    @JsonProperty("TokenDeleteResponse")
    private TokenUnsuspendResponseDto responseDto;

    public TokenUnsuspendResponseDto getResponseDto() {
        return responseDto;
    }

    public void setResponseDto(TokenUnsuspendResponseDto responseDto) {
        this.responseDto = responseDto;
    }
}
