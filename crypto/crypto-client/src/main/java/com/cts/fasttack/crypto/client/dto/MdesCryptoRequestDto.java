package com.cts.fasttack.crypto.client.dto;

/**
 * @author a.lipavets
 */
public class MdesCryptoRequestDto implements CryptoRequest {
    private String encryptedData;
    private String publicKeyFingerprint;
    private String oaepAlgorithm;
    private String encryptedKey;
    private String iv;

    public MdesCryptoRequestDto() {
    }

    public MdesCryptoRequestDto(String encryptedData, String publicKeyFingerprint, String oaepAlgorithm, String encryptedKey, String iv) {
        this.encryptedData = encryptedData;
        this.publicKeyFingerprint = publicKeyFingerprint;
        this.oaepAlgorithm = oaepAlgorithm;
        this.encryptedKey = encryptedKey;
        this.iv = iv;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getPublicKeyFingerprint() {
        return publicKeyFingerprint;
    }

    public void setPublicKeyFingerprint(String publicKeyFingerprint) {
        this.publicKeyFingerprint = publicKeyFingerprint;
    }

    public String getOaepAlgorithm() {
        return oaepAlgorithm;
    }

    public void setOaepAlgorithm(String oaepAlgorithm) {
        this.oaepAlgorithm = oaepAlgorithm;
    }

    public String getEncryptedKey() {
        return encryptedKey;
    }

    public void setEncryptedKey(String encryptedKey) {
        this.encryptedKey = encryptedKey;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }
}

