package com.cts.fasttack.core.service;

import java.util.List;
import java.util.Optional;

import com.cts.fasttack.common.core.dict.TokenEventStatus;
import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.core.data.TokenReason;
import com.cts.fasttack.core.dto.TokenReasonDto;

/**
 * @author Dmitry Koval
 */
public interface TokenReasonService extends GenericService<Long, TokenReasonDto, TokenReason> {

    List<TokenReasonDto> listByStatus(TokenEventStatus eventStatus);

    Optional<TokenReasonDto> getByTokenStatusUpdateAndMdesReason(String tokenStatusUpdate, String mdesReason);
}
