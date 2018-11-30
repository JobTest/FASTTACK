package com.cts.fasttack.crypto.server.controller;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dto.CryptoRequestDto;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import com.cts.fasttack.crypto.server.service.JmsCryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anton Leliuk
 */
@RestController
@RequestMapping("/secured/crypto/jms")
public class JmsCryptoRestController {

    @Autowired
    private JmsCryptoService jmsCryptoService;

    @PostMapping("/encrypt")
    public @ResponseBody CryptoResponseDto encrypt(@RequestBody CryptoRequestDto request) throws ServiceException {
        return new CryptoResponseDto(jmsCryptoService.encrypt(request.getText()));
    }

    @PostMapping("/decrypt")
    public @ResponseBody CryptoResponseDto decrypt(@RequestBody CryptoRequestDto request) throws ServiceException {
        return new CryptoResponseDto(jmsCryptoService.decrypt(request.getText()));
    }
}
