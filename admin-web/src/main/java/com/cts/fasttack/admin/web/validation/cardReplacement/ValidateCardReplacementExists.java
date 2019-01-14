package com.cts.fasttack.admin.web.validation.cardReplacement;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CardReplacementExistsValidator.class)
public @interface ValidateCardReplacementExists {

    String message() default "{card.number.exist.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
