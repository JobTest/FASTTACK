package com.cts.fasttack.admin.web.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.domain.User;
import com.cts.fasttack.admin.web.data.dto.UserDto;

@Component
public class UserToDtoConverter extends AbstractUserToDtoConverter<User, UserDto> {

    @Override
    protected UserDto generateTarget() {
        return new UserDto();
    }

    @Override
    protected void lightConvert(User source, UserDto target) {
        super.lightConvert(source, target);
        roleToDtoConverter.convert(source.getRoles(), target.getRoles());
    }
}
