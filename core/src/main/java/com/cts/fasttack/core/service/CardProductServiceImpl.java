package com.cts.fasttack.core.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.core.converter.CardProductDtoToDomainConverter;
import com.cts.fasttack.core.converter.CardProductToDtoConverter;
import com.cts.fasttack.core.dao.CardProductDao;
import com.cts.fasttack.core.data.CardProduct;
import com.cts.fasttack.core.data.list.CardProductListFilter;
import com.cts.fasttack.core.dto.CardProductDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cardProductService")
public class CardProductServiceImpl extends GenericServiceImpl<String, CardProductDto, CardProduct, CardProductDao> implements CardProductService {

    private Logger logger = LogManager.getLogger(CardProductServiceImpl.class);

    @Autowired
    public CardProductServiceImpl(CardProductDao dao, CardProductToDtoConverter domainToDtoConverter, CardProductDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResult<CardProductDto> listCardProducts(CardProductListFilter filter) {
        List<CardProduct> list = dao.listCardProduct(filter);
        List<CardProductDto> dtos = domainToDtoConverter.convert(list);
        return new QueryResult<>(dtos, filter);
    }

    @Override
    @Transactional
    public void saveOrUpdate(CardProductDto item) throws ServiceException {
        logger.info("Added a new range: {}", item.getProductConfigId());

        save(item);
    }

}
