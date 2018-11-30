package com.cts.fasttack.crypto.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dto.EncKeyListFilterDto;
import com.cts.fasttack.crypto.client.dto.EncKeyRequestResponseDto;
import com.cts.fasttack.common.core.dto.QueryResultDto;

/**
 * @author Dmitry Koval
 */
public interface EncKeyRestClient {

    EncKeyRequestResponseDto get(Long id) throws ServiceException;

    EncKeyRequestResponseDto createNew(EncKeyRequestResponseDto requestDto) throws ServiceException;

    EncKeyRequestResponseDto update(EncKeyRequestResponseDto requestDto) throws ServiceException;

    void delete(Long id) throws ServiceException;

    QueryResultDto<EncKeyRequestResponseDto> listPaged(EncKeyListFilterDto filterDto) throws ServiceException;
}
