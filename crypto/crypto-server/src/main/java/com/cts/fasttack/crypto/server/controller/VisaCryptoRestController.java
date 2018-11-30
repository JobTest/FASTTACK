package com.cts.fasttack.crypto.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.converter.TripleDESEncryptionResultDtoToResponseDtoConverter;
import com.cts.fasttack.crypto.client.dto.CryptoRequestDto;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import com.cts.fasttack.crypto.client.dto.DecryptWithTripleDESCryptoRequestDto;
import com.cts.fasttack.crypto.client.dto.EncryptWithTripleDESCryptoResponseDto;
import com.cts.fasttack.crypto.client.dto.VisaCryptoResponseDto;
import com.cts.fasttack.crypto.server.service.VisaCryptoService;

/**
 * @author Dmitry Koval
 */
@RestController
@RequestMapping("/secured/crypto/visa")
public class VisaCryptoRestController {

    @Autowired
    private VisaCryptoService visaCryptoService;

    @Autowired
    private TripleDESEncryptionResultDtoToResponseDtoConverter tripleDESEncryptionResultDtoToResponseDtoConverter;

    @PostMapping("/decrypt")
    @ResponseBody
    public CryptoResponseDto decrypt(@RequestBody CryptoRequestDto request) {
        return new CryptoResponseDto(visaCryptoService.decrypt(request.getText()));
    }

    @PostMapping("/decryptWith3desAlgorithm")
    public @ResponseBody VisaCryptoResponseDto decryptWith3desAlgorithm(@RequestBody DecryptWithTripleDESCryptoRequestDto request) throws ServiceException {
        return new VisaCryptoResponseDto(visaCryptoService.decryptWith3desAlgorithm(request.getEncryptedData(), request.getEncryptionKeyIndex()));
    }

    @PostMapping("/encryptWith3desAlgorithm")
    public @ResponseBody EncryptWithTripleDESCryptoResponseDto encryptWith3desAlgorithm(@RequestBody CryptoRequestDto request) throws ServiceException {
        return tripleDESEncryptionResultDtoToResponseDtoConverter.convert(visaCryptoService.encryptWith3desAlgorithm(request.getText()));
    }
}
