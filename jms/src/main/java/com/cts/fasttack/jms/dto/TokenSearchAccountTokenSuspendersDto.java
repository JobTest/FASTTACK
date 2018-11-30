package com.cts.fasttack.jms.dto;

import java.util.List;

/**
 * @author Dmitry Koval
 */
public class TokenSearchAccountTokenSuspendersDto {

    private List<String> suspenders;

    public List<String> getSuspenders() {
        return suspenders;
    }

    public void setSuspenders(List<String> suspenders) {
        this.suspenders = suspenders;
    }
}
