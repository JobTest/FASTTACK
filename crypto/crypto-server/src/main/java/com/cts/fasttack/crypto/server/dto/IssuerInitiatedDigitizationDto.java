package com.cts.fasttack.crypto.server.dto;

/**
 * @author Anton Leliuk
 */
public class IssuerInitiatedDigitizationDto {

    private CryptoCardInfo cardInfo;
    private String tokenizationAuthenticationValue;

    public CryptoCardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CryptoCardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public String getTokenizationAuthenticationValue() {
        return tokenizationAuthenticationValue;
    }

    public void setTokenizationAuthenticationValue(String tokenizationAuthenticationValue) {
        this.tokenizationAuthenticationValue = tokenizationAuthenticationValue;
    }
}
