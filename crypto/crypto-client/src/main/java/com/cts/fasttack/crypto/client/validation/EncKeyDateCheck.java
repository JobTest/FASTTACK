package com.cts.fasttack.crypto.client.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.cts.fasttack.crypto.client.dto.EncKeyRequestResponseDto;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EncKeyDateCheck.EncKeyDateValidator.class)
@Documented
public @interface EncKeyDateCheck {
    String message() default "";

    Class<?> [] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fields() default "";

    class EncKeyDateValidator implements ConstraintValidator<EncKeyDateCheck, EncKeyRequestResponseDto> {

        @Override
        public void initialize(EncKeyDateCheck encKeyDateCheck) {}

        @Override
        public boolean isValid(EncKeyRequestResponseDto encKeyDto, ConstraintValidatorContext constraintValidatorContext) {
            return encKeyDto.getEffDate() == null
                    || encKeyDto.getExpDate() == null
                    || encKeyDto.getExpDate().compareTo(encKeyDto.getEffDate()) != -1;
        }
    }
}
