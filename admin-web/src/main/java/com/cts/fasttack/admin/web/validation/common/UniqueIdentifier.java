package com.cts.fasttack.admin.web.validation.common;

import java.io.Serializable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import com.cts.fasttack.common.core.service.ExistCheckService;

/**
 * Annotation for check that entity is unique
 *
 * @author n.bizin
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueIdentifierValidator.class)
@Documented
public @interface UniqueIdentifier {

    String message() default "{not.unique.entity}";

    Class<? extends ExistCheckService<? extends Serializable>> service();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
