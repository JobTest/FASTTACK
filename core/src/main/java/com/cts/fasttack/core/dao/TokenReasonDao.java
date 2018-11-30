package com.cts.fasttack.core.dao;

import java.util.List;

import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.common.core.dict.TokenEventStatus;
import com.cts.fasttack.core.data.TokenReason;

/**
 * @author Dmitry Koval
 */
public interface TokenReasonDao extends GenericDao<Long, TokenReason> {

    List<TokenReason> listByStatus(TokenEventStatus eventStatus);

    String getMdesReason(TokenEventStatus tokenEventStatus, String reason);

    TokenReason getByTokenStatusUpdateAndMdesReason(String tokenStatusUpdate, String mdesReason);
}
