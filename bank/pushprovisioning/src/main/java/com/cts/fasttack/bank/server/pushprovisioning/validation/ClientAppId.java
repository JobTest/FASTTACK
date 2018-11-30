package com.cts.fasttack.bank.server.pushprovisioning.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Anton Leliuk
 */
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = ClientAppIdValidation.class)
@Documented
public @interface ClientAppId {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
