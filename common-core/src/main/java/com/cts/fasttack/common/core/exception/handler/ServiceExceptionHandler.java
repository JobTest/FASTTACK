package com.cts.fasttack.common.core.exception.handler;

import com.cts.fasttack.common.core.exception.CryptographyException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Anton Leliuk
 */
public class ServiceExceptionHandler implements ExceptionHandler {

    public static final ServiceExceptionHandler INSTANCE = new ServiceExceptionHandler();

    protected final Logger log = LogManager.getLogger(getClass());

    @Override
    public <RESPONSE> RESPONSE handle(Exception e) throws ServiceException {
        log.error("Error calling client external service", e);
        if(e instanceof CryptographyException){
            throw ServiceException.withDescription(((CryptographyException) e).getErrorCode(), e.getMessage());
        }
        throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
    }
}
