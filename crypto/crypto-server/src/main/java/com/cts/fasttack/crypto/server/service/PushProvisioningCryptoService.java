package com.cts.fasttack.crypto.server.service;

import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * @author Anton Leliuk
 */
public interface PushProvisioningCryptoService {

    /**
     * Create opaque body
     * @param publicKeyFingerprint fingerprint of public key
     * @param tavKeyFingerprint  fingerprint of tav key
     * @param oaepHashingAlgorithm hashing algorithm
     * @param accountNumber card number
     * @param expiryMonth card expiry month
     * @param expiryYear card expiry year
     * @param cardholderName card holder name
     * @return {@link String} encrypted opaque body
     */
    String encryptOpaqueBody(String publicKeyFingerprint, String tavKeyFingerprint, String oaepHashingAlgorithm, String accountNumber, String expiryMonth, String expiryYear, String cardholderName) throws ServiceException;
}
