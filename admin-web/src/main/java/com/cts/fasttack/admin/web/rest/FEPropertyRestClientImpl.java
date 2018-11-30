package com.cts.fasttack.admin.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.cts.fasttack.admin.web.config.context.parameter.AdminWebRestCoreParameters;
import com.cts.fasttack.admin.web.data.dto.FEPropDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.handler.ServiceExceptionHandler;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;
import com.cts.fasttack.common.core.util.ObjectUtil;

@Component
public class FEPropertyRestClientImpl extends RestClientImpl implements FEPropertyRestClient {

    @Autowired
    public FEPropertyRestClientImpl(RestTemplate adminWebRestTemplate, AdminWebRestCoreParameters adminWebRestCoreParameters) {
        super(adminWebRestTemplate, adminWebRestCoreParameters.getAddress());
    }

    @Override
    public boolean isExists(String propName) throws ServiceException {
        return get("/secured/feProp/isExists/" + propName, null, Boolean.class);
    }

    @Override
    public QueryResult<FEPropDto> filterFEProperty(ListFilter<?> filter) throws ServiceException {
        return ObjectUtil.uncheckedCast(post("/secured/feProp/list", filter, QueryResult.class));
    }

    @Override
    public FEPropDto getFEProp(String propName) throws ServiceException {
        return get("/secured/feProp/" + propName, null, FEPropDto.class);
    }

    @Override
    public void createFEProp(FEPropDto feProp) throws ServiceException {
        put("/secured/feProp/", feProp, ServiceExceptionHandler.INSTANCE);
    }

    @Override
    public void updateFEProp(FEPropDto feProp) throws ServiceException {
        post("/secured/feProp/", feProp, Void.class);
    }

    @Override
    public void deleteFEProp(String propName) throws ServiceException {
        delete("/secured/feProp/" + propName, null, ServiceExceptionHandler.INSTANCE);
    }
}
