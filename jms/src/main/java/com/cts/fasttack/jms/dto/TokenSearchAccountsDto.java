package com.cts.fasttack.jms.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dmitry Koval
 */
public class TokenSearchAccountsDto {

    @JsonProperty("Account")
    private List<TokenSearchAccountDto> accounts;

    public List<TokenSearchAccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<TokenSearchAccountDto> accounts) {
        this.accounts = accounts;
    }
}
