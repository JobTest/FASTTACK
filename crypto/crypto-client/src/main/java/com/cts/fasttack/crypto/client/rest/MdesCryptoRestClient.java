package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClient;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;

/**
 * @author a.lipavets
 */
public interface MdesCryptoRestClient extends RestClient{

    CryptoResponseDto decryptWithMdesCustomerPriv(String encryptedData, String publicKeyFingerprint, String oaepHashAlgorithm, String encryptedKey, String iv) throws ServiceException;
}
