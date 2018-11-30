package com.cts.fasttack.admin.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.domain.Role;
import com.cts.fasttack.admin.web.data.dto.RoleDto;
import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;

@Component
public class RoleToDtoConverter extends IdentifierToDtoConverter<String, Role, RoleDto> {

    @Autowired
    private PrivilegeToDtoConverter privilegeConverter;

    @Override
    protected RoleDto generateTarget() {
        return new RoleDto();
    }

    @Override
    protected void lightConvert(Role source, RoleDto target) {
        super.lightConvert(source, target);
        target.setDescription(source.getDescription());
        target.setNew(source.isNew());
        privilegeConverter.convert(source.getPrivileges(),target.getPrivileges());
    }
}
