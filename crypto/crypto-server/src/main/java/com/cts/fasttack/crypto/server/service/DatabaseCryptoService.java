package com.cts.fasttack.crypto.server.service;

import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * Service for support encryption sensitive data in database
 *
 * @author Dmitry Koval
 */
public interface DatabaseCryptoService {

    /**
     * Encrypt decrypted content JMS message
     * @param decrypted original object
     * @return encrypted text
     */
    String encrypt(String decrypted) throws ServiceException;

    /**
     * Decrypt string content JMS message
     */
    String decrypt(String encrypted) throws ServiceException;
}
