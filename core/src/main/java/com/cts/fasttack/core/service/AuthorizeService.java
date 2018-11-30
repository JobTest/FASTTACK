package com.cts.fasttack.core.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsAuthorizeServiceDto;
import com.cts.fasttack.jms.dto.JmsAuthorizeServiceResponseDto;

/**
 * @author a.lipavets
 */
public interface AuthorizeService {

    String AUTHORIZE = "AUTHORIZE";
    /**
     * Authorizing for MDES
     *
     * @param authorizeServiceDto - request from MDES
     * @throws ServiceException
     */
    JmsAuthorizeServiceResponseDto authorize(JmsAuthorizeServiceDto authorizeServiceDto, Long messageHistoryId) throws ServiceException;
}
