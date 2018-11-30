package com.cts.fasttack.crypto.server.controller;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import com.cts.fasttack.crypto.client.dto.TextWithIvAndKeyIndexCryptoRequestDto;
import com.cts.fasttack.crypto.server.service.SmartvistaCryptoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author d.ishchenko
 */
@RestController
@RequestMapping("/secured/crypto/smartvista")
public class SmartvistaCryptoRestController {

    @Autowired
    private SmartvistaCryptoService smartvistaCryptoService;

    @PostMapping("/encrypt")
    public @ResponseBody CryptoResponseDto encrypt(@RequestBody TextWithIvAndKeyIndexCryptoRequestDto request) throws ServiceException {
        return new CryptoResponseDto(smartvistaCryptoService.encrypt(request.getText(), request.getIv(), request.getKeyIndex()));
    }

}
