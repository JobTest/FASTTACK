package com.cts.fasttack.crypto.client.dto;

/**
 * @author Anton Leliuk
 */
public class CreateOpaqueCardCryptoRequest implements CryptoRequest {

    private String publicKeyFingerprint;

    private String tavKeyFingerprint;

    private String oaepHashingAlgorithm;

    private String accountNumber;

    private String expiryMonth;

    private String expiryYear;

    private String cardholderName;

    public String getPublicKeyFingerprint() {
        return publicKeyFingerprint;
    }

    public void setPublicKeyFingerprint(String publicKeyFingerprint) {
        this.publicKeyFingerprint = publicKeyFingerprint;
    }

    public String getTavKeyFingerprint() {
        return tavKeyFingerprint;
    }

    public void setTavKeyFingerprint(String tavKeyFingerprint) {
        this.tavKeyFingerprint = tavKeyFingerprint;
    }

    public String getOaepHashingAlgorithm() {
        return oaepHashingAlgorithm;
    }

    public void setOaepHashingAlgorithm(String oaepHashingAlgorithm) {
        this.oaepHashingAlgorithm = oaepHashingAlgorithm;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }
}
