package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClient;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;

/**
 * Rest client for encryption data in database
 *
 * @author Dmitry Koval
 */
public interface DatabaseCryptoRestClient extends RestClient {

    CryptoResponseDto encrypt(String decrypted) throws ServiceException;

    CryptoResponseDto decrypt(String encrypted) throws ServiceException;
}
