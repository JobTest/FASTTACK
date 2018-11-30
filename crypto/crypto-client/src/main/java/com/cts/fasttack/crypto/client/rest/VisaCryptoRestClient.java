package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import com.cts.fasttack.crypto.client.dto.EncryptWithTripleDESCryptoResponseDto;
import com.cts.fasttack.crypto.client.dto.VisaCryptoResponseDto;

/**
 * @author Dmitry Koval
 */
public interface VisaCryptoRestClient {
    CryptoResponseDto decrypt(String encrypted) throws ServiceException;

    VisaCryptoResponseDto decryptWith3desAlgorithm(String encryptedData, String encryptionKeyIndex) throws ServiceException;

    EncryptWithTripleDESCryptoResponseDto encryptWith3desAlgorithm(String data) throws ServiceException;

}
