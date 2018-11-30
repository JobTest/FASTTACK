package com.cts.fasttack.admin.web.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.domain.Role;
import com.cts.fasttack.admin.web.data.dto.RoleDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;

@Component
public class RoleToDomainConverter extends AbstractConverter<RoleDto, Role> {

    @Override
    protected Role generateTarget() {
        return new Role();
    }

    @Override
    public void lightConvert(RoleDto source, Role target) {
        convertPrimitives(source,target);
    }

    @Override
    public void convertPrimitives(RoleDto source, Role target) {
        target.setDescription(source.getDescription());
    }
}
