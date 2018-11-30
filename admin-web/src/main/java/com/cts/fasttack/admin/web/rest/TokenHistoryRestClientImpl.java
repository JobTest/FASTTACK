package com.cts.fasttack.admin.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.cts.fasttack.admin.web.config.context.parameter.AdminWebRestCoreParameters;
import com.cts.fasttack.admin.web.data.dto.TokenHistoryRowDto;
import com.cts.fasttack.admin.web.data.list.TokenHistoryFilter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenHistoryRestClientImpl extends RestClientImpl implements TokenHistoryRestClient {

    @Autowired
    public TokenHistoryRestClientImpl(RestTemplate adminWebRestTemplate, AdminWebRestCoreParameters adminWebRestCoreParameters) {
        super(adminWebRestTemplate, adminWebRestCoreParameters.getAddress());
    }

    @Override
    public QueryResultDto<TokenHistoryRowDto> listTokenHistory(TokenHistoryFilter<?> filter) throws ServiceException {
        return post("/secured/tokenHistory/list", filter, new ParameterizedTypeReference<QueryResultDto<TokenHistoryRowDto>>(){}).getBody();
    }
}
