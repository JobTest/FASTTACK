package com.cts.fasttack.jms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Dmitry Koval
 */
@JsonRootName("SearchResponse")
public class TokenSearchResponseDto {

    @JsonProperty("Accounts")
    private TokenSearchAccountsDto account;

    public TokenSearchAccountsDto getAccount() {
        return account;
    }

    public void setAccount(TokenSearchAccountsDto account) {
        this.account = account;
    }
}
