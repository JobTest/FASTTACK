package com.cts.fasttack.crypto.server.exception;

import org.springframework.http.HttpStatus;

import com.cts.fasttack.common.core.exception.ErrorCode;
import com.cts.fasttack.common.core.exception.ServiceError;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;

public class UnexpectedKidException extends RuntimeException implements ServiceError {

	private static final long serialVersionUID = -7046962308141461567L;

    public UnexpectedKidException(){
        super();
    }

    public UnexpectedKidException(String message) {
        super(message);
    }

    public UnexpectedKidException(Throwable throwable){
        super(throwable);
    }

    @Override
    public String toString() {
        return "UnexpectedKidException{" +
                "errorCode='" + getErrorCode() + "}";
    }

    @Override
    public ErrorCode getErrorCode() {
        return StandardErrorCodes.INVALID_FIELD_VALUE;
    }

    @Override
    public Object[] getParams() {
        return new Object[0];
    }

    @Override
    public String getErrorDescription() {
        return null;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (message != null) {
            return message;
        }
        return getErrorCode().name();
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
