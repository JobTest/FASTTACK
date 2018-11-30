package com.cts.fasttack.mdes.server.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;

/**
 * Contains card and token information of the card to be digitized
 *
 * @author a.lipavets
 */
public class CardInfo {

    /**
     * Contains the encrypted CardAndTokenData object
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 256000,message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String encryptedData;

    /**
     * The fingerprint of the public key used to encrypt the ephemeral AES key
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 64,message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String publicKeyFingerprint;

    /**
     * One-time use AES key encrypted by the Issuer's public key
     * (as identified by 'publicKeyFingerprint') using the OAEP scheme
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 512,message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String encryptedKey;

    /**
     * Hashing algorithm used with the OAEP scheme. If omitted, then the RSA Encryption standard PKCS 1 v1.5 will be used.
     * You must use one of the following algorithms; SHA256 - Use the SHA256 algorithm | SHA512 - Use the SHA-512 algorithm
     */
    @Size(max = 6,message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String oaepHashingAlgorithm;

    /**
     *  Hashing algorithm used with the OAEP scheme. If omitted, then the RSA Encryption standard PKCS 1 v1.5 will be used.
     *  You must use one of the following algorithms; SHA256 - Use the SHA256 algorithm | SHA512 - Use the SHA-512 algorithm
     */
    @Size(max = 32,message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String iv;

    /**
     * Reference to the PAN that is unique per Wallet Provider
     */
    @Size(max = 64,message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String panUniqueReference;

    /** getters and setters */
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

    public String getPanUniqueReference() {
        return panUniqueReference;
    }

    public void setPanUniqueReference(String panUniqueReference) {
        this.panUniqueReference = panUniqueReference;
    }
}
