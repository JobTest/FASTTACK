package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortMessageDto;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortResponseDto;

/**
 * Interface for getting card info service.
 *
 * @author v.semerkov
 */
public interface GetCardInfoShortService {

    JmsGetCardInfoShortResponseDto getCardInfoShort(JmsGetCardInfoShortMessageDto request) throws ServiceException;
}
