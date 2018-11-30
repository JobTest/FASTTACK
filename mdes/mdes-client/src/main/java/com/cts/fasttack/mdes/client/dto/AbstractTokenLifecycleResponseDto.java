package com.cts.fasttack.mdes.client.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.cts.fasttack.jms.dto.TokenLifecycleResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Anton Leliuk
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractTokenLifecycleResponseDto {

    @XmlElement(name = "Token")
    @JsonProperty("Token")
    private TokenLifecycleResponseDto token;

    public TokenLifecycleResponseDto getToken() {
        return token;
    }

    public void setToken(TokenLifecycleResponseDto token) {
        this.token = token;
    }
}
