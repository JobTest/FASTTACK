package com.cts.fasttack.crypto.server.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dto.TripleDESEncryptionResultDto;

/**
 * @author Dmitry Koval
 */
public interface VisaCryptoService {

    /**
     * Decrypt data from VISA where contain CardholderInfo and TokenInfo
     *
     * @param encryptData
     * @return
     */
    String decrypt(String encryptData);

    String decryptWith3desAlgorithm(String encryptedData, String encryptionKeyIndex) throws ServiceException;

    TripleDESEncryptionResultDto encryptWith3desAlgorithm(String data) throws ServiceException;

}
