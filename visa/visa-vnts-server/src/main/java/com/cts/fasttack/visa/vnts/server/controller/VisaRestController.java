package com.cts.fasttack.visa.vnts.server.controller;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.cts.fasttack.common.core.dict.VisaErrorCode;
import com.cts.fasttack.common.core.exception.CryptographyException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.validation.ValidationSequence;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.CardholderVerificationMethodsJmsMessage;
import com.cts.fasttack.jms.dto.CardholderVerificationMethodsJmsResponse;
import com.cts.fasttack.jms.dto.SendPasscodeJmsMessage;
import com.cts.fasttack.jms.dto.SendPasscodeJmsResponse;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import com.cts.fasttack.logging.service.CallingContext;
import com.cts.fasttack.visa.common.dict.ActionCode;
import com.cts.fasttack.visa.common.dto.CommonVisaRequestDto;
import com.cts.fasttack.visa.common.dto.CommonVisaResponseDto;
import com.cts.fasttack.visa.vnts.server.converter.CardholderVerificationMethodRequestToJmsDtoConverter;
import com.cts.fasttack.visa.vnts.server.converter.CardholderVerificationMethodsJmsResponseToResponseConverter;
import com.cts.fasttack.visa.vnts.server.converter.SendPasscodeJmsResponseToResponseConverter;
import com.cts.fasttack.visa.vnts.server.converter.SendPasscodeRequestToJmsDtoConverter;
import com.cts.fasttack.visa.vnts.server.dto.CardholderVerificationMethodResponseDto;
import com.cts.fasttack.visa.vnts.server.dto.CardholderVerificationMethodsRequestDto;
import com.cts.fasttack.visa.vnts.server.dto.SendPasscodeRequestDto;
import com.cts.fasttack.visa.vnts.server.dto.SendPasscodeResponseDto;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author a.lipavets
 */
@RestController
public class VisaRestController {

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private SendPasscodeRequestToJmsDtoConverter sendPasscodeRequestToJmsDtoConverter;

    @Autowired
    private SendPasscodeJmsResponseToResponseConverter sendPasscodeJmsResponseToResponseConverter;

    @Autowired
    private CardholderVerificationMethodRequestToJmsDtoConverter cardholderVerificationMethodRequestToJmsDtoConverter;

    @Autowired
    private CardholderVerificationMethodsJmsResponseToResponseConverter cardholderVerificationMethodsJmsResponseToResponseConverter;

    @Autowired
    private Validator validator;

    @PostMapping("/sendpasscode/v1")
    @ResponseBody
    @MessageHistoryOperation(connectorClient = "VTS", rawIn = "#requestDto", responseMediaType = MediaType.APPLICATION_XML_VALUE, errorCode = "(\"00\").equals(#result.actionCode) ? #result.actionCode : #result.errorCode",
            maskedPan = "#result != null ? #result.maskedPan : null",
            panInternalId = "#result != null ? #result.panInternalId : null",
            panInternalGuid = "#result != null ? #result.panInternalGuid : null",
            tokenId = "#requestDto != null ? #requestDto.tokenReferenceID : null")
    public SendPasscodeResponseDto sendPasscode(@RequestBody(required = false) SendPasscodeRequestDto requestDto) throws ServiceException {
        return processRequest(requestDto, new SendPasscodeResponseDto(), response -> {

            Set<ConstraintViolation<SendPasscodeRequestDto>> violations = validator.validate(requestDto, ValidationSequence.class);
            if (!violations.isEmpty()) {
                setResponseErrorAttributes(response, violations.iterator().next().getMessage());
            } else {
                HeadersJmsMessage jmsMessage = new SendPasscodeJmsMessage()
                        .sendPasscodeDto(sendPasscodeRequestToJmsDtoConverter.convert(requestDto))
                        .originator(callingContext.getOriginator());

                SendPasscodeJmsResponse spResponse = integrationBus.inOut(callingContext.getProcessingArea(), "sendPasscode", jmsMessage, SendPasscodeJmsResponse.class);
                sendPasscodeJmsResponseToResponseConverter.convert(spResponse, response);
                if (StringUtils.isNotBlank(spResponse.getCode()) && !"0".equals(spResponse.getCode())) {
                    setResponseErrorAttributes(response, spResponse.getCode());
                }
            }
        });
    }

