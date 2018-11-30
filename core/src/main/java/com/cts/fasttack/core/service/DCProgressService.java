package com.cts.fasttack.core.service;

import java.util.Optional;

import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.core.data.DCProgress;
import com.cts.fasttack.core.dto.DCProgressDto;

/**
 * Service for {@link DCProgress}
 *
 * @author Dmitry Koval
 */
public interface DCProgressService extends GenericService<Long, DCProgressDto, DCProgress> {

    void deleteExpireAndFinishedDCProgress();

    /**
     * Find {@link DCProgressDto} by field or create new if not found
     * @param requestId request identifier
     * @param correlationId correlation identifier
     * @param tokenRequestorId tokenRequestor identifier
     * @return {@link DCProgressDto}
     */
    DCProgressDto getOrCreate(String requestId, String correlationId, String tokenRequestorId);

    /**
     * Find {@link DCProgressDto} by correlationId
     * @param correlationId correlation identifier
     * @return {@link DCProgressDto} or empty
     */
    Optional<DCProgressDto> get(String correlationId);

    /**
     * Try lock DCProgress
     * @param id - identifier of DCProgress
     * @return true if DCProgress locked
     */
    boolean tryLock(long id);
}
