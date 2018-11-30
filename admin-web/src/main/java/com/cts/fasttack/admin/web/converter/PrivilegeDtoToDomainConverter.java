package com.cts.fasttack.admin.web.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.domain.Privilege;
import com.cts.fasttack.admin.web.data.dto.PrivilegeDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;

@Component
public class PrivilegeDtoToDomainConverter extends AbstractConverter<PrivilegeDto, Privilege> {

    @Override
    public Privilege generateTarget() {
        return new Privilege();
    }

    @Override
    public void lightConvert(PrivilegeDto source, Privilege target) {
        target.setDescription(source.getDescription());
    }

}
