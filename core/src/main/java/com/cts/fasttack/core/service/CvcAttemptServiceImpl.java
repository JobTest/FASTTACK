package com.cts.fasttack.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.core.converter.CvcAttemptDtoToDomainConverter;
import com.cts.fasttack.core.converter.CvcAttemptToDtoConverter;
import com.cts.fasttack.core.dao.CvcAttemptDao;
import com.cts.fasttack.core.data.CvcAttempt;
import com.cts.fasttack.core.dto.CvcAttemptDto;

/**
 * @author Dmitry Koval
 */
@Service
public class CvcAttemptServiceImpl extends GenericServiceImpl<Long, CvcAttemptDto, CvcAttempt, CvcAttemptDao> implements CvcAttemptService {

    @Autowired
    private CvcAttemptToDtoConverter cvcAttemptToDtoConverter;

    @Autowired
    public CvcAttemptServiceImpl(CvcAttemptDao dao, CvcAttemptToDtoConverter domainToDtoConverter, CvcAttemptDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CvcAttemptDto> getByPanInternalIdAndGUID(String panInternalID, String panInternalGUID) {
        return Optional.ofNullable(cvcAttemptToDtoConverter.convert(dao.getByPanInternalIdAndGUID(panInternalID, panInternalGUID)));
    }
}
