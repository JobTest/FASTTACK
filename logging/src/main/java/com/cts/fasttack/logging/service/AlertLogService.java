package com.cts.fasttack.logging.service;

import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.logging.domain.AlertLog;
import com.cts.fasttack.logging.dto.AlertLogDto;

/**
 * Service for {@link AlertLog}
 *
 * @author Dmitry Koval
 */
public interface AlertLogService extends GenericService<Long, AlertLogDto, AlertLog> {

}
