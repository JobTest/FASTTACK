package com.cts.fasttack.crypto.server.service;

/**
 * @author a.lipavets
 */
public interface MdesCryptoService extends CryptoService {

    /**
     * Decryp encryptedData with MDES_CUSTOMER_PRIV
     */
    String decryptWithMdesCustomerPriv(String encryptedData, String encryptedKey, String publicKeyFingerprint, String oaepAlgorithm, String iv);

}
