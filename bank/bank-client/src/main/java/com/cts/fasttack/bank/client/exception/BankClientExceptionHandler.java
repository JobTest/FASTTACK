package com.cts.fasttack.bank.client.exception;

import java.net.SocketTimeoutException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.exception.handler.ServiceExceptionHandler;

/**
 * Rest exception handler for Bank Client services
 *
 * @author n.bizin
 */
public class BankClientExceptionHandler extends ServiceExceptionHandler {

    public static final BankClientExceptionHandler INSTANCE = new BankClientExceptionHandler();

    @Override
    public <RESPONSE> RESPONSE handle(Exception e) throws ServiceException {
        String message = ExceptionUtils.getMessage(e);

        log.error("Error calling Bank Client service: " + message, e);

        if (e instanceof HttpStatusCodeException) {
            throw new ServiceException(StandardErrorCodes.HOST_NOT_AVAILABLE, ((HttpStatusCodeException) e).getStatusCode().value(), message);
        }

        if (e instanceof ResourceAccessException && ((ResourceAccessException) e).getRootCause() instanceof SocketTimeoutException) {
            throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE, HttpStatus.REQUEST_TIMEOUT.value(), message);
        }

        throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }
}
