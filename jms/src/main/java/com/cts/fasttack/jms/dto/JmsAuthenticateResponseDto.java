package com.cts.fasttack.jms.dto;

public class JmsAuthenticateResponseDto {

    private Boolean isAuthenticated;

    public Boolean isIsAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(Boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
}
