package com.cts.fasttack.admin.web.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fasttack.admin.web.converter.PrivilegeDtoToDomainConverter;
import com.cts.fasttack.admin.web.converter.PrivilegeToDtoConverter;
import com.cts.fasttack.admin.web.dao.PrivilegeDao;
import com.cts.fasttack.admin.web.data.domain.Privilege;
import com.cts.fasttack.admin.web.data.dto.PrivilegeDto;
import com.cts.fasttack.admin.web.service.PrivilegeService;
import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.service.GenericServiceImpl;

@Service
public class PrivilegeServiceImpl extends GenericServiceImpl<String, PrivilegeDto, Privilege, PrivilegeDao> implements PrivilegeService {

    public PrivilegeServiceImpl(PrivilegeDao dao, PrivilegeToDtoConverter domainToDtoConverter, PrivilegeDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional
    public PrivilegeDto createPrivilege(PrivilegeDto privilegeDto) throws BusinessLogicException {
        Privilege privilege = dtoToDomainConverter.convert(privilegeDto);
        return domainToDtoConverter.convert(dao.save(privilege));
    }
}
