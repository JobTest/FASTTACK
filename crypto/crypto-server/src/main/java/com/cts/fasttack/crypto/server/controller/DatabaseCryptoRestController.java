package com.cts.fasttack.crypto.server.controller;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dto.CryptoRequestDto;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import com.cts.fasttack.crypto.server.service.DatabaseCryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * For process call encryption data in database
 *
 * @author Dmitry Koval
 */
@RestController
@RequestMapping("/secured/crypto/database")
public class DatabaseCryptoRestController {

    @Autowired
    private DatabaseCryptoService databaseCryptoService;

    @PostMapping("/encrypt")
    public @ResponseBody CryptoResponseDto encrypt(@RequestBody CryptoRequestDto request) throws ServiceException {
        return new CryptoResponseDto(databaseCryptoService.encrypt(request.getText()));
    }

    @PostMapping("/decrypt")
    public @ResponseBody CryptoResponseDto decrypt(@RequestBody CryptoRequestDto request) throws ServiceException {
        return new CryptoResponseDto(databaseCryptoService.decrypt(request.getText()));
    }
}
