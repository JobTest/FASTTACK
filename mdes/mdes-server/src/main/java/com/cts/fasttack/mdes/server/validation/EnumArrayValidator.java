package com.cts.fasttack.mdes.server.validation;

import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator for enum array
 *
 * @author Dmitry Koval
 */
public class EnumArrayValidator implements ConstraintValidator<ValidEnumArray, List<String>> {

    private Enum<?>[] anEnum;

    @Override
    public void initialize(ValidEnumArray constraintAnnotation) {
        anEnum = constraintAnnotation.enumType().getEnumConstants();
    }

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        return value == null || value.stream().allMatch(item -> Arrays.stream(anEnum).anyMatch(enumName -> enumName.name().equals(item)));
    }

}
