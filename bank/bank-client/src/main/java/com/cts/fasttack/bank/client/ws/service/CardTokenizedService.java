package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.bank.client.ws.client.CardTokenized;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsCardTokenizedResponseDto;

public interface CardTokenizedService {

    JmsCardTokenizedResponseDto cardTokenized(CardTokenized requestDto) throws ServiceException;
}
