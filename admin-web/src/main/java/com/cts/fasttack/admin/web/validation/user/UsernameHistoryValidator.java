package com.cts.fasttack.admin.web.validation.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.cts.fasttack.admin.web.service.UserService;

public class UsernameHistoryValidator implements ConstraintValidator<UsernameHistoryCheck, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UsernameHistoryCheck constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isBlank(value) || !userService.existUsernameHistory(value);
    }
}
