package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Anton Leliuk
 */
public class MdesErrorDetailsDto {

    @JsonProperty("Detail")
    private List<MdesErrorDetailDto> details;

    public List<MdesErrorDetailDto> getDetails() {
        return details;
    }

    public void setDetails(List<MdesErrorDetailDto> details) {
        this.details = details;
    }
}
