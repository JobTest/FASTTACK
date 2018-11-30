package com.cts.fasttack.core.dto;

/**
 * Containing the Account PAN, card and token information
 *
 * @author a.lipavets
 */
public class CardAndTokenDataDto {

    /**
     * The account PAN information
     */
    private CardDto card;

    /**
     * The Token information
     */
    private TokenDto token;

    /**
     * The unique account reference assigned to the PAN
     */
    private String paymentAccountReference;

    /* getters and setters */
    public CardDto getCard() {
        return card;
    }

    public void setCard(CardDto card) {
        this.card = card;
    }

    public TokenDto getToken() {
        return token;
    }

    public void setToken(TokenDto token) {
        this.token = token;
    }

    public String getPaymentAccountReference() {
        return paymentAccountReference;
    }

    public void setPaymentAccountReference(String paymentAccountReference) {
        this.paymentAccountReference = paymentAccountReference;
    }
}
