package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;
import com.cts.fasttack.crypto.client.dto.CryptoRequest;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import org.springframework.web.client.RestTemplate;

/**
 * @author Anton Leliuk
 */
public abstract class AbstractCryptoRestClientImpl extends RestClientImpl {

    public AbstractCryptoRestClientImpl(RestTemplate restTemplate, String address) {
        super(restTemplate, address);
    }

    CryptoResponseDto post(final String path, final CryptoRequest request, final Class<CryptoResponseDto> responseType) throws ServiceException {
        return throwExceptionIfNeeded(super.post(path, request, responseType));
    }

    CryptoResponseDto originalPost(final String path, final CryptoRequest request, final Class<CryptoResponseDto> responseType) throws ServiceException {
        return super.post(path, request, responseType);
    }

    private CryptoResponseDto throwExceptionIfNeeded(CryptoResponseDto response) throws ServiceException {
        if(response.getErrorCode() != null){
            throw new ServiceException(response.getErrorCode());
        }
        return response;
    }
}
