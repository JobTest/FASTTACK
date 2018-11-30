package com.cts.fasttack.admin.web.rest;

import java.util.List;

import com.cts.fasttack.admin.web.data.dto.TokenInfoDto;
import com.cts.fasttack.admin.web.data.dto.TokenInfoId;
import com.cts.fasttack.admin.web.data.dto.TokenInfoListDto;
import com.cts.fasttack.admin.web.data.list.TokenListFilter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * @author Dmitry Koval
 */
public interface TokenInfoRestClient {

    /**
     * Get Token Info
     * @param tokenRefId Token Reference ID
     * @param tokenRequestorId Token Requestor ID
     * @return {@link TokenInfoDto}
     * @throws ServiceException if exception happens
     */
    TokenInfoDto get(String tokenRefId, String tokenRequestorId) throws ServiceException;

    /**
     * List tokens
     * @param filter filter
     * @return {@link QueryResultDto} of tokens
     * @throws ServiceException if exception happens
     */
    QueryResultDto<TokenInfoListDto> list(TokenListFilter filter) throws ServiceException;

    /**
     * List tokens by token info ID
     *
     * @param tokenInfoIds
     * @return list tokens
     * @throws ServiceException
     */
    List<TokenInfoListDto> listByTokenInfoId(List<TokenInfoId> tokenInfoIds) throws ServiceException;
}
