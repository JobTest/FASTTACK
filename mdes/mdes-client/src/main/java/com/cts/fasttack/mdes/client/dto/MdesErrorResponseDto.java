package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dmitry Koval
 */
public class MdesErrorResponseDto {

    @JsonProperty("Errors")
    private MdesErrorsDto error;

    public MdesErrorsDto getError() {
        return error;
    }

    public void setError(MdesErrorsDto error) {
        this.error = error;
    }
}
