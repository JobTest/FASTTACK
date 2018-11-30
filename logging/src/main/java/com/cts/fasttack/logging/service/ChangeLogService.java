package com.cts.fasttack.logging.service;

import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.logging.domain.ChangeLog;
import com.cts.fasttack.logging.dto.ChangeLogDto;

/**
 * Service for {@link ChangeLog}
 *
 * @author Dmitry Koval
 */
public interface ChangeLogService extends GenericService<Long, ChangeLogDto, ChangeLog> {

    void save(ChangeLog log);

}
