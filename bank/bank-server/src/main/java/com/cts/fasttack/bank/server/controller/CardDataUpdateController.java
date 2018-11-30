package com.cts.fasttack.bank.server.controller;

import com.cts.fasttack.bank.server.converter.JmsCardDataUpdateResponseDtoToCardDataUpdateResponseDtoConverter;
import com.cts.fasttack.bank.server.dto.CardDataUpdateRequestDto;
import com.cts.fasttack.bank.server.dto.CardDataUpdateResponseDto;
import com.cts.fasttack.bank.server.service.CardDataUpdateService;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsCardDataUpdateResponseDto;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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

    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request")
    @PostMapping("/cardDataUpdate")
    public CardDataUpdateResponseDto cardDataUpdate(@Validated @RequestBody CardDataUpdateRequestDto request) throws ServiceException {
        return processRequest(request, new CardDataUpdateResponseDto(), response -> {
            JmsCardDataUpdateResponseDto jmsCardDataUpdateResponseDto = cardDataUpdateService.cardDataUpdate(request, response);

            jmsCardDataUpdateResponseDtoToCardDataUpdateResponseDtoConverter.convert(jmsCardDataUpdateResponseDto, response);
        });
    }
}
