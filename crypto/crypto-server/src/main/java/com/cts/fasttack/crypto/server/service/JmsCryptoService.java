package com.cts.fasttack.crypto.server.service;

import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * Service for support encryption before sending to JMS
 * @author Anton Leliuk
 */
public interface JmsCryptoService {

    /**
     * Encrypt decrypted before sending to JMS
     * @param decrypted original object
     * @return encrypted text
     */
    String encrypt(String decrypted) throws ServiceException;

    /**
     * Decrypt string after receiving JMS message
     */
    String decrypt(String encrypted) throws ServiceException;
}
