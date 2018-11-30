package com.cts.fasttack.bank.server.pushprovisioning.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Response DTO for getting token by wallet id.
 *
 * @author v.semerkov
 */
@JacksonXmlRootElement(localName = "GetTokenByWalletIdResponse")
@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "GetTokenByWalletIdResponse")
@JsonRootName("GetTokenByWalletIdResponse")
public class GetTokenByWalletIdResponseDto {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CardAndTokenResponseDto> cardAndToken;

    public List<CardAndTokenResponseDto> getCardAndToken() {
        return cardAndToken;
    }

    public void setCardAndToken(List<CardAndTokenResponseDto> cardAndToken) {
        this.cardAndToken = cardAndToken;
    }
}
