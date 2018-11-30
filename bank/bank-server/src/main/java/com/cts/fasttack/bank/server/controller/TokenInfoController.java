package com.cts.fasttack.bank.server.controller;

import com.cts.fasttack.bank.server.service.TokenInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cts.fasttack.bank.server.converter.JmsTokenInfoResponseDtoToTokenInfoResponseDtoConverter;
import com.cts.fasttack.bank.server.dto.TokenInfoRequestDto;
import com.cts.fasttack.bank.server.dto.TokenInfoResponseDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsTokenInfoResponseDto;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;

/**
 * Controller for getting token info.
 *
 * @author v.semerkov
 */
@RestController
public class TokenInfoController extends AbstractBankRestController {

    @Autowired
    private JmsTokenInfoResponseDtoToTokenInfoResponseDtoConverter jmsTokenInfoResponseDtoToTokenInfoResponseDtoConverter;

    @Autowired
    private TokenInfoService tokenInfoService;

    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request",
            tokenId = "#request != null ? #request.tokenRefId : null")
    @PostMapping("/tokenInfo")
    public TokenInfoResponseDto tokenInfo(@Validated @RequestBody TokenInfoRequestDto request) throws ServiceException {
        return processRequest(request, new TokenInfoResponseDto(), response -> {
            JmsTokenInfoResponseDto jmsTokenInfoResponseDto = tokenInfoService.tokenInfo(request, response);

            jmsTokenInfoResponseDtoToTokenInfoResponseDtoConverter.convert(jmsTokenInfoResponseDto, response);
        });
    }
}
