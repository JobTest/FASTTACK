package com.cts.fasttack.common.core.exception;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

/**
 * Ошибка вызова сервиса
 */
public class ServiceException extends Exception implements ServiceError {

	private static final long serialVersionUID = 8992696730815714274L;

	private ErrorCode errorCode;
    private Object[] params;
    private String errorDescription;
    private HttpStatus httpStatus = HttpStatus.OK;

    public ServiceException(ErrorCode errorCode, Object ... params) {
        this.errorCode = errorCode;
        this.params = params;
    }

    public ServiceException(ErrorCode errorCode, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public ServiceException(ErrorCode errorCode, HttpStatus httpStatus, Object ... params) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.params = params;
    }

    public static ServiceException withDescription(ErrorCode errorCode, String errorDescription) {
        ServiceException ex = new ServiceException(errorCode);
        ex.errorDescription = errorDescription;
        return ex;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("errorCode", errorCode)
                .append("params", params)
                .append("errorDescription", errorDescription)
                .toString();
    }

    @Override
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public Object[] getParams() {
        return params;
    }

    @Override
    public String getErrorDescription() {
        return errorDescription;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (message != null) {
            return message;
        }
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(errorCode.name());
        if(ArrayUtils.isNotEmpty(params)){
            builder.append(params);
        }
        return builder.append(errorDescription).toString();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
