package com.cts.fasttack.bank.server.service;

import com.cts.fasttack.bank.server.dto.CardDataUpdateRequestDto;
import com.cts.fasttack.bank.server.dto.CardDataUpdateResponseDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsCardDataUpdateResponseDto;

public interface CardDataUpdateService {

    JmsCardDataUpdateResponseDto cardDataUpdate(CardDataUpdateRequestDto request, CardDataUpdateResponseDto response) throws ServiceException;

}
