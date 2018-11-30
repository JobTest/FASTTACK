package com.cts.fasttack.jms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dmitry Koval
 */
public class TokenSearchResponseWrapper {

    @JsonProperty("SearchResponse")
    private TokenSearchResponseDto responseDto;


    public TokenSearchResponseDto getResponseDto() {
        return responseDto;
    }

    public void setResponseDto(TokenSearchResponseDto responseDto) {
        this.responseDto = responseDto;
    }
}
