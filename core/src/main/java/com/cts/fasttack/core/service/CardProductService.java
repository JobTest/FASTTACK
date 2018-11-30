package com.cts.fasttack.core.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.core.data.CardProduct;
import com.cts.fasttack.core.data.list.CardProductListFilter;
import com.cts.fasttack.core.dto.CardProductDto;

public interface CardProductService extends GenericService<Long, CardProductDto, CardProduct> {

    QueryResult<CardProductDto> listCardProducts(CardProductListFilter filter);

    void saveOrUpdate(CardProductDto cardProductDto) throws ServiceException;

}
