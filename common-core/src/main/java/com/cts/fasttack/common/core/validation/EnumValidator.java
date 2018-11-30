package com.cts.fasttack.common.core.validation;

import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

/**
 * Validator for enum
 *
 * @author Dmitry Koval
 */
public class EnumValidator implements ConstraintValidator<ValidEnum, String> {

    private Enum<?>[] anEnum;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        anEnum = constraintAnnotation.enumType().getEnumConstants();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isBlank(value) || Arrays.stream(anEnum).anyMatch(item -> item.name().equals(value));
    }
}
