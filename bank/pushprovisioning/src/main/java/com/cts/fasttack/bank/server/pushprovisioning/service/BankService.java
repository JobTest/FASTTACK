package com.cts.fasttack.bank.server.pushprovisioning.service;

import com.cts.fasttack.bank.server.pushprovisioning.dto.CreateInAppProvisioningDataRequestDto;
import com.cts.fasttack.bank.server.pushprovisioning.dto.CreateOpaquePaymentCardRequestDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dto.CreateInAppProvisioningDataCryptoResponse;
import com.cts.fasttack.crypto.client.dto.CreateOpaqueCardCryptoResponse;

/**
 * @author Anton Leliuk
 * @author d.ishchenko
 */
public interface BankService {

    CreateOpaqueCardCryptoResponse createOpaqueCardBody(CreateOpaquePaymentCardRequestDto request) throws ServiceException;

    CreateInAppProvisioningDataCryptoResponse createInAppProvisioningData(CreateInAppProvisioningDataRequestDto request) throws ServiceException;

}
