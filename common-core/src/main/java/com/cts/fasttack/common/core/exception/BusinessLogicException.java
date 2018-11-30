package com.cts.fasttack.common.core.exception;

import org.springframework.http.HttpStatus;

/**
 * Generic RuntimeException with HttpStatus
 *
 * @author v.murahovsky
 */
public class BusinessLogicException extends RuntimeException {

	private static final long serialVersionUID = -1443657122786915458L;

	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public BusinessLogicException() {
        super("error.serverSideError");
    }

    public BusinessLogicException(String message) {
        super(message);
    }

    public BusinessLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessLogicException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public BusinessLogicException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
