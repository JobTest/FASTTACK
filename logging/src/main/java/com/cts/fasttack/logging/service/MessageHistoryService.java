package com.cts.fasttack.logging.service;

import com.cts.fasttack.common.core.service.GenericService;

import com.cts.fasttack.logging.domain.MessageHistory;
import com.cts.fasttack.logging.dto.MessageHistoryDto;

/**
 * @author Dmitry Koval
 */
public interface MessageHistoryService extends GenericService<Long, MessageHistoryDto, MessageHistory> {
}
