package com.cts.fasttack.bank.client.rest.client;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsCardTokenizedRequestDto;
import com.cts.fasttack.jms.dto.JmsCardTokenizedResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenStatusUpdatedDto;

public interface BankRestClient {

    /**
     * Send token notification status
     */
    JmsCardTokenizedResponseDto cardTokenized(JmsCardTokenizedRequestDto request) throws ServiceException;

    /**
     * Send token status updated
     */
    void tokenStatusUpdated(JmsTokenStatusUpdatedDto request) throws ServiceException;
}
