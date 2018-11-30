package com.cts.fasttack.mdes.server.dto;

/**
 * The fingerprint of the public key used to encrypt the ephemeral AES key
 *
 * @author Dmitry Koval
 */
public class EncryptedPayload {

    /**
     * The fingerprint of the public key used to encrypt the ephemeral AES key
     */
    private String publicKeyFingerprint;


    /**
     * One-time use AES key encrypted by the MasterCard public key (as identified by 'publicKeyFingerprint')
     * using the OAEP or RSA Encryption Standard PKCS 1 v1.5 (depending on the value of 'oaepHashingAlgorithm')
     */
    private String encryptedKey;

    /**
     * Hashing algorithm used with the OAEP scheme
     */
    private String oaepHashingAlgorithm;

    /**
     * The initialization vector used when encrypting data using the one-time use AES key
     */
    private String iv;

    /**
     * Contains an encrypted JSON object
     */
    private String encryptedData;

    public String getPublicKeyFingerprint() {
        return publicKeyFingerprint;
    }

    public void setPublicKeyFingerprint(String publicKeyFingerprint) {
        this.publicKeyFingerprint = publicKeyFingerprint;
    }

    public String getEncryptedKey() {
        return encryptedKey;
    }

    public void setEncryptedKey(String encryptedKey) {
        this.encryptedKey = encryptedKey;
    }

    public String getOaepHashingAlgorithm() {
        return oaepHashingAlgorithm;
    }

    public void setOaepHashingAlgorithm(String oaepHashingAlgorithm) {
        this.oaepHashingAlgorithm = oaepHashingAlgorithm;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }
}
