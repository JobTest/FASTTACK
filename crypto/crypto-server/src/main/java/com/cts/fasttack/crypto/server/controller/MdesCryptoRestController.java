package com.cts.fasttack.crypto.server.controller;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import com.cts.fasttack.crypto.client.dto.MdesCryptoRequestDto;
import com.cts.fasttack.crypto.server.service.MdesCryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author a.lipavets
 */
@RestController
@RequestMapping("/secured/crypto/mdes")
public class MdesCryptoRestController {

    @Autowired
    private MdesCryptoService mdesCryptoService;

    @PostMapping("/decryptCardAndTokenData")
    public @ResponseBody CryptoResponseDto decryptCardAndTokenData(@RequestBody MdesCryptoRequestDto request) throws ServiceException {
        return new CryptoResponseDto(mdesCryptoService.decryptWithMdesCustomerPriv(request.getEncryptedData(),
                request.getPublicKeyFingerprint(), request.getOaepAlgorithm(), request.getEncryptedKey(), request.getIv()));
    }
}
