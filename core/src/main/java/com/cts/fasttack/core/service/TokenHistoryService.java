package com.cts.fasttack.core.service;

import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.core.data.TokenHistory;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.core.dto.TokenHistoryList;
import com.cts.fasttack.core.filter.TokenHistoryFilter;

/**
 * Service for {@link TokenHistory}
 * @author a.lipavets
 */
public interface TokenHistoryService extends GenericService<Long, TokenHistoryDto, TokenHistory> {

    QueryResult<TokenHistoryList> listTokenHistory(TokenHistoryFilter filter);
}
