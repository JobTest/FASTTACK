package com.cts.fasttack.admin.web.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.domain.Privilege;
import com.cts.fasttack.admin.web.data.dto.PrivilegeDto;
import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;

@Component
public class PrivilegeToDtoConverter extends IdentifierToDtoConverter<String, Privilege, PrivilegeDto> {

    @Override
    protected PrivilegeDto generateTarget() {
        return new PrivilegeDto();
    }

    @Override
    protected void lightConvert(Privilege source, PrivilegeDto target) {
        super.lightConvert(source, target);
        target.setDescription(source.getDescription());
    }
}
