package com.cts.fasttack.admin.web.validation.cardProduct;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RangeLengthValidator.class)
public @interface RangeLengthCheck {

    String message() default "{cardProduct.validation.length.range}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
