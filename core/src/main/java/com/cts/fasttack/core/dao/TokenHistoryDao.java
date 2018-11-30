package com.cts.fasttack.core.dao;

import java.util.List;

import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.core.data.TokenHistory;
import com.cts.fasttack.core.dto.TokenHistoryList;
import com.cts.fasttack.core.filter.TokenHistoryFilter;

/**
 * @author a.lipavets
 */
public interface TokenHistoryDao extends GenericDao<Long, TokenHistory> {

    List<TokenHistoryList> listTokenHistory(TokenHistoryFilter filter);
}
