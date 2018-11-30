package com.cts.fasttack.admin.web.service;

import com.cts.fasttack.admin.web.data.domain.Privilege;
import com.cts.fasttack.admin.web.data.dto.PrivilegeDto;
import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.service.GenericService;

public interface PrivilegeService extends GenericService<String, PrivilegeDto, Privilege> {

    PrivilegeDto createPrivilege(PrivilegeDto privilegeDto) throws BusinessLogicException;
}
