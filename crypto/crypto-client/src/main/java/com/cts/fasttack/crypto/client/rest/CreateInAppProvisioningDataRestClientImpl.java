package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;
import com.cts.fasttack.crypto.client.conf.CryptoClientConfigurationProperties;
import com.cts.fasttack.crypto.client.dto.CreateInAppProvisioningDataCryptoRequest;
import com.cts.fasttack.crypto.client.dto.CreateInAppProvisioningDataCryptoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author d.ishchenko
 */
@Component
@ConditionalOnProperty(prefix = "spring.crypto.server", value = "address")
public class CreateInAppProvisioningDataRestClientImpl extends RestClientImpl implements CreateInAppProvisioningDataRestClient {

    @Autowired
    public CreateInAppProvisioningDataRestClientImpl(@Qualifier("cryptoServerRestTemplate") RestTemplate restTemplate, CryptoClientConfigurationProperties properties) {
        super(restTemplate, properties.getAddress());
    }

    @Override
    public CreateInAppProvisioningDataCryptoResponse createInAppProvisioningData(CreateInAppProvisioningDataCryptoRequest request) throws ServiceException {
        return post("/secured/crypto/bank/createInAppProvisioningData", request, CreateInAppProvisioningDataCryptoResponse.class);
    }
}
