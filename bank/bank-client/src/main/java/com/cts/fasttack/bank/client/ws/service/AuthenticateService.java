package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsAuthenticateRequestDto;
import com.cts.fasttack.jms.dto.JmsAuthenticateResponseDto;

public interface AuthenticateService {

    JmsAuthenticateResponseDto authenticate(JmsAuthenticateRequestDto requestDto) throws ServiceException;
}
