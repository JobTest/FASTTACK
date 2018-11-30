package com.cts.fasttack.admin.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import com.cts.fasttack.admin.web.data.domain.User;
import com.cts.fasttack.admin.web.data.dto.UserDto;
import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;

public abstract class AbstractUserToDtoConverter<DOMAIN extends User, DTO extends UserDto> extends IdentifierToDtoConverter<String, DOMAIN, DTO> {

    @Autowired
    protected RoleToDtoConverter roleToDtoConverter;

    @Override
    protected void lightConvert(DOMAIN source, DTO target) {
        super.lightConvert(source, target);
        target.setNew(source.isNew());
        target.setUsername(source.getUsername());
        target.setPhone(source.getPhone());
        target.setName(source.getName());
        target.setRegDate(source.getRegDate());
        target.setStatus(source.getStatus());
        target.setUnlockDate(source.getUnlockDate());
        target.setPwdchDate(source.getPwdchDate());
        target.setLastlogonDate(source.getLastlogonDate());
        target.setLogonFailures(source.getLogonFailures());
        target.setNeedResetPassword(source.isNeedResetPassword());
    }
}
