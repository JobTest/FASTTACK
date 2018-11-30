package com.cts.fasttack.common.core.exception.handler;

import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * @author Anton Leliuk
 */
public interface ExceptionHandler {

    <RESPONSE> RESPONSE handle(Exception e) throws ServiceException;
}
