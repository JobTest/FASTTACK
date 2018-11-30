package com.cts.fasttack.crypto.server.controller;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dto.CreateOpaqueCardCryptoRequest;
import com.cts.fasttack.crypto.client.dto.CreateOpaqueCardCryptoResponse;
import com.cts.fasttack.crypto.server.service.PushProvisioningCryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anton Leliuk
 */
@RestController
@RequestMapping("/secured/crypto/bank")
public class CreateOpaqueCardController {

    @Autowired
    private PushProvisioningCryptoService pushProvisioningCryptoService;

    @PostMapping("/createOpaqueCard")
    public CreateOpaqueCardCryptoResponse createOpaqueCard(@RequestBody CreateOpaqueCardCryptoRequest request) throws ServiceException {
        CreateOpaqueCardCryptoResponse response = new CreateOpaqueCardCryptoResponse();
        response.setOpaqueBody(pushProvisioningCryptoService.encryptOpaqueBody(
                request.getPublicKeyFingerprint(),
                request.getTavKeyFingerprint(),
                request.getOaepHashingAlgorithm(),
                request.getAccountNumber(),
                request.getExpiryMonth(),
                request.getExpiryYear(),
                request.getCardholderName()));
        return response;
    }
}
