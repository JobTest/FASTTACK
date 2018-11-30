package com.cts.fasttack.admin.web.validation.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import com.cts.fasttack.admin.web.data.dto.UserPasswordAwareDto;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.admin.web.util.DigestEncoderHelper;

public class UserPasswordHistoryValidator implements ConstraintValidator<UserPasswordHistoryCheck, UserPasswordAwareDto> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UserPasswordHistoryCheck constraintAnnotation) {}

    @Override
    public boolean isValid(UserPasswordAwareDto dto, ConstraintValidatorContext context) {
        return !userService.existPasswordHistory(dto.getUsername(), DigestEncoderHelper.encode(dto.getNewPassword(), dto.getUsername()));
    }
}
