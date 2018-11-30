package com.cts.fasttack.core.service;

import java.util.Optional;

import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.core.data.CvcAttempt;
import com.cts.fasttack.core.dto.CvcAttemptDto;

/**
 * @author Dmitry Koval
 */
public interface CvcAttemptService extends GenericService<Long, CvcAttemptDto, CvcAttempt> {

    Optional<CvcAttemptDto> getByPanInternalIdAndGUID(String panInternalID, String panInternalGUID);
}
