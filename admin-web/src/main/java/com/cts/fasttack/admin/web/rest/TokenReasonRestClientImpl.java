package com.cts.fasttack.admin.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.cts.fasttack.admin.web.config.context.parameter.AdminWebRestCoreParameters;
import com.cts.fasttack.admin.web.data.dto.TokenReasonDto;
import com.cts.fasttack.common.core.dict.TokenEventStatus;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenReasonRestClientImpl extends RestClientImpl implements TokenReasonRestClient {

    @Autowired
    public TokenReasonRestClientImpl(RestTemplate adminWebRestTemplate, AdminWebRestCoreParameters adminWebRestCoreParameters) {
        super(adminWebRestTemplate, adminWebRestCoreParameters.getAddress());
    }

    @Override
    public TokenReasonDto get(Long id) throws ServiceException {
        return get("/secured/tokenReasons/" + id, null, TokenReasonDto.class);
    }

    @Override
    public List<TokenReasonDto> listByStatus(TokenEventStatus tokenEventStatus) throws ServiceException {
        return post("/secured/tokenReasons/status/" + tokenEventStatus, null, new ParameterizedTypeReference<List<TokenReasonDto>>() {
        }).getBody();
    }
}
