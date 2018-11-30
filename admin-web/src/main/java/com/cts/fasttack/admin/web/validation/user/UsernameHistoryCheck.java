package com.cts.fasttack.admin.web.validation.user;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Annotation to check username in history
 * @author Anton Leliuk
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameHistoryValidator.class)
public @interface UsernameHistoryCheck {

    String message() default "{users.username.history.exist.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
