package com.cts.fasttack.jms.dto;

/**
 * @author Dmitry Koval
 */
public class JmsVisaEncryptedDataDto {

    private JmsCardholderInfoDto cardholderInfo;

    private JmsTokenInfoDto tokenInfo;

    public JmsCardholderInfoDto getCardholderInfo() {
        return cardholderInfo;
    }

    public void setCardholderInfo(JmsCardholderInfoDto cardholderInfo) {
        this.cardholderInfo = cardholderInfo;
    }

    public JmsTokenInfoDto getTokenInfo() {
        return tokenInfo;
    }

    public void setTokenInfo(JmsTokenInfoDto tokenInfo) {
        this.tokenInfo = tokenInfo;
    }
}
