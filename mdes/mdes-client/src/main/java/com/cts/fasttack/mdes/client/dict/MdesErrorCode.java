package com.cts.fasttack.mdes.client.dict;

import org.springframework.http.HttpStatus;
import com.cts.fasttack.common.core.exception.ErrorCode;

/**
 * Error codes from MDES
 *
 * @author Anton Leliuk
 */
public enum MdesErrorCode implements ErrorCode {

    MDES_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE),
    NOT_SUPPORTED(HttpStatus.BAD_REQUEST),
    EMPTY_RESULT(HttpStatus.BAD_REQUEST),
    INVALID_TOKEN_STATUS(HttpStatus.BAD_REQUEST),
    INVALID_WORKFLOW(HttpStatus.BAD_REQUEST),
    INVALID_CONDITIONAL_FIELD(HttpStatus.BAD_REQUEST),
    INVALID_FIELD_FORMAT(HttpStatus.BAD_REQUEST),
    INVALID_FIELD_LENGTH(HttpStatus.BAD_REQUEST),
    INVALID_FIELD_VALUE(HttpStatus.BAD_REQUEST),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST),
    MISSING_CONDITIONAL_FIELD(HttpStatus.BAD_REQUEST),
    MISSING_REQUIRED_FIELD(HttpStatus.BAD_REQUEST),
    INTERNAL_SERVICE_FAILURE(HttpStatus.INTERNAL_SERVER_ERROR),
    MISSING_REQUIRED_INPUT(HttpStatus.BAD_REQUEST),
    INVALID_DATA(HttpStatus.BAD_REQUEST);

    private HttpStatus httpStatus;

    MdesErrorCode(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public static MdesErrorCode getInstance(String errorCode) {
        for (MdesErrorCode code : values()) {
            if (code.name().equals(errorCode)) {
                return code;
            }
        }
        return MDES_UNAVAILABLE;
    }

}
