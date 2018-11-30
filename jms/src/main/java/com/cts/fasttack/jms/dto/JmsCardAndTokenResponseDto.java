package com.cts.fasttack.jms.dto;

/**
 * Response DTO for getting card and token info.
 *
 * @author v.semerkov
 */
public class JmsCardAndTokenResponseDto {

    private String cardId;

    private String cardGUID;

    private String tokenReferenceId;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardGUID() {
        return cardGUID;
    }

    public void setCardGUID(String cardGUID) {
        this.cardGUID = cardGUID;
    }

    public String getTokenReferenceId() {
        return tokenReferenceId;
    }

    public void setTokenReferenceId(String tokenReferenceId) {
        this.tokenReferenceId = tokenReferenceId;
    }
}
