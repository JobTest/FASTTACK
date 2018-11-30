package com.cts.fasttack.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.core.converter.FEPropDtoToDomainConverter;
import com.cts.fasttack.core.converter.FEPropToFEPropDtoConverter;
import com.cts.fasttack.core.dao.FEPropDao;
import com.cts.fasttack.core.data.FEProp;
import com.cts.fasttack.core.dto.FEPropDto;

/**
 * Class with methods for actions with bank setting parameters data.
 *
 * @author v.semerkov
 */
@Service("fePropService")
public class FEPropServiceImpl extends GenericServiceImpl<String, FEPropDto, FEProp, FEPropDao> implements FEPropService {

    @Autowired
    public FEPropServiceImpl(FEPropDao dao, FEPropToFEPropDtoConverter domainToDtoConverter, FEPropDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional
    public FEPropDto createFEProp(FEPropDto dto) throws ServiceException {
        if (isExists(dto.getPropName())) {
            throw new ServiceException(StandardErrorCodes.RESOURCE_ALREADY_EXISTS, "FEProp with propName '" + dto.getPropName() + "' already exists.");
        }
        FEProp domain = dtoToDomainConverter.convert(dto);
        domain.setNew(true);
        return domainToDtoConverter.convert(dao.save(domain));
    }

    @Override
    @Transactional
    public FEPropDto updateFEProp(FEPropDto dto) throws ServiceException {
        if (!isExists(dto.getPropName())) {
            throw new ServiceException(StandardErrorCodes.RESOURCE_NOT_FOUND, "FEProp with propName '" + dto.getPropName() + "' not found.");
        }
        return super.save(dto);
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, String> getPropertyMapByNameList(List<String> propNameList) {
        return dao.getPropertyMapByNameList(propNameList);
    }
}
