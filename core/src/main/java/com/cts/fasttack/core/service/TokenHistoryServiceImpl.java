package com.cts.fasttack.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.core.converter.TokenHistoryDtoToDomainConverter;
import com.cts.fasttack.core.converter.TokenHistoryToDtoConverter;
import com.cts.fasttack.core.dao.TokenHistoryDao;
import com.cts.fasttack.core.data.TokenHistory;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.core.dto.TokenHistoryList;
import com.cts.fasttack.core.filter.TokenHistoryFilter;

/**
 * @author a.lipavets
 */
@Service("tokenHistoryService")
public class TokenHistoryServiceImpl extends GenericServiceImpl<Long, TokenHistoryDto, TokenHistory, TokenHistoryDao> implements TokenHistoryService {

    @Autowired
    public TokenHistoryServiceImpl(TokenHistoryDao dao, TokenHistoryToDtoConverter domainToDtoConverter, TokenHistoryDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResult<TokenHistoryList> listTokenHistory(TokenHistoryFilter filter) {
        return new QueryResult<>(dao.listTokenHistory(filter), filter);
    }
}
