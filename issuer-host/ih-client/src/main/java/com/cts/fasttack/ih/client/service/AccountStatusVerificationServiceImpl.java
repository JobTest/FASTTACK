package com.cts.fasttack.ih.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.ih.client.converter.CardStatusVerificationJmsMessageToECommerceConnectConverter;
import com.cts.fasttack.ih.client.converter.ECommerceConnectToCardStatusVerificationResponseDtoConverter;
import com.cts.fasttack.ih.client.dto.ECommerceConnect;
import com.cts.fasttack.ih.client.rest.IssuerHostRestClient;
import com.cts.fasttack.jms.dto.CardStatusVerificationJmsMessage;
import com.cts.fasttack.jms.dto.JmsCardStatusVerificationResponseDto;

/**
 * @author Anton Leliuk
 */
@Service
public class AccountStatusVerificationServiceImpl implements AccountStatusVerificationService {

    @Autowired
    private IssuerHostRestClient restClient;

    @Autowired
    private CardStatusVerificationJmsMessageToECommerceConnectConverter cardStatusVerificationJmsMessageToECommerceConnectConverter;

    @Autowired
    private ECommerceConnectToCardStatusVerificationResponseDtoConverter eCommerceConnectToCardStatusVerificationResponseDtoConverter;

    @Override
    public JmsCardStatusVerificationResponseDto verify(CardStatusVerificationJmsMessage cardStatusVerificationJmsMessage) throws ServiceException {
        ECommerceConnect response = restClient.accountStatusVerification(cardStatusVerificationJmsMessageToECommerceConnectConverter.convert(cardStatusVerificationJmsMessage));
        return eCommerceConnectToCardStatusVerificationResponseDtoConverter.convert(response);
    }

}
