package com.cts.fasttack.bank.server.pushprovisioning.controller;

import javax.validation.ValidationException;

import com.cts.fasttack.bank.server.pushprovisioning.dto.CreateOpaquePaymentCardRequestDto;
import com.cts.fasttack.bank.server.pushprovisioning.dto.CreateOpaquePaymentCardResponseDto;
import com.cts.fasttack.bank.server.pushprovisioning.service.BankService;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.messages.MessageSourceService;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anton Leliuk
 */
@RestController
public class CreateOpaquePaymentCardController {

    @Autowired
    private MessageSourceService messageSourceService;

    @Autowired
    private BankService bankService;

    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request", responseMediaType = MediaType.APPLICATION_XML_VALUE, maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#request.pan)")
    @PostMapping("/createOpaquePaymentCard")
    public CreateOpaquePaymentCardResponseDto createOpaquePaymentCard(@Validated @RequestBody CreateOpaquePaymentCardRequestDto request) throws ServiceException {
        CreateOpaquePaymentCardResponseDto response = new CreateOpaquePaymentCardResponseDto();
        response.setOpaqueBody(bankService.createOpaqueCardBody(request).getOpaqueBody());
        return response;
    }

    @ExceptionHandler(ValidationException.class)
    public CreateOpaquePaymentCardResponseDto handleValidationException(ValidationException e){
        CreateOpaquePaymentCardResponseDto response = new CreateOpaquePaymentCardResponseDto();
        response.setCode(CreateOpaquePaymentCardResponseDto.ERROR_CODE);
        response.setErrorMessage(messageSourceService.getMessage(StandardErrorCodes.INVALID_JSON.name()));
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CreateOpaquePaymentCardResponseDto handleValidationException(MethodArgumentNotValidException e) {
        return createResponse(e.getBindingResult());
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public CreateOpaquePaymentCardResponseDto handleBindException(BindException e){
        return createResponse(e.getBindingResult());
    }

    private CreateOpaquePaymentCardResponseDto createResponse(BindingResult r){
        CreateOpaquePaymentCardResponseDto responseDto = new CreateOpaquePaymentCardResponseDto();
        ObjectError objectError = r.getAllErrors().get(0);
        responseDto.setCode(CreateOpaquePaymentCardResponseDto.ERROR_CODE);
        responseDto.setErrorMessage(messageSourceService.getMessage(objectError.getDefaultMessage(), ((FieldError) objectError).getField()));
        return responseDto;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public CreateOpaquePaymentCardResponseDto handleEmptyRequest(HttpMessageNotReadableException e){
        CreateOpaquePaymentCardResponseDto responseDto = new CreateOpaquePaymentCardResponseDto();
        responseDto.setCode(CreateOpaquePaymentCardResponseDto.ERROR_CODE);
        responseDto.setErrorMessage(messageSourceService.getMessage(StandardErrorCodes.INVALID_JSON.name()));
        return responseDto;
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public CreateOpaquePaymentCardResponseDto handleServiceException(ServiceException e){
        CreateOpaquePaymentCardResponseDto responseDto = new CreateOpaquePaymentCardResponseDto();
        responseDto.setCode(CreateOpaquePaymentCardResponseDto.ERROR_CODE);
        responseDto.setErrorMessage(messageSourceService.getMessage(e.getErrorCode().name()));
        return responseDto;
    }
}
