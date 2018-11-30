package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.conf.CryptoClientConfigurationProperties;
import com.cts.fasttack.crypto.client.dto.CryptoRequestDto;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dmitry Koval
 */
@Component
@ConditionalOnProperty(prefix = "spring.crypto.server", value = "address")
public class DatabaseCryptoRestClientImpl extends AbstractCryptoRestClientImpl implements DatabaseCryptoRestClient {

    @Autowired
    public DatabaseCryptoRestClientImpl(@Qualifier("cryptoServerRestTemplate") RestTemplate restTemplate, CryptoClientConfigurationProperties properties) {
        super(restTemplate, properties.getAddress());
    }

    @Override
    public CryptoResponseDto encrypt(String decrypted) throws ServiceException {
        return post("/secured/crypto/database/encrypt", new CryptoRequestDto(decrypted), CryptoResponseDto.class);
    }

    @Override
    public CryptoResponseDto decrypt(String encrypted) throws ServiceException {
        return post("/secured/crypto/database/decrypt", new CryptoRequestDto(encrypted), CryptoResponseDto.class);
    }
}
