package com.cts.fasttack.bank.server.controller;

import com.cts.fasttack.bank.server.converter.JmsCardDataUpdateResponseDtoToCardDataUpdateResponseDtoConverter;
import com.cts.fasttack.bank.server.dict.BankErrorCodes;
import com.cts.fasttack.bank.server.dto.CardDataUpdateRequestDto;
import com.cts.fasttack.bank.server.dto.CardDataUpdateResponseDto;
import com.cts.fasttack.bank.server.service.CardDataUpdateService;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsCardDataUpdateResponseDto;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Path.Node;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for getting Card Data Update.
 */
@RestController
public class CardDataUpdateController extends AbstractBankRestController {

    @Autowired
    private JmsCardDataUpdateResponseDtoToCardDataUpdateResponseDtoConverter jmsCardDataUpdateResponseDtoToCardDataUpdateResponseDtoConverter;

    @Autowired
    private CardDataUpdateService cardDataUpdateService;

    @Autowired
    private Validator validator;

    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request", panInternalId = "#request != null ? #request.newPanInternalId : null",
            panInternalGuid = "#request != null ? #request.newPanInternalGUID : null", maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#request.newAccountPan)", errorCode = "!(\"0\").equals(#result.code) ? #result.code : null",
            tokenId = "#request != null ? #request.tokenRefId : null")
    @PostMapping("/cardDataUpdate")
    public CardDataUpdateResponseDto cardDataUpdate(@RequestBody(required = false) CardDataUpdateRequestDto request) throws ServiceException {
        return processRequest(request, new CardDataUpdateResponseDto(), response -> {
            Set<ConstraintViolation<CardDataUpdateRequestDto>> violations = validator.validate(request);

            if (!violations.isEmpty()) {
                ConstraintViolation<CardDataUpdateRequestDto> violation = violations.iterator().next();

                String fieldName = null;

                for (Node node : violation.getPropertyPath()) {
                    fieldName = node.getName();
                }

                setResponseErrorAttributes(response, violation.getMessage(), BankErrorCodes.INVALID_INPUT.getCode(), fieldName);
            } else {
                JmsCardDataUpdateResponseDto jmsCardDataUpdateResponseDto = cardDataUpdateService.cardDataUpdate(request, response);

                jmsCardDataUpdateResponseDtoToCardDataUpdateResponseDtoConverter.convert(jmsCardDataUpdateResponseDto, response);
            }
        });
    }
}
