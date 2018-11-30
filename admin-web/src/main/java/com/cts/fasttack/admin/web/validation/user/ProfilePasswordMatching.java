package com.cts.fasttack.admin.web.validation.user;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProfilePasswordNotMatchValidator.class)
@Documented
public @interface ProfilePasswordMatching {

    String message() default "{profile.password.not.match}";

    Class<?> [] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
