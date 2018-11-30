package com.cts.fasttack.admin.web.validation.cardProduct;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RangeLengthValidator implements ConstraintValidator<RangeLengthCheck, String> {

    @Override
    public void initialize(RangeLengthCheck constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isNotBlank(value)
                    && (16 <= value.length() && value.length() <= 19)
                ? true
                : false;
    }
}
