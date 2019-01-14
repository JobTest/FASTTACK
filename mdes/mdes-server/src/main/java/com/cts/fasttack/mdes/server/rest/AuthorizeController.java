package com.cts.fasttack.mdes.server.rest;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.messages.MessageSourceService;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.AuthorizeServiceJmsMessage;
import com.cts.fasttack.jms.dto.JmsAuthorizeServiceResponseDto;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import com.cts.fasttack.logging.service.CallingContext;
import com.cts.fasttack.mdes.server.converter.AuthorizeServiceRequestDtoToJmsDtoConverter;
import com.cts.fasttack.mdes.server.converter.JmsAuthorizeServiceResponseToResponseDtoConverter;
import com.cts.fasttack.mdes.server.dto.AuthorizeServiceRequestDto;
import com.cts.fasttack.mdes.server.dto.AuthorizeServiceResponseDto;

/**
 * Authorize controller
 *
 * @author Dmitry Koval
 */
@RestController
public class AuthorizeController extends AbstractMdesRestController {

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private AuthorizeServiceRequestDtoToJmsDtoConverter authorizeServiceRequestDtoToJmsDtoConverter;

    @Autowired
    private JmsAuthorizeServiceResponseToResponseDtoConverter jmsAuthorizeServiceResponseToResponseDtoConverter;

    @Autowired
    private Validator validator;

    @Autowired
    private MessageSourceService messageSourceService;

    @PostMapping("/authorizeService")
    @ResponseBody
    @MessageHistoryOperation(connectorClient = "MDES", rawIn = "#request",
            maskedPan = "#result != null ? #result.maskedPan : null",
            panSource = "#result != null ? #result.panSource : null",
            decision = "#result.decision",
            errorCode = "#result.errorCode",
            panInternalId = "#result != null ? #result.panInternalId : null",
            panInternalGuid = "#result != null ? #result.panInternalGuid : null",
            cvcResp = "#result.cvcResponse != null ? (\"MATCH\").equals(#result.cvcResponse.name()) ? \"M\" : (\"INVALID\").equals(#result.cvcResponse.name()) ? \"N\" : \"P\" : null")
    public ResponseEntity<AuthorizeServiceResponseDto> authorizeService(@RequestBody String request) {

        // Check Invalid RequestBody
        AuthorizeServiceRequestDto requestDto;
        try {
            requestDto = JsonUtil.fromJson(request, AuthorizeServiceRequestDto.class);
        } catch (Exception e) {
            AuthorizeServiceResponseDto responseDto = new AuthorizeServiceResponseDto();
            createResponse(responseDto, null, StandardErrorCodes.INVALID_JSON.name(), messageSourceService.getMessage(StandardErrorCodes.INVALID_JSON.name()));
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }

        return processRequest(requestDto, new AuthorizeServiceResponseDto(), response -> {
            Set<ConstraintViolation<AuthorizeServiceRequestDto>> violations = validator.validate(requestDto);
            if (violations.isEmpty()) {
                HeadersJmsMessage jmsMessage = new AuthorizeServiceJmsMessage()
                        .authorizeServiceDto(authorizeServiceRequestDtoToJmsDtoConverter.convert(requestDto))
                        .originator(callingContext.getOriginator());
                try {
                    JmsAuthorizeServiceResponseDto coreResponse = integrationBus.inOut(callingContext.getProcessingArea(), "authorizeService", jmsMessage, JmsAuthorizeServiceResponseDto.class);
                    jmsAuthorizeServiceResponseToResponseDtoConverter.convert(coreResponse, response);
                } catch (ServiceException ex) {
                    createResponse(response, requestDto.getRequestId(), ex.getErrorCode().name(), messageSourceService.getMessage(ex.getErrorDescription()));
                }
            } else {
                ConstraintViolation<AuthorizeServiceRequestDto> constraintViolation = violations.iterator().next();
                createResponse(response, requestDto.getRequestId(), constraintViolation.getMessageTemplate(), messageSourceService.getMessage(constraintViolation.getMessageTemplate(), constraintViolation.getPropertyPath()));
            }
        });

    }

    private void createResponse(AuthorizeServiceResponseDto responseDto, String responseId, String errorCode, String errorDescription){
        responseDto.setResponseId(responseId);
        responseDto.setErrorCode(errorCode);
        responseDto.setErrorDescription(errorDescription);
        responseDto.setDecision("DECLINED");
    }
}
