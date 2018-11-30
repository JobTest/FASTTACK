package com.cts.fasttack.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fasttack.common.core.dict.TokenEventStatus;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.core.converter.TokenReasonDtoToDomainConverter;
import com.cts.fasttack.core.converter.TokenReasonToDtoConverter;
import com.cts.fasttack.core.dao.TokenReasonDao;
import com.cts.fasttack.core.data.TokenReason;
import com.cts.fasttack.core.dto.TokenReasonDto;

/**
 * @author Dmitry Koval
 */
@Service
public class TokenReasonServiceImpl extends GenericServiceImpl<Long, TokenReasonDto, TokenReason, TokenReasonDao> implements TokenReasonService {

    @Autowired
    private TokenReasonToDtoConverter tokenReasonToDtoConverter;

    public TokenReasonServiceImpl(TokenReasonDao dao, TokenReasonToDtoConverter domainToDtoConverter, TokenReasonDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TokenReasonDto> listByStatus(TokenEventStatus eventStatus) {
        return domainToDtoConverter.convert(dao.listByStatus(eventStatus));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TokenReasonDto> getByTokenStatusUpdateAndMdesReason(String tokenStatusUpdate, String mdesReason) {
        return Optional.ofNullable(tokenReasonToDtoConverter.convert(dao.getByTokenStatusUpdateAndMdesReason(tokenStatusUpdate, mdesReason)));
    }
}
