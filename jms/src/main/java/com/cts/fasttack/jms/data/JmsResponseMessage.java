package com.cts.fasttack.jms.data;

import com.cts.fasttack.common.core.exception.SimpleErrorCode;
import org.springframework.http.HttpStatus;

/**
 * JMS response message which contains error or result object.
 * It needed for wrap exception if it happened in processor
 * @author Anton Leliuk
 */
public class JmsResponseMessage<T> {

    private T rawMessage;

    private SimpleErrorCode errorCode;
    private Object[] params;
    private HttpStatus httpStatus = HttpStatus.OK;

    public boolean isError(){
        return errorCode != null;
    }

    public T getRawMessage() {
        return rawMessage;
    }

    public void setRawMessage(T rawMessage) {
        this.rawMessage = rawMessage;
    }

    public SimpleErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(SimpleErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
