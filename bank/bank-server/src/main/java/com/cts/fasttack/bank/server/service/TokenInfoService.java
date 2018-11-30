package com.cts.fasttack.bank.server.service;

import com.cts.fasttack.bank.server.dto.TokenInfoRequestDto;
import com.cts.fasttack.bank.server.dto.TokenInfoResponseDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsTokenInfoResponseDto;

public interface TokenInfoService {

    JmsTokenInfoResponseDto tokenInfo(TokenInfoRequestDto request, TokenInfoResponseDto response) throws ServiceException;

}
