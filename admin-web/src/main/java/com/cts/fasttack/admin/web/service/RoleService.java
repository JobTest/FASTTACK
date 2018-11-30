package com.cts.fasttack.admin.web.service;

import com.cts.fasttack.admin.web.data.domain.Role;
import com.cts.fasttack.admin.web.data.dto.RoleDto;
import com.cts.fasttack.common.core.service.GenericService;

public interface RoleService extends GenericService<String, RoleDto, Role> {

    RoleDto createRole(RoleDto roleDto);
}
