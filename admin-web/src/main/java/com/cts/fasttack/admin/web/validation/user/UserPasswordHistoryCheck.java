package com.cts.fasttack.admin.web.validation.user;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Annotation for check {@code UserDao#existPasswordHistory(String, String)}
 *
 * @author n.bizin
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserPasswordHistoryValidator.class)
@Documented
public @interface UserPasswordHistoryCheck {

    String message() default "{users.password.history.exist.message}";

    Class<?> [] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
