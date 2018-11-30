package com.cts.fasttack.crypto.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.crypto.client.conf.CryptoClientConfigurationProperties;
import com.cts.fasttack.crypto.client.dto.CryptoRequestDto;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import com.cts.fasttack.crypto.client.dto.DecryptWithTripleDESCryptoRequestDto;
import com.cts.fasttack.crypto.client.dto.EncryptWithTripleDESCryptoResponseDto;
import com.cts.fasttack.crypto.client.dto.VisaCryptoResponseDto;

/**
 * @author Dmitry Koval
 */
@Component
@ConditionalOnProperty(prefix = "spring.crypto.server", value = "address")
public class VisaCryptoRestClientImpl extends AbstractCryptoRestClientImpl implements VisaCryptoRestClient {

    @Autowired
    public VisaCryptoRestClientImpl(@Qualifier("cryptoServerRestTemplate") RestTemplate restTemplate, CryptoClientConfigurationProperties properties) {
        super(restTemplate, properties.getAddress());
    }


    @Override
    public CryptoResponseDto decrypt(String encrypted) throws ServiceException {
    	CryptoResponseDto cryptoResponseDto =  originalPost("/secured/crypto/visa/decrypt", new CryptoRequestDto(encrypted), CryptoResponseDto.class);

        if (StandardErrorCodes.CRYPTOGRAPHY_ERROR.equals(cryptoResponseDto.getErrorCode())) {
        	throw new ServiceException(cryptoResponseDto.getErrorCode());
        }
        if (StandardErrorCodes.INVALID_FIELD_VALUE.equals(cryptoResponseDto.getErrorCode())) {
        	throw new ServiceException(cryptoResponseDto.getErrorCode(), "kid in JWE Header");
        }
        if (cryptoResponseDto.getErrorCode() != null) {
        	throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
        }

        return cryptoResponseDto;
    }

    @Override
    public VisaCryptoResponseDto decryptWith3desAlgorithm(String encryptedData, String encryptionKeyIndex) throws ServiceException {
        DecryptWithTripleDESCryptoRequestDto decryptWithTripleDESCryptoRequestDto = new DecryptWithTripleDESCryptoRequestDto();
        decryptWithTripleDESCryptoRequestDto.setEncryptedData(encryptedData);
        decryptWithTripleDESCryptoRequestDto.setEncryptionKeyIndex(encryptionKeyIndex);

        return post("/secured/crypto/visa/decryptWith3desAlgorithm", decryptWithTripleDESCryptoRequestDto, VisaCryptoResponseDto.class);
    }

    @Override
    public EncryptWithTripleDESCryptoResponseDto encryptWith3desAlgorithm(String data) throws ServiceException {
        return post("/secured/crypto/visa/encryptWith3desAlgorithm", new CryptoRequestDto(data), EncryptWithTripleDESCryptoResponseDto.class);
    }
}
