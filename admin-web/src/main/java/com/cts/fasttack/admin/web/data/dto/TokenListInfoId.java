package com.cts.fasttack.admin.web.data.dto;

import java.util.List;
import javax.validation.constraints.Size;

/**
 * @author Dmitry Koval
 */
public class TokenListInfoId {

    @Size(min = 1, message = "{token.list.empty}")
    private List<TokenInfoId> tokens;

    public List<TokenInfoId> getTokens() {
        return tokens;
    }

    public void setTokens(List<TokenInfoId> tokens) {
        this.tokens = tokens;
    }
}
