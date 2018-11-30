package com.cts.fasttack.crypto.server.service;

import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * Service for encryption of sensitive data sent to Smartvista (AVS1)
 * @author d.ishchenko
 */
public interface SmartvistaCryptoService {

    /**
     * Encrypt clear sensitive data before sending to Smartvista
     * @param clearText clear text
     * @param hexIv CBC mode Initialization Vector hexadecimal value
     * @param keyIndex index (reference code) of the key to be used for encryption
     * @return encrypted text
     */
    String encrypt(String clearText, String hexIv, String keyIndex) throws ServiceException;

}
