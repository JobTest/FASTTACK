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
        boolean isNotIps = value.getIps().equals("V") || value.getIps().equals("M");
        if (!isNotIps)
            return false;

        if (value.getTokenRefId().contains("NotYetAssigned")) {
            context.disableDefaultConstraintViolation();
            if (StringUtils.isBlank(value.getComment()) && StringUtils.isBlank(value.getPan())) {
                context.buildConstraintViolationWithTemplate("{token.pan_comment.empty}").addConstraintViolation();
                return false;
            } else if (StringUtils.isNotBlank(value.getComment()) && StringUtils.isBlank(value.getPan())) {
                context.buildConstraintViolationWithTemplate("{token.pan.empty}").addConstraintViolation();
                return false;
            } else if (StringUtils.isBlank(value.getComment()) && StringUtils.isNotBlank(value.getPan())) {
                context.buildConstraintViolationWithTemplate("{token.comment.empty}").addConstraintViolation();
                return false;
            }
        }
        return value.getIps().equals("V") || value.getIps().equals("M") && (StringUtils.isNotBlank(value.getComment()));
    }
}
