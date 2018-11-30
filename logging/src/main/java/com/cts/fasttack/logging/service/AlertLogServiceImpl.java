package com.cts.fasttack.logging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.logging.converter.AlertLogDtoToDomainConverter;
import com.cts.fasttack.logging.converter.AlertLogToDtoConverter;
import com.cts.fasttack.logging.dao.AlertLogDao;
import com.cts.fasttack.logging.domain.AlertLog;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;

/**
 * @author Dmitry Koval
 */
@Service("alertLogService")
public class AlertLogServiceImpl extends GenericServiceImpl<Long, AlertLogDto, AlertLog, AlertLogDao> implements AlertLogService {

    @Autowired
    public AlertLogServiceImpl(AlertLogDao dao, AlertLogToDtoConverter domainToDtoConverter, AlertLogDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }
}
