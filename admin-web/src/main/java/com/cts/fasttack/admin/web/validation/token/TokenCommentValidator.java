package com.cts.fasttack.admin.web.validation.token;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import com.cts.fasttack.admin.web.data.dto.TokenChangeStatusDto;

/**
 * @author Dmitry Koval
 */
public class TokenCommentValidator implements ConstraintValidator<ValidateTokenComment, TokenChangeStatusDto> {
    @Override
    public void initialize(ValidateTokenComment constraintAnnotation) {

    }

    @Override
    public boolean isValid(TokenChangeStatusDto value, ConstraintValidatorContext context) {
        return value.getIps().equals("V") || value.getIps().equals("M") && StringUtils.isNotBlank(value.getComment());
    }
}
