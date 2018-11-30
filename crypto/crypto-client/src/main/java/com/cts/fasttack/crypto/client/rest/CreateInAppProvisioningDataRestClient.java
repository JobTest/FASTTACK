package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClient;
import com.cts.fasttack.crypto.client.dto.CreateInAppProvisioningDataCryptoRequest;
import com.cts.fasttack.crypto.client.dto.CreateInAppProvisioningDataCryptoResponse;

/**
 * @author d.ishchenko
 */
public interface CreateInAppProvisioningDataRestClient extends RestClient {

    /**
     * Create in-app provisioning data (Apple Pay)
     */
    CreateInAppProvisioningDataCryptoResponse createInAppProvisioningData(CreateInAppProvisioningDataCryptoRequest request) throws ServiceException;

}
