package com.cts.fasttack.mdes.client.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cts.fasttack.jms.dto.TokensDto;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Anton Leliuk
 */
@XmlRootElement(name = "TokenUpdateResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class TokenUpdateResponseDto {

    @XmlElement(name = "Tokens")
    @JsonProperty("Tokens")
    private TokensDto tokens;

    public TokensDto getTokens() {
        return tokens;
    }

    public void setTokens(TokensDto tokens) {
        this.tokens = tokens;
    }
}
