package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.conf.CryptoClientConfigurationProperties;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import com.cts.fasttack.crypto.client.dto.MdesCryptoRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author a.lipavets
 */
@Component
@ConditionalOnProperty(prefix = "spring.crypto.server", value = "address")
public class MdesCryptoRestClientImpl extends AbstractCryptoRestClientImpl implements MdesCryptoRestClient{

    @Autowired
    public MdesCryptoRestClientImpl(@Qualifier("cryptoServerRestTemplate") RestTemplate restTemplate, CryptoClientConfigurationProperties properties) {
        super(restTemplate, properties.getAddress());
    }

    @Override
    public CryptoResponseDto decryptWithMdesCustomerPriv(String encryptedData, String publicKeyFingerprint, String oaepHashAlgorithm, String encryptedKey, String iv) throws ServiceException {
        return post("/secured/crypto/mdes/decryptCardAndTokenData", new MdesCryptoRequestDto(encryptedData, publicKeyFingerprint, oaepHashAlgorithm, encryptedKey, iv), CryptoResponseDto.class);
    }
}
