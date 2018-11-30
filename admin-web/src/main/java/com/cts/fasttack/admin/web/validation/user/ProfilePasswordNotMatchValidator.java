package com.cts.fasttack.admin.web.validation.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import com.cts.fasttack.admin.web.data.dto.ProfileDto;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.admin.web.util.DigestEncoderHelper;

public class ProfilePasswordNotMatchValidator implements ConstraintValidator<ProfilePasswordMatching, ProfileDto> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(ProfilePasswordMatching constraintAnnotation) {

    }

    @Override
    public boolean isValid(ProfileDto dto, ConstraintValidatorContext context) {
        UserAuthoritiesDto currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            return false;
        }
        String password = DigestEncoderHelper.encode(dto.getCurrentPassword(), currentUser.getUsername());
        return userService.isPasswordEqualsForUser(currentUser.getUsername(), password);
    }
}
