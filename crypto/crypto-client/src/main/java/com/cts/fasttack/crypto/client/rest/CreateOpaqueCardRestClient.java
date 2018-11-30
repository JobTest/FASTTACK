package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClient;
import com.cts.fasttack.crypto.client.dto.CreateOpaqueCardCryptoRequest;
import com.cts.fasttack.crypto.client.dto.CreateOpaqueCardCryptoResponse;

/**
 * @author Anton Leliuk
 */
public interface CreateOpaqueCardRestClient extends RestClient {

    /**
     * Create opaque card body for Mastercard
     * @param request request to encryption
     * @return {@link String} opaque body
     */
    CreateOpaqueCardCryptoResponse createOpaqueBody(CreateOpaqueCardCryptoRequest request) throws ServiceException;
}
