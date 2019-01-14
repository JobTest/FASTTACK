package com.cts.fasttack.bank.server.controller;

import com.cts.fasttack.bank.server.service.TokenInfoService;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.Path.Node;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cts.fasttack.bank.server.converter.JmsTokenInfoResponseDtoToTokenInfoResponseDtoConverter;
import com.cts.fasttack.bank.server.dict.BankErrorCodes;
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

    @Autowired
    private Validator validator;

    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request", panInternalId = "#request != null ? #request.panInternalId : null",
            panInternalGuid = "#request != null ? #request.panInternalGUID : null", maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#request.pan)", errorCode = "!(\"0\").equals(#result.code) ? #result.code : null",
            tokenId = "#request != null ? #request.tokenRefId : null")
    @PostMapping("/tokenInfo")
    public TokenInfoResponseDto tokenInfo(@RequestBody TokenInfoRequestDto request) throws ServiceException {
        return processRequest(request, new TokenInfoResponseDto(), response -> {
            Set<ConstraintViolation<TokenInfoRequestDto>> violations = validator.validate(request);

            if (!violations.isEmpty()) {
                ConstraintViolation<TokenInfoRequestDto> violation = violations.iterator().next();

                String fieldName = null;

                for (Node node : violation.getPropertyPath()) {
                    fieldName = node.getName();
                }

                setResponseErrorAttributes(response, violation.getMessage(), BankErrorCodes.INVALID_INPUT.getCode(), fieldName);
            } else {
                JmsTokenInfoResponseDto jmsTokenInfoResponseDto = tokenInfoService.tokenInfo(request, response);

                jmsTokenInfoResponseDtoToTokenInfoResponseDtoConverter.convert(jmsTokenInfoResponseDto, response);
            }
        });
    }
}
