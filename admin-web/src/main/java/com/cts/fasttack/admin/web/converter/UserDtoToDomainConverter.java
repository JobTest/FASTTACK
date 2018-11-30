package com.cts.fasttack.admin.web.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.domain.User;
import com.cts.fasttack.admin.web.data.dto.UserDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;

@Component
public class UserDtoToDomainConverter extends AbstractConverter<UserDto, User> {

    @Override
    public User generateTarget() {
        return new User();
    }

    @Override
    public void lightConvert(UserDto source, User target){
        convertPrimitives(source, target);
    }

    @Override
    public void convertPrimitives(UserDto source, User target) {
        target.setUsername(source.getUsername());
        target.setPhone(source.getPhone());
        target.setName(source.getName());
        target.setRegDate(source.getRegDate());
        target.setStatus(source.getStatus());
        target.setUnlockDate(source.getUnlockDate());
        target.setPwdchDate(source.getPwdchDate());
        target.setLastlogonDate(source.getLastlogonDate());
        target.setLogonFailures(source.getLogonFailures());
    }
}
