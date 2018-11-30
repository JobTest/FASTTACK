package com.cts.fasttack.logging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.logging.converter.MessageHistoryDtoToDomainConverter;
import com.cts.fasttack.logging.converter.MessageHistoryToDtoConverter;
import com.cts.fasttack.logging.dao.MessageHistoryDao;
import com.cts.fasttack.logging.domain.MessageHistory;
import com.cts.fasttack.logging.dto.MessageHistoryDto;

/**
 * @author Dmitry Koval
 */
@Service("messageHistoryService")
public class MessageHistoryServiceImpl extends GenericServiceImpl<Long, MessageHistoryDto, MessageHistory, MessageHistoryDao> implements MessageHistoryService {

    @Autowired
    public MessageHistoryServiceImpl(MessageHistoryDao dao, MessageHistoryToDtoConverter domainToDtoConverter, MessageHistoryDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }
}
