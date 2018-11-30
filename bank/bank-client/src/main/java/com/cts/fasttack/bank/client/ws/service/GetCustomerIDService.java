package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDMessageDto;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDResponseDto;

/**
 * Interface for getting customer ID service.
 *
 * @author v.semerkov
 */
public interface GetCustomerIDService {

    JmsGetCustomerIDResponseDto getCustomerID(JmsGetCustomerIDMessageDto request) throws ServiceException;
}
