package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerRequestDto;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerResponseDto;

public interface SendNotificationToCustomerService {

    JmsSendNotificationToCustomerResponseDto sendNotificationToCustomer(JmsSendNotificationToCustomerRequestDto requestDto) throws ServiceException;
}
