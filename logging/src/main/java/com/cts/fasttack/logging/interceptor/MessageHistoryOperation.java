package com.cts.fasttack.logging.interceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.http.MediaType;

/**
 * Annotation to save message history
 *
 * @author n.bizin
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface MessageHistoryOperation {

    /** Connector client (String) (example: VTS, MDES, Bank, Auth) (default: from CallingContext) */
    String connectorClient() default "";

    /** Message type (String) (example: AUTHENTICATE, VERIFY) (default: by method name of annotated method) */
    String msgType() default "";

    /** Token id (El) (example: #object.tokenId) */
    String tokenId() default "";

    /** Request object (El) (example: #object.someObject) */
    String rawIn();

    /**
     * Response media type
     */
    String responseMediaType() default MediaType.APPLICATION_JSON_VALUE;

    /**
     * Decision
     */
    String decision() default "";

    /**
     * Error code
     */
    String errorCode() default "";

    /**
     * Cvc response
     */
    String cvcResp() default "";

    /**
     * Masked pan
     */
    String maskedPan() default "";

    /**
     * Pan internal id
     */
    String panInternalId() default "";

    /**
     * Pan internal guid
     */
    String panInternalGuid() default "";

    /**
     * Pan source
     */
    String panSource() default "";

    /**
     * Device Type
     */
    String deviceType() default "";
}
