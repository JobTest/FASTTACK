package com.cts.fasttack.admin.web.rest;

import com.cts.fasttack.admin.web.data.dto.CardProductDto;
import com.cts.fasttack.admin.web.data.list.CardProductListFilter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.service.ExistCheckService;

public interface CardProductRestClient extends ExistCheckService<String> {

    /**
     * Get query result of CardProduct by filter
     */
    QueryResultDto<CardProductDto> filterCardProduct(CardProductListFilter filter) throws ServiceException;

    /**
     * Get CardProduct by name
     */
    CardProductDto getCardProduct(String propName) throws ServiceException;

    /**
     * Create CardProduct
     */
    void createCardProduct(CardProductDto cardProduct) throws ServiceException;

    /**
     * Update CardProduct
     */
    void updateCardProduct(CardProductDto cardProduct) throws ServiceException;

    /**
     * Delete CardProduct
     */
    void deleteCardProduct(String propName) throws ServiceException;

}
