package com.cts.fasttack.ih.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClient;
import com.cts.fasttack.ih.client.dto.ECommerceConnect;

/**
 * @author Anton Leliuk
 */
public interface IssuerHostRestClient extends RestClient {

    ECommerceConnect accountStatusVerification(ECommerceConnect request) throws ServiceException;
}
