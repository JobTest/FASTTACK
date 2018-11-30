package com.cts.fasttack.ih.client.exception;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.ResourceAccessException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.exception.handler.ServiceExceptionHandler;

/**
 * Exception handler for issuer host client.
 *
 * @author v.semerkov
 */
public class IssuerHostServiceExceptionHandler extends ServiceExceptionHandler {

    public static final ServiceExceptionHandler INSTANCE = new IssuerHostServiceExceptionHandler();

    protected final Logger log = LogManager.getLogger(getClass());

    @Override
    public <RESPONSE> RESPONSE handle(Exception e) throws ServiceException {
        log.error("Error calling client external service", e);
        if (e instanceof ResourceAccessException) {
            ResourceAccessException resEx = (ResourceAccessException) e;
            if (resEx.getRootCause() instanceof ConnectException || resEx.getRootCause() instanceof SocketTimeoutException) {
                throw new ServiceException(StandardErrorCodes.HOST_TIMEOUT);
            }
            throw new ServiceException(StandardErrorCodes.HOST_NOT_AVAILABLE);
        }
        throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
    }
}
