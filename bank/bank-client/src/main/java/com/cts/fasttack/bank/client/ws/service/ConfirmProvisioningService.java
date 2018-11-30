package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.bank.client.ws.client.ConfirmProvisioning;
import com.cts.fasttack.bank.client.ws.client.ConfirmProvisioningResponse;
import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * @author Dmitry Koval
 */
public interface ConfirmProvisioningService {

    ConfirmProvisioningResponse confirmProvisioning(ConfirmProvisioning requestDto) throws ServiceException;
}
