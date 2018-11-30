package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.bank.client.ws.client.TokenStatusUpdated;
import com.cts.fasttack.bank.client.ws.client.TokenStatusUpdatedResponse;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.BankJmsResponseDto;

public interface TokenStatusUpdatedService {

    BankJmsResponseDto tokenStatusUpdated(TokenStatusUpdated requestDto) throws ServiceException;
}
