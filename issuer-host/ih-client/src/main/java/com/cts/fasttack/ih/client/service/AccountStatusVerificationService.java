package com.cts.fasttack.ih.client.service;

import com.cts.fasttack.jms.dto.JmsCardStatusVerificationResponseDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.CardStatusVerificationJmsMessage;

/**
 * @author Anton Leliuk
 */
public interface AccountStatusVerificationService {

    /**
     * Verifies card status.
     */
    JmsCardStatusVerificationResponseDto verify(CardStatusVerificationJmsMessage cardStatusVerificationJmsMessage) throws ServiceException;

}
