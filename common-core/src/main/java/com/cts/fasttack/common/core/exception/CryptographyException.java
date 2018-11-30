package com.cts.fasttack.common.core.exception;

import org.springframework.http.HttpStatus;

/**
 * Ошибка криптографии.
 * Наследуется от RuntimeException для того чтобы происходил автоматический откат транзакции при возникновении такого вида исключения.
 */
public class CryptographyException extends RuntimeException implements ServiceError{

	private static final long serialVersionUID = 1067398173369704068L;

	public CryptographyException(){
        super();
    }

    public CryptographyException(String message) {
        super(message);
    }

    public CryptographyException(Throwable throwable){
        super(throwable);
    }

    public CryptographyException(String message, Throwable throwable) {
        super(message, throwable);
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "errorCode='" + getErrorCode() + "}";
    }

    @Override
    public ErrorCode getErrorCode() {
        return StandardErrorCodes.CRYPTOGRAPHY_ERROR;
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
        return HttpStatus.OK;
    }
}
