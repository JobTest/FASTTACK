package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;
import com.cts.fasttack.crypto.client.conf.CryptoClientConfigurationProperties;
import com.cts.fasttack.crypto.client.dto.CreateOpaqueCardCryptoRequest;
import com.cts.fasttack.crypto.client.dto.CreateOpaqueCardCryptoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Anton Leliuk
 */
@Component
@ConditionalOnProperty(prefix = "spring.crypto.server", value = "address")
public class CreateOpaqueCardRestClientImpl extends RestClientImpl implements CreateOpaqueCardRestClient {

    @Autowired
    public CreateOpaqueCardRestClientImpl(@Qualifier("cryptoServerRestTemplate") RestTemplate restTemplate, CryptoClientConfigurationProperties properties) {
        super(restTemplate, properties.getAddress());
    }

    @Override
    public CreateOpaqueCardCryptoResponse createOpaqueBody(CreateOpaqueCardCryptoRequest request) throws ServiceException {
        return post("/secured/crypto/bank/createOpaqueCard", request, CreateOpaqueCardCryptoResponse.class);
    }
}
