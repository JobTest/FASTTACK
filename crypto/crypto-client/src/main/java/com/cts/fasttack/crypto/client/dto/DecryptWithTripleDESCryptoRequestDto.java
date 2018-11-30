package com.cts.fasttack.crypto.client.dto;

/**
 * Request DTO for Triple DES (3DES) symmetric-key algorithm.
 *
 * @author v.semerkov
 */
public class DecryptWithTripleDESCryptoRequestDto implements CryptoRequest {

    /**
     * Encrypted data
     */
    private String encryptedData;

    /**
     * Index of key for decryption
     */
    private String encryptionKeyIndex;

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getEncryptionKeyIndex() {
        return encryptionKeyIndex;
    }

    public void setEncryptionKeyIndex(String encryptionKeyIndex) {
        this.encryptionKeyIndex = encryptionKeyIndex;
    }
}
