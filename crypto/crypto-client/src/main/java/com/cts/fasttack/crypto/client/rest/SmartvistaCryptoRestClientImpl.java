package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.conf.CryptoClientConfigurationProperties;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import com.cts.fasttack.crypto.client.dto.TextWithIvAndKeyIndexCryptoRequestDto;

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
public class SmartvistaCryptoRestClientImpl extends AbstractCryptoRestClientImpl implements SmartvistaCryptoRestClient {

    @Autowired
    public SmartvistaCryptoRestClientImpl(@Qualifier("cryptoServerRestTemplate") RestTemplate restTemplate, CryptoClientConfigurationProperties properties) {
        super(restTemplate, properties.getAddress());
    }

    @Override
    public CryptoResponseDto encrypt(String clearText, String hexIv, String keyIndex) throws ServiceException {
        return post("/secured/crypto/smartvista/encrypt", new TextWithIvAndKeyIndexCryptoRequestDto(clearText, hexIv, keyIndex), CryptoResponseDto.class);
    }

}
