package com.cts.fasttack.admin.web.service;

import com.cts.fasttack.admin.web.data.dto.TokenInfoListDto;
import com.cts.fasttack.admin.web.data.list.CardReplacementFilter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;

public interface CardService {

    /**
     * Tokens replacement Pan
     *
     * @param cardReplacementFilter
     * @return
     */
    QueryResultDto<TokenInfoListDto> replacement(CardReplacementFilter cardReplacementFilter) throws ServiceException;
}
