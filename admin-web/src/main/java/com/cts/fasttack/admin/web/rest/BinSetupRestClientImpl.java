package com.cts.fasttack.admin.web.rest;

import com.cts.fasttack.admin.web.config.context.parameter.AdminWebRestCoreParameters;
import com.cts.fasttack.admin.web.data.dto.BinSetupDto;
import com.cts.fasttack.admin.web.data.list.BinSetupListFilter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.handler.ServiceExceptionHandler;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author a.lipavets
 */
@Component
public class BinSetupRestClientImpl extends RestClientImpl implements BinSetupRestClient {

    @Autowired
    public BinSetupRestClientImpl(RestTemplate adminWebRestTemplate, AdminWebRestCoreParameters adminWebRestCoreParameters) {
        super(adminWebRestTemplate, adminWebRestCoreParameters.getAddress());
    }

    @Override
    public boolean isExists(String bin) throws ServiceException {
        return get("/secured/binSetup/isExists/" + bin, null, Boolean.class);
    }

    @Override
    public QueryResultDto<BinSetupDto> filter(BinSetupListFilter filter) throws ServiceException {
        return post("/secured/binSetup/list", filter, new ParameterizedTypeReference<QueryResultDto<BinSetupDto>>(){}).getBody();
    }

    @Override
    public BinSetupDto getBinSetup(Long bin) throws ServiceException {
        return get("/secured/binSetup/" + bin, null, BinSetupDto.class);
    }

    @Override
    public void createBinSetup(BinSetupDto binSetupDto) throws ServiceException {
        put("/secured/binSetup/", binSetupDto, ServiceExceptionHandler.INSTANCE);
    }

    @Override
    public void updateBinSetup(BinSetupDto binSetupDto) throws ServiceException {
        post("/secured/binSetup/", binSetupDto, Void.class);
    }

    @Override
    public void deleteBinSetup(String bin)  throws ServiceException {
        delete("/secured/binSetup/" + bin, null, ServiceExceptionHandler.INSTANCE);
    }
}
