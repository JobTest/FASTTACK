package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClient;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;

/**
 * @author d.ishchenko
 */
public interface SmartvistaCryptoRestClient extends RestClient {

    CryptoResponseDto encrypt(String clearText, String hexIv, String keyIndex) throws ServiceException;

}
