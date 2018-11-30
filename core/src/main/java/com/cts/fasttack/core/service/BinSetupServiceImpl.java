package com.cts.fasttack.core.service;

import java.util.Optional;

import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.core.converter.BinSetupDtoToDomainConverter;
import com.cts.fasttack.core.converter.BinSetupToDtoConverter;
import com.cts.fasttack.core.dao.BinSetupDao;
import com.cts.fasttack.core.data.BinSetup;
import com.cts.fasttack.core.dto.BinSetupDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BinSetupServiceImpl extends GenericServiceImpl<Long, BinSetupDto, BinSetup, BinSetupDao> implements BinSetupService {

    public BinSetupServiceImpl(BinSetupDao dao, BinSetupToDtoConverter domainToDtoConverter, BinSetupDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional
    public BinSetupDto createNew(BinSetupDto dto) {
        dto.setNew(true);
        return super.save(dto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BinSetupDto> getSuitableBin(String bin) {
        BinSetup binSetup = dao.getSuitableBin(bin);
        return Optional.ofNullable(domainToDtoConverter.convert(binSetup));
    }
}
