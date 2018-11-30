package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsSearchContragent2Dto;
import com.cts.fasttack.jms.dto.JmsSearchContragent2ResponseDto;

/**
 * @author a.lipavets
 */
public interface SearchContragent2WebService {

    /**
     * Search contragents
     *
     * @throws ServiceException
     */
    JmsSearchContragent2ResponseDto searchContragent2(JmsSearchContragent2Dto request) throws ServiceException;
}
