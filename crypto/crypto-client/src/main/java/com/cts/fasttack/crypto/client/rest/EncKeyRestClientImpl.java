package com.cts.fasttack.crypto.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.handler.ServiceExceptionHandler;
import com.cts.fasttack.common.core.util.ObjectUtil;
import com.cts.fasttack.crypto.client.conf.CryptoClientConfigurationProperties;
import com.cts.fasttack.crypto.client.dto.EncKeyListFilterDto;
import com.cts.fasttack.crypto.client.dto.EncKeyRequestResponseDto;

/**
 * @author Dmitry Koval
 */
@Component
@ConditionalOnProperty(prefix = "spring.crypto.server", value = "address")
public class EncKeyRestClientImpl extends AbstractCryptoRestClientImpl implements EncKeyRestClient {


    @Autowired
    public EncKeyRestClientImpl(@Qualifier("cryptoServerRestTemplate") RestTemplate restTemplate, CryptoClientConfigurationProperties properties) {
        super(restTemplate, properties.getAddress());
    }


    @Override
    public EncKeyRequestResponseDto get(Long id) throws ServiceException {
        return get("/secured/crypto/enckey/" + id, null, EncKeyRequestResponseDto.class);
    }

    @Override
    public EncKeyRequestResponseDto createNew(EncKeyRequestResponseDto requestDto) throws ServiceException {
        return post("/secured/crypto/enckey/", requestDto, EncKeyRequestResponseDto.class);
    }

    @Override
    public EncKeyRequestResponseDto update(EncKeyRequestResponseDto requestDto) throws ServiceException {
        return put("/secured/crypto/enckey/", requestDto, EncKeyRequestResponseDto.class, ServiceExceptionHandler.INSTANCE);
    }

    @Override
    public void delete(Long id) throws ServiceException {
        super.delete("/secured/crypto/enckey/" + id, null, ServiceExceptionHandler.INSTANCE);
    }

    @Override
    public QueryResultDto<EncKeyRequestResponseDto> listPaged(EncKeyListFilterDto filterDto) throws ServiceException {
        return ObjectUtil.uncheckedCast(post("/secured/crypto/enckey/list", filterDto, QueryResultDto.class));
    }
}
