package com.cts.fasttack.bank.client.jms.processor;

import java.util.concurrent.CompletableFuture;

import com.cts.fasttack.bank.client.converter.CardTokenizedResponseToTokenCreateNotificationResponseConverter;
import com.cts.fasttack.bank.client.converter.TokenCreateNotificationJmsMessageToCardTokenizedDtoConverter;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.CardTokenizedJmsMessage;
import com.cts.fasttack.jms.dto.GetCardInfoShortJmsMessage;
import com.cts.fasttack.jms.dto.GetCustomerIDJmsMessage;
import com.cts.fasttack.jms.dto.JmsCardTokenizedResponseDto;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortMessageDto;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortResponseDto;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDMessageDto;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenCreateNotificationDto;
import com.cts.fasttack.jms.dto.JmsTokenCreateNotificationResponseDto;
import com.cts.fasttack.jms.dto.TokenCreateNotificationJmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.service.CallingContext;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenCreateNotificationBankProcessor extends AbstractCamelProcessor<TokenCreateNotificationJmsMessage, JmsTokenCreateNotificationResponseDto> {

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private TokenCreateNotificationJmsMessageToCardTokenizedDtoConverter tokenCreateNotificationJmsMessageToCardTokenizedDtoConverter;

    @Autowired
    private CardTokenizedResponseToTokenCreateNotificationResponseConverter cardTokenizedResponseToTokenCreateNotificationResponseConverter;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, TokenCreateNotificationJmsMessage.class, request -> {
            JmsTokenCreateNotificationDto createNotificationDto = request.getJmsTokenCreateNotificationDto();

            Boolean cardTokenized = request.isCardTokenized();
            if (cardTokenized != null && cardTokenized) {
                JmsCardTokenizedResponseDto res = integrationBus.inOut(() -> callingContext.getOriginator(), "cardTokenized",
                        new CardTokenizedJmsMessage().jmsCardTokenizedDto(tokenCreateNotificationJmsMessageToCardTokenizedDtoConverter.convert(request)).originator(callingContext.getOriginator()), JmsCardTokenizedResponseDto.class);
                return cardTokenizedResponseToTokenCreateNotificationResponseConverter.convert(res);
            } else {
                log.info("Start working Get Card Info Short and Get Customer Identifier");
                String originator = callingContext.getOriginator();

                JmsTokenCreateNotificationResponseDto responseDto = new JmsTokenCreateNotificationResponseDto();

                try {
                    CompletableFuture.supplyAsync(() -> {
                        getCardInfoShort(responseDto, createNotificationDto, originator, request.getMessageHistoryId());
                        return null;
                    }).thenApplyAsync(s -> {
                        getCustomerIdentifier(responseDto, createNotificationDto, originator, request.getMessageHistoryId());
                        return null;
                    }).get();
                } catch (Exception e) {
                    log.error("Error while async process confirmProvisioning and verifyCardStatus", e);
                    throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
                }
                log.info("Finish working Get Card Info Short and Get Customer Identifier");
                return responseDto;
            }
        });
    }

    private void getCardInfoShort(JmsTokenCreateNotificationResponseDto responseDto, JmsTokenCreateNotificationDto createNotificationDto, String originator, Long messageHistoryId) {
        try {
            JmsGetCardInfoShortMessageDto jmsGetCardInfoShortMessageDto = new JmsGetCardInfoShortMessageDto();
            jmsGetCardInfoShortMessageDto.setPan(createNotificationDto.getEncryptedData().getCardholderInfo().getPrimaryAccountNumber());

            HeadersJmsMessage getCardInfoShortJmsMessage = new GetCardInfoShortJmsMessage()
                    .cardInfoShortMessageDto(jmsGetCardInfoShortMessageDto)
                    .originator(originator).messageHistoryId(messageHistoryId);
            JmsGetCardInfoShortResponseDto jmsGetCardInfoShortResponseDto = integrationBus.inOut(getCardInfoShortJmsMessage::getOriginator, "getCardInfoShort", getCardInfoShortJmsMessage, JmsGetCardInfoShortResponseDto.class);

            responseDto.setPanInternalId(jmsGetCardInfoShortResponseDto.getCardID());
            responseDto.setPanInternalGUID(jmsGetCardInfoShortResponseDto.getCardGUID());
            responseDto.setCustomerPhone(jmsGetCardInfoShortResponseDto.getPhoneNumber());
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    private void getCustomerIdentifier(JmsTokenCreateNotificationResponseDto responseDto, JmsTokenCreateNotificationDto createNotificationDto, String originator, Long messageHistoryId) {
        try {
            JmsGetCustomerIDMessageDto getCustomerIDMessageDto = new JmsGetCustomerIDMessageDto();
            getCustomerIDMessageDto.setCardNum(createNotificationDto.getEncryptedData().getCardholderInfo().getPrimaryAccountNumber());

            HeadersJmsMessage getCustomerIDJmsMessage = new GetCustomerIDJmsMessage()
                    .getCustomerIdentifier(getCustomerIDMessageDto)
                    .originator(originator).messageHistoryId(messageHistoryId);
            JmsGetCustomerIDResponseDto jmsGetCustomerIDResponseDto = integrationBus.inOut(getCustomerIDJmsMessage::getOriginator, "customerIdentifier", getCustomerIDJmsMessage, JmsGetCustomerIDResponseDto.class);

            responseDto.setCustomerId(jmsGetCustomerIDResponseDto.getCustomerID());
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}
