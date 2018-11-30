package com.cts.fasttack.admin.web.rest;

import com.cts.fasttack.admin.web.config.context.parameter.AdminWebRestCoreParameters;
import com.cts.fasttack.admin.web.data.dto.CardProductDto;
import com.cts.fasttack.admin.web.data.list.CardProductListFilter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.exception.handler.ServiceExceptionHandler;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CardProductRestClientImpl extends RestClientImpl implements CardProductRestClient {

    @Autowired
    public CardProductRestClientImpl(RestTemplate adminWebRestTemplate, AdminWebRestCoreParameters adminWebRestCoreParameters) {
        super(adminWebRestTemplate, adminWebRestCoreParameters.getAddress());
    }

    @Override
    public boolean isExists(String propName) throws ServiceException {
        return get("/secured/cardProduct/isExists/" + propName, null, Boolean.class);
    }

    @Override
    public QueryResultDto<CardProductDto> filterCardProduct(CardProductListFilter filter) throws ServiceException {
        return post("/secured/cardProduct/list", filter, new ParameterizedTypeReference<QueryResultDto<CardProductDto>>(){}).getBody();
    }

    @Override
    public CardProductDto getCardProduct(String productConfigId) throws ServiceException {
        return get("/secured/cardProduct/" + productConfigId, null, CardProductDto.class);
    }

    @Override
    public void createCardProduct(CardProductDto cardProduct) throws ServiceException {
        put("/secured/cardProduct/", cardProduct, ServiceExceptionHandler.INSTANCE);
    }

    @Override
    public void updateCardProduct(CardProductDto cardProduct) throws ServiceException {
        post("/secured/cardProduct/", cardProduct, Void.class);
    }

    @Override
    public void deleteCardProduct(String productConfigId) throws ServiceException {
        delete("/secured/cardProduct/" + productConfigId, null, ServiceExceptionHandler.INSTANCE);
    }
}
