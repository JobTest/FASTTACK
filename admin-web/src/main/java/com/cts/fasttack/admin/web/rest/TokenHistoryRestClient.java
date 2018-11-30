package com.cts.fasttack.admin.web.rest;

import com.cts.fasttack.admin.web.data.dto.TokenHistoryRowDto;
import com.cts.fasttack.admin.web.data.list.TokenHistoryFilter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * @author Dmitry Koval
 */
public interface TokenHistoryRestClient {
    /**
     * Get List of token history by filter
     *
     * @param filter
     * @return
     * @throws ServiceException
     */
    QueryResultDto<TokenHistoryRowDto> listTokenHistory(TokenHistoryFilter<?> filter) throws ServiceException;
}
