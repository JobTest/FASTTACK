package com.cts.fasttack.admin.web.data.dto;

import java.util.List;

/**
 * @author Dmitry Koval
 */
public class TokensInfoListDto {

    private List<TokenInfoListDto> tokens;

    public TokensInfoListDto(List<TokenInfoListDto> tokens) {
        this.tokens = tokens;
    }

    public List<TokenInfoListDto> getTokens() {
        return tokens;
    }

    public void setTokens(List<TokenInfoListDto> tokens) {
        this.tokens = tokens;
    }
}
