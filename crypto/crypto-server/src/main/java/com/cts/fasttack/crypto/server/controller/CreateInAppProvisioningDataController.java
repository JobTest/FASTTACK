package com.cts.fasttack.crypto.server.controller;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dto.CreateInAppProvisioningDataCryptoRequest;
import com.cts.fasttack.crypto.client.dto.CreateInAppProvisioningDataCryptoResponse;
import com.cts.fasttack.crypto.server.service.InAppProvisioningCryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author d.ishchenko
 */
@RestController
@RequestMapping("/secured/crypto/bank")
public class CreateInAppProvisioningDataController {

    @Autowired
    private InAppProvisioningCryptoService inAppProvisioningCryptoService;

    @PostMapping("/createInAppProvisioningData")
    public CreateInAppProvisioningDataCryptoResponse createInAppProvisioningData(@RequestBody CreateInAppProvisioningDataCryptoRequest request) throws ServiceException {
        return inAppProvisioningCryptoService.createInAppProvisioningData(
                request.getAccountNumber(),
                request.getExpiryMonth(),
                request.getExpiryYear(),
                request.getCardholderName(),
                request.getIps(),
                request.getNonce(),
                request.getNonceSignature(),
                request.getCertificates(),
                request.getVisaWsdKeyEncryptionRule(),
                request.getVisaWsdKeyIndex(),
                request.getVisaPaymentDataFormat(),
                request.getVisaPanPrefixLength());
    }

}
