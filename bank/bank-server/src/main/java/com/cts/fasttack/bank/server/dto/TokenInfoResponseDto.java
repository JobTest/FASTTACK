package com.cts.fasttack.bank.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Token info response DTO.
 *
 * @author v.semerkov
 */
@JacksonXmlRootElement(localName = "TokenInfoResponse")
@XmlRootElement(name = "TokenInfoResponse")
public class TokenInfoResponseDto extends LifecycleTokenResponseDto {

    /**
     * Token list
     */
    @JsonProperty
    @JacksonXmlElementWrapper(localName = "tokens")
    @JacksonXmlProperty(localName = "token")
    private List<TokenResponseDto> tokens;

    public List<TokenResponseDto> getTokens() {
        return tokens;
    }

    public void setTokens(List<TokenResponseDto> tokens) {
        this.tokens = tokens;
    }
}