    @PostMapping("/cardholderverificationmethods/v1")
    @ResponseBody
    @MessageHistoryOperation(connectorClient = "VTS", rawIn = "#requestDto", responseMediaType = MediaType.APPLICATION_XML_VALUE,
            errorCode = "(\"00\").equals(#result.actionCode) ? #result.actionCode : #result.errorCode",
            panSource = "#requestDto != null && #requestDto.riskInformation != null ? T(com.cts.fasttack.common.core.dict.PanSourceType).fromVisaIwsiPanSourceAsNullableString(#requestDto.riskInformation.panSource) : null",
            maskedPan = "#result != null ? #result.maskedPan : null",
            panInternalId = "#result != null ? #result.panInternalId : null",
            panInternalGuid = "#result != null ? #result.panInternalGuid : null",
            tokenId = "#requestDto != null ? #requestDto.tokenReferenceID : null")
    public CardholderVerificationMethodResponseDto cardholderVerificationMethods(@RequestBody(required = false) CardholderVerificationMethodsRequestDto requestDto) throws ServiceException {
        return processRequest(requestDto, new CardholderVerificationMethodResponseDto(), response -> {

            Set<ConstraintViolation<CardholderVerificationMethodsRequestDto>> violations = validator.validate(requestDto, ValidationSequence.class);
            if (!violations.isEmpty()) {
                setResponseErrorAttributes(response, violations.iterator().next().getMessage());
            } else {
                HeadersJmsMessage jmsMessage = new CardholderVerificationMethodsJmsMessage()
                        .cardholderVerificationMethodsDto(cardholderVerificationMethodRequestToJmsDtoConverter.convert(requestDto))
                        .originator(callingContext.getOriginator());

				try {
					CardholderVerificationMethodsJmsResponse cvmResponse = integrationBus.inOut(
							callingContext.getProcessingArea(), "cardholderVerificationMethods", jmsMessage,
							CardholderVerificationMethodsJmsResponse.class);
					cardholderVerificationMethodsJmsResponseToResponseConverter.convert(cvmResponse, response);
				} catch (ServiceException ex) {
					if (StandardErrorCodes.NO_DATA_FOUND.name().equals(ex.getErrorCode().name())) {
	                    setResponseErrorAttributes(response, VisaErrorCode.Codes.TOKEN_REFERENCE_ID_IS_NOT_VALID);
					} else {
						throw ex;
					}
				}
            }
        });
    }

    private <T extends CommonVisaResponseDto> T processRequest(CommonVisaRequestDto request, T response, ProcessingCallback<T> callback) {
        try {
            if (request == null) {
                setResponseErrorAttributes(response, VisaErrorCode.Codes.MISSING_REQUIRED_FIELD);
                return response;
            }
            callback.execute(response);
        } catch (ServiceException | CryptographyException e) {
            if(StandardErrorCodes.HOST_NOT_AVAILABLE.name().equals(e.getErrorCode().name()) || StandardErrorCodes.HOST_TIMEOUT.name().equals(e.getErrorCode().name())) {
                setResponseErrorAttributes(response, VisaErrorCode.Codes.CURRENT_CHANNEL_IS_NOT_AVAILABLE);
                return response;
            }
            setResponseErrorAttributes(response, VisaErrorCode.valueOf(e.getErrorCode().name()).getCode());
            return response;
        } catch (Exception e) {
            setResponseErrorAttributes(response, VisaErrorCode.Codes.INTERNAL_SERVICE_FAILURE);
            return response;
        }
        return response;
    }

    private void setResponseErrorAttributes(CommonVisaResponseDto response, String errorCode) {
        response.setActionCode(ActionCode.FAILURE.getCode());
        response.setErrorCode(errorCode);
    }

    private interface ProcessingCallback<T extends CommonVisaResponseDto> {
        void execute(T response) throws ServiceException;
    }
}
