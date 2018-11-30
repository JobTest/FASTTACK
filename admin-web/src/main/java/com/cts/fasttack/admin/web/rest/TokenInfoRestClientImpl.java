package com.cts.fasttack.admin.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.cts.fasttack.admin.web.config.context.parameter.AdminWebRestCoreParameters;
import com.cts.fasttack.admin.web.data.dto.TokenInfoDto;
import com.cts.fasttack.admin.web.data.dto.TokenInfoId;
import com.cts.fasttack.admin.web.data.dto.TokenInfoListDto;
import com.cts.fasttack.admin.web.data.list.TokenListFilter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenInfoRestClientImpl extends RestClientImpl implements TokenInfoRestClient {

    @Autowired
    public TokenInfoRestClientImpl(RestTemplate adminWebRestTemplate, AdminWebRestCoreParameters adminWebRestCoreParameters) {
        super(adminWebRestTemplate, adminWebRestCoreParameters.getAddress());
    }

    @Override
    public TokenInfoDto get(String tokenRefId, String tokenRequestorId) throws ServiceException {
        return get("/secured/tokenInfo/" + tokenRefId + "/" + tokenRequestorId, null, TokenInfoDto.class);
    }

    @Override
    public QueryResultDto<TokenInfoListDto> list(TokenListFilter filter) throws ServiceException {
        return post("/secured/tokenInfo/list", filter, new ParameterizedTypeReference<QueryResultDto<TokenInfoListDto>>(){}).getBody();
    }

    @Override
    public List<TokenInfoListDto> listByTokenInfoId(List<TokenInfoId> tokenInfoIds) throws ServiceException {
        return post("/secured/tokenInfo/listTokenInfoId", tokenInfoIds, new ParameterizedTypeReference<List<TokenInfoListDto>>(){}).getBody();
    }
}
