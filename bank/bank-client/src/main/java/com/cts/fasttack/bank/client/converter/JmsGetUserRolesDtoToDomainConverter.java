package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.bank.client.ws.client.GetUserRoles;
import com.cts.fasttack.bank.client.ws.client.ObjectFactory;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsGetUserRolesRequestDto;
import org.springframework.stereotype.Component;

@Component
public class JmsGetUserRolesDtoToDomainConverter extends AbstractConverter<JmsGetUserRolesRequestDto, GetUserRoles> {

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    @Override
    protected GetUserRoles generateTarget() {
        return OBJECT_FACTORY.createGetUserRoles();
    }

    @Override
    protected void lightConvert(JmsGetUserRolesRequestDto source, GetUserRoles target) {
        target.setUser(source.getUser());
        target.setPosCode(source.getPosCode());
        target.setSystemName(source.getSystemName());
    }
}
