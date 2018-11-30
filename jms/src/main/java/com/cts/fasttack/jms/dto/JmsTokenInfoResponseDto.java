package com.cts.fasttack.jms.dto;

import java.util.List;

/**
 * Response DTO for getting token info from VISA and Mastercard.
 *
 * @author v.semerkov
 */
public class JmsTokenInfoResponseDto extends JmsVisaResponseDto {

    /**
     * Token list
     */
    private List<JmsTokenResponseDto> tokens;

    public List<JmsTokenResponseDto> getTokens() {
        return tokens;
    }

    public void setTokens(List<JmsTokenResponseDto> tokens) {
        this.tokens = tokens;
    }
}
