package com.cts.fasttack.visa.vtis.server.dto;

/**
 * @author Dmitry Koval
 */
public class VisaEncryptedData {
    private TokenNotificationCardHolderInfoDto cardholderInfo;

    private TokenInfoDto tokenInfo;

    public TokenNotificationCardHolderInfoDto getCardholderInfo() {
        return cardholderInfo;
    }

    public void setCardholderInfo(TokenNotificationCardHolderInfoDto cardholderInfo) {
        this.cardholderInfo = cardholderInfo;
    }

    public TokenInfoDto getTokenInfo() {
        return tokenInfo;
    }

    public void setTokenInfo(TokenInfoDto tokenInfo) {
        this.tokenInfo = tokenInfo;
    }
}
