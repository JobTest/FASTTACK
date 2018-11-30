package com.cts.fasttack.logging.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.logging.converter.ChangeLogDtoToDomainConverter;
import com.cts.fasttack.logging.converter.ChangeLogToDtoConverter;
import com.cts.fasttack.logging.dao.ChangeLogDao;
import com.cts.fasttack.logging.domain.ChangeLog;
import com.cts.fasttack.logging.dto.ChangeLogDto;

/**
 * @author Dmitry Koval
 */
@Service
public class ChangeLogServiceImpl extends GenericServiceImpl<Long, ChangeLogDto, ChangeLog, ChangeLogDao> implements ChangeLogService {

    @Autowired
    private ChangeLogDao dao;

    private final Logger logger = LogManager.getLogger(getClass());

    private static final int MAX_ITEM_ID_LENGTH = 64;

    public ChangeLogServiceImpl(ChangeLogDao dao, ChangeLogToDtoConverter domainToDtoConverter, ChangeLogDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional
    public void save(ChangeLog log) {
        if (log.getItemId() != null && log.getItemId().length() > MAX_ITEM_ID_LENGTH) {
            logger.warn("Unexpected itemId length. ItemId: '" + log.getItemId() + "', itemId length: '" + log.getItemId().length() + "', expected length: '" + MAX_ITEM_ID_LENGTH + "'.");
            log.setItemId(null);
        }
        log.setMessage(StringUtil.substringLimitInBytes(log.getMessage(), 0, 250));
        dao.save(log);
    }
}
