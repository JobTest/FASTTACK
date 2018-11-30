package com.cts.fasttack.admin.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import com.cts.fasttack.admin.web.converter.RoleToDomainConverter;
import com.cts.fasttack.admin.web.converter.RoleToDtoConverter;
import com.cts.fasttack.admin.web.dao.PrivilegeDao;
import com.cts.fasttack.admin.web.dao.RoleDao;
import com.cts.fasttack.admin.web.data.domain.Role;
import com.cts.fasttack.admin.web.data.dto.RoleDto;
import com.cts.fasttack.admin.web.data.list.PrivilegeListFilter;
import com.cts.fasttack.admin.web.security.data.ReAuthenticationMessage;
import com.cts.fasttack.admin.web.service.RoleService;
import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.jms.support.IntegrationBus;

@Service("roleService")
public class RoleServiceImpl extends GenericServiceImpl<String, RoleDto, Role, RoleDao> implements RoleService {

    @Autowired
    private PrivilegeDao privilegeDao;

    @Autowired
    private IntegrationBus integrationBus;

    public RoleServiceImpl(RoleDao dao, RoleToDtoConverter domainToDtoConverter, RoleToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional
    public RoleDto createRole(RoleDto roleDto) {
        Role role = dtoToDomainConverter.convert(roleDto);
        role.setNew(true);
        role.setId(roleDto.getId());
        updateReferences(role, roleDto);
        return domainToDtoConverter.convert(dao.save(role));
    }

    @Override
    @Transactional
    public RoleDto save(RoleDto roleDto) throws BusinessLogicException {
        Role role = dao.get(roleDto.getId());
        if (role == null) {
            throw new BusinessLogicException("Role with id '" + roleDto.getId() + "' not found");
        }
        updateReferences(role, roleDto);
        dtoToDomainConverter.convertPrimitives(roleDto, role);
        RoleDto saved = domainToDtoConverter.convert(dao.save(role));
        discardAuthoritiesByRole(saved.getId());
        return saved;
    }

    @Override
    @Transactional
    public void delete(String id) throws BusinessLogicException {
        super.delete(id);
        discardAuthoritiesByRole(id);
    }

    private void updateReferences(Role domain, RoleDto dto) throws BusinessLogicException {
        if (CollectionUtils.isEmpty(dto.getPrivileges())) {
            domain.setPrivileges(null);
        } else {
            domain.getPrivileges().clear();
            domain.getPrivileges().addAll(privilegeDao.listPrivileges(PrivilegeListFilter.builder().privilegeCodes(dto.getPrivilegeCodes()).unlimited().build()));
        }
    }

    private void discardAuthoritiesByRole(String roleId) {
        try {
            integrationBus.publish("reAuth", ReAuthenticationMessage.forRole(roleId));
        } catch (ServiceException e) {
            log.error("Couldn't send jms message", e);
        }
    }
}
