package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClient;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;

/**
 * @author Anton Leliuk
 */
public interface JmsCryptoRestClient extends RestClient {

    CryptoResponseDto encrypt(String decrypted) throws ServiceException;

    CryptoResponseDto decrypt(String encrypted) throws ServiceException;
}
