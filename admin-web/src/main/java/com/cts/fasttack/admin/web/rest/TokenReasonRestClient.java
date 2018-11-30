package com.cts.fasttack.admin.web.rest;

import java.util.List;

import com.cts.fasttack.admin.web.data.dto.TokenReasonDto;
import com.cts.fasttack.common.core.dict.TokenEventStatus;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClient;

/**
 * @author Dmitry Koval
 */
public interface TokenReasonRestClient extends RestClient {

    TokenReasonDto get(Long id) throws ServiceException;

    List<TokenReasonDto> listByStatus(TokenEventStatus tokenEventStatus) throws ServiceException;
}
