package com.cts.fasttack.mdes.server.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.ActivationCodeJmsMessage;
import com.cts.fasttack.jms.dto.CommonMdesJmsResponseDto;
import com.cts.fasttack.jms.dto.NotifyServiceJmsMessage;
import com.cts.fasttack.jms.dto.NotifyTokenUpdatedJmsMessage;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import com.cts.fasttack.logging.service.CallingContext;
import com.cts.fasttack.mdes.server.converter.DeliverActivationCodeRequestDtoToJmsDtoConverter;
import com.cts.fasttack.mdes.server.converter.NotifyServiceActivatedRequestDtoToJmsDtoConverter;
import com.cts.fasttack.mdes.server.converter.NotifyTokenUpdatedRequestDtoToJmsDtoConverter;
import com.cts.fasttack.mdes.server.dto.CommonMdesResponseDto;
import com.cts.fasttack.mdes.server.dto.DeliverActivationCodeRequestDto;
import com.cts.fasttack.mdes.server.dto.NotifyServiceActivatedRequestDto;
import com.cts.fasttack.mdes.server.dto.NotifyTokenUpdatedRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author a.lipavets
 */
@RestController
public class MdesRestController extends AbstractMdesRestController {

    private Logger logger = LogManager.getLogger(MdesRestController.class);

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private NotifyServiceActivatedRequestDtoToJmsDtoConverter notifyServiceActivareRequestDtoToJmsDtoConverter;

    @Autowired
    private DeliverActivationCodeRequestDtoToJmsDtoConverter deliverActivationCodeRequestDtoToJmsDtoConverter;

    @Autowired
    private NotifyTokenUpdatedRequestDtoToJmsDtoConverter notifyTokenUpdatedRequestDtoToJmsDtoConverter;

    @PostMapping("/deliverActivationCode")
    @ResponseBody
    @MessageHistoryOperation(connectorClient = "MDES", rawIn = "#requestDto", errorCode = "#result.errorCode",
            maskedPan = "#result != null ? #result.maskedPan : null",
            panInternalId = "#result != null ? #result.panInternalId : null",
            panInternalGuid = "#result != null ? #result.panInternalGuid : null",
            tokenId = "#requestDto != null ? #requestDto.tokenUniqueReference : null")
    public ResponseEntity<CommonMdesResponseDto> deliverActivationCode(@Validated @RequestBody DeliverActivationCodeRequestDto requestDto) throws ServiceException {
        return processRequest(requestDto, new CommonMdesResponseDto(), response -> {
            HeadersJmsMessage jmsMessage = new ActivationCodeJmsMessage()
                    .deliverActivationDto(deliverActivationCodeRequestDtoToJmsDtoConverter.convert(requestDto))
                    .originator(callingContext.getOriginator());

            CommonMdesJmsResponseDto cmjResponse = integrationBus.inOut(callingContext.getProcessingArea(), "deliverActivationCode", jmsMessage, CommonMdesJmsResponseDto.class);
            response.setMaskedPan(cmjResponse.getMaskedPan());
            response.setPanSource(cmjResponse.getPanSource());
            response.setPanInternalGuid(cmjResponse.getPanInternalGuid());
            response.setPanInternalId(cmjResponse.getPanInternalId());
        });
    }

    @PostMapping("/notifyServiceActivated")
    @ResponseBody
    @MessageHistoryOperation(connectorClient = "MDES", rawIn = "#requestDto", errorCode = "#result.errorCode",
            maskedPan = "#result != null ? #result.maskedPan : null",
            panSource = "#result != null ? #result.panSource : null",
            panInternalId = "#result != null ? #result.panInternalId : null",
            panInternalGuid = "#result != null ? #result.panInternalGuid : null",
            tokenId = "#requestDto != null && #requestDto.cardAndToken != null ? #requestDto.cardAndToken.tokenUniqueReference : null")
    public ResponseEntity<CommonMdesResponseDto> notifyServiceActivated(@Validated @RequestBody NotifyServiceActivatedRequestDto requestDto) throws ServiceException {
        return processRequest(requestDto, new CommonMdesResponseDto(), response -> {
            HeadersJmsMessage jmsMessage = new NotifyServiceJmsMessage()
                    .notifyServiceDto(notifyServiceActivareRequestDtoToJmsDtoConverter.convert(requestDto))
                    .originator(callingContext.getOriginator());

            CommonMdesJmsResponseDto cmjResponse = integrationBus.inOut(callingContext.getProcessingArea(), "notifyServiceActivated", jmsMessage, CommonMdesJmsResponseDto.class);
            response.setMaskedPan(cmjResponse.getMaskedPan());
            response.setPanSource(cmjResponse.getPanSource());
            response.setPanInternalGuid(cmjResponse.getPanInternalGuid());
            response.setPanInternalId(cmjResponse.getPanInternalId());
        });
    }

    @PostMapping("/notifyTokenUpdated")
    @ResponseBody
    @MessageHistoryOperation(connectorClient = "MDES", rawIn = "#requestDto", errorCode = "#result.errorCode",
            maskedPan = "#result != null ? #result.maskedPan : null",
            panSource = "#result != null ? #result.panSource : null",
            panInternalId = "#result != null ? #result.panInternalId : null",
            panInternalGuid = "#result != null ? #result.panInternalGuid : null"
    )
    public ResponseEntity<CommonMdesResponseDto> notifyTokenUpdated(@Validated @RequestBody NotifyTokenUpdatedRequestDto requestDto) throws ServiceException {
        return processRequest(requestDto, new CommonMdesResponseDto(), response -> {
            HeadersJmsMessage jmsMessage = new NotifyTokenUpdatedJmsMessage()
                    .notifyTokenUpdatedDto(notifyTokenUpdatedRequestDtoToJmsDtoConverter.convert(requestDto))
                    .originator(callingContext.getOriginator());

            CommonMdesJmsResponseDto cmjResponse = integrationBus.inOut(callingContext.getProcessingArea(), "notifyTokenUpdated", jmsMessage, CommonMdesJmsResponseDto.class);
            response.setMaskedPan(cmjResponse.getMaskedPan());
            response.setPanInternalId(cmjResponse.getPanInternalId());
            response.setPanInternalGuid(cmjResponse.getPanInternalGuid());
            response.setPanSource(cmjResponse.getPanSource());

        });
    }

}
