package com.cts.fasttack.core.service;

import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.core.converter.DCProgressDtoToDomainConverter;
import com.cts.fasttack.core.converter.DCProgressToDtoConverter;
import com.cts.fasttack.core.dao.DCProgressDao;
import com.cts.fasttack.core.data.DCProgress;
import com.cts.fasttack.core.dto.DCProgressDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Dmitry Koval
 */
@Service
public class DCProgressServiceImpl extends GenericServiceImpl<Long, DCProgressDto, DCProgress, DCProgressDao> implements DCProgressService {

    @Value("${spring.core.countOfExpireDays}")
    private int expireDays;

    public DCProgressServiceImpl(DCProgressDao dao, DCProgressToDtoConverter domainToDtoConverter, DCProgressDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional("h2TransactionManager")
    @Scheduled(cron = "${spring.core.cron4DeleteOldDcProgress}")
    public void deleteExpireAndFinishedDCProgress() {
        dao.deleteExpireAndFinishedDCProgress(expireDays);
    }

    @Override
    @Transactional(value = "h2TransactionManager", readOnly = true)
    public DCProgressDto get(Long id) {
        return super.get(id);
    }

    @Override
    @Transactional("h2TransactionManager")
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    @Transactional("h2TransactionManager")
    public void delete(DCProgressDto item) {
        super.delete(item);
    }

    @Override
    @Transactional(value ="h2TransactionManager", readOnly = true)
    public Collection<DCProgressDto> listAll() {
        return super.listAll();
    }

    @Override
    @Transactional(value = "h2TransactionManager", readOnly = true)
    public QueryResult<DCProgressDto> list(ListFilter<DCProgress> filter) {
       return super.list(filter);
    }

    @Override
    @Transactional("h2TransactionManager")
    public DCProgressDto update(DCProgressDto dto) throws BusinessLogicException {
        return super.update(dto);
    }

    @Override
    @Transactional("h2TransactionManager")
    public DCProgressDto getOrCreate(String requestId, String correlationId, String tokenRequestorId){
        DCProgress dcProgress = dao.get(requestId, correlationId, tokenRequestorId);
        if (dcProgress == null) {
            dcProgress = new DCProgress();
            dcProgress.setRequestId(requestId);
            dcProgress.setCorrelationId(correlationId);
            dcProgress.setTokenRequestorId(tokenRequestorId);
            dcProgress.setLock(false);
            dcProgress.setFinished(false);
            dcProgress = dao.save(dcProgress);
        }
        return domainToDtoConverter.convert(dcProgress);
    }

    @Override
    @Transactional(value = "h2TransactionManager", readOnly = true)
    public Optional<DCProgressDto> get(String correlationId) {
        return Optional.ofNullable(domainToDtoConverter.convert(dao.get(correlationId)));
    }

    @Override
    @Transactional("h2TransactionManager")
    public boolean tryLock(long id) {
        return dao.tryLock(id);
    }
}
