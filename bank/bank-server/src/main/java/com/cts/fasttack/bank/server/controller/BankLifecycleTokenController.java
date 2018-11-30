package com.cts.fasttack.bank.server.controller;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.cts.fasttack.bank.server.dto.LifecycleTokenResponseDto;
import com.cts.fasttack.bank.server.dto.TokenUpdateResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cts.fasttack.bank.server.converter.TokenLifecycleRequestToJmsConverter;
import com.cts.fasttack.bank.server.converter.TokenUpdateToJmsMessageConverter;
import com.cts.fasttack.bank.server.dict.BankErrorCodes;
import com.cts.fasttack.bank.server.dto.TokenLifecycleRequestDto;
import com.cts.fasttack.bank.server.dto.TokenUpdateRequestDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.BankLifecycleTokenJmsMessage;
import com.cts.fasttack.jms.dto.JmsLifecycleTokenResponseDto;
import com.cts.fasttack.jms.dto.UpdateTokenJmsMessage;
import com.cts.fasttack.jms.dto.UpdateTokenJmsResponse;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import com.cts.fasttack.logging.service.CallingContext;

/**
 * @author a.lipavets
 */
@RestController
public class BankLifecycleTokenController extends AbstractBankRestController {

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private TokenLifecycleRequestToJmsConverter tokenLifecycleRequestToJmsConverter;

    @Autowired
    private TokenUpdateToJmsMessageConverter tokenUpdateToJmsMessageConverter;

    @Autowired
    private Validator validator;

    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request", panInternalId = "#request != null ? #request.panInternalId : null",
            panInternalGuid = "#request != null ? #request.panInternalGUID : null", maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#request.pan)", errorCode = "!(\"0\").equals(#result.code) ? #result.code : null",
            tokenId = "#request != null ? #request.tokenRefId : null")
    @PostMapping("/tokenLifecycle")
    public LifecycleTokenResponseDto tokenLifecycle(@RequestBody(required = false) TokenLifecycleRequestDto request) throws ServiceException {

        return processRequest(request, new LifecycleTokenResponseDto(), response -> {
            Set<ConstraintViolation<TokenLifecycleRequestDto>> violations = validator.validate(request);
            if (!violations.isEmpty()) {
                setResponseErrorAttributes(response, violations.iterator().next().getMessage(), BankErrorCodes.INVALID_INPUT.getCode());
            } else {
                HeadersJmsMessage jmsMessage = new BankLifecycleTokenJmsMessage()
                        .activateTokenDto(tokenLifecycleRequestToJmsConverter.convert(request))
                        .originator(callingContext.getOriginator());

                JmsLifecycleTokenResponseDto resDto = integrationBus.inOut(callingContext.getProcessingArea(), "lifecycleToken", jmsMessage, JmsLifecycleTokenResponseDto.class);
                if("VSE40001".equals(resDto.getErrorMessage()) || "VSE40003".equals(resDto.getErrorMessage())){
                    setResponseErrorAttributes(response, resDto.getErrorMessage(), "2");
                } else if("VSE40002".equals(resDto.getErrorMessage())) {
                    setResponseErrorAttributes(response, resDto.getErrorMessage(), "0");
                } else {
                    setResponseErrorAttributes(response, resDto.getErrorMessage(), resDto.getCode());
                }
            }
        });
    }

    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request", panInternalId = "#request != null ? #request.panInternalId : null",
            panInternalGuid = "#request != null ? #request.panInternalGUID : null", maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#request.oldAccountPan)",
            errorCode = "!(\"0\").equals(#result.code) ? #result.code : null",
            tokenId = "#request != null ? #request.tokenRefId : null")
    @PostMapping("/tokenUpdate")
    public TokenUpdateResponseDto tokenUpdate(@RequestBody(required = false) TokenUpdateRequestDto request) throws ServiceException {
        return processRequest(request, new TokenUpdateResponseDto(), response -> {
            Set<ConstraintViolation<TokenUpdateRequestDto>> violations = validator.validate(request);
            if (!violations.isEmpty()) {
                setResponseErrorAttributes(response, violations.iterator().next().getMessage(), BankErrorCodes.INVALID_INPUT.getCode(), violations.iterator().next().getPropertyPath());
            } else {
                HeadersJmsMessage jmsMessage = new UpdateTokenJmsMessage()
                        .updateTokenDto(tokenUpdateToJmsMessageConverter.convert(request))
                        .originator(callingContext.getOriginator());

                UpdateTokenJmsResponse updateResponse = integrationBus.inOut(() -> "CORE", "updateToken", jmsMessage, UpdateTokenJmsResponse.class);
                if(!"00".equals(updateResponse.getCodeStatus())) {
                    response.setCode("1");
                }
                response.setErrorMessage(updateResponse.getMessage());
            }
        });
    }
}
