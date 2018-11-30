package com.cts.fasttack.bank.server.pushprovisioning.controller;

import javax.validation.ValidationException;

import com.cts.fasttack.bank.server.pushprovisioning.dto.CreateInAppProvisioningDataRequestDto;
import com.cts.fasttack.bank.server.pushprovisioning.dto.CreateInAppProvisioningDataResponseDto;
import com.cts.fasttack.bank.server.pushprovisioning.service.BankService;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.messages.MessageSourceService;
import com.cts.fasttack.crypto.client.dto.CreateInAppProvisioningDataCryptoResponse;
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
 * @author d.ishchenko
 */
@RestController
public class CreateInAppProvisioningDataController {

    @Autowired
    private MessageSourceService messageSourceService;

    @Autowired
    private BankService bankService;

    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request", responseMediaType = MediaType.APPLICATION_XML_VALUE, maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#request.pan)")
    @PostMapping("/createInAppProvisioningData")
    public CreateInAppProvisioningDataResponseDto createInAppProvisioningData(@Validated @RequestBody CreateInAppProvisioningDataRequestDto request) throws ServiceException {

        return createResponse(bankService.createInAppProvisioningData(request));
    }

    private CreateInAppProvisioningDataResponseDto createResponse(CreateInAppProvisioningDataCryptoResponse bankServiceResponse){
        CreateInAppProvisioningDataResponseDto response = new CreateInAppProvisioningDataResponseDto();

        response.setEncryptedPassData(bankServiceResponse.getEncryptedPassData());
        response.setActivationData(bankServiceResponse.getActivationData());
        response.setEphemeralPublicKey(bankServiceResponse.getEphemeralPublicKey());
        response.setAuthcode(bankServiceResponse.getAuthcode());

        return response;
    }

    @ExceptionHandler(ValidationException.class)
    public CreateInAppProvisioningDataResponseDto handleValidationException(ValidationException e){
        CreateInAppProvisioningDataResponseDto response = new CreateInAppProvisioningDataResponseDto();

        response.setCode(CreateInAppProvisioningDataResponseDto.ERROR_CODE);
        response.setErrorMessage(messageSourceService.getMessage(StandardErrorCodes.INVALID_JSON.name()));

        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CreateInAppProvisioningDataResponseDto handleValidationException(MethodArgumentNotValidException e) {

        return createResponse(e.getBindingResult());
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public CreateInAppProvisioningDataResponseDto handleBindException(BindException e){

        return createResponse(e.getBindingResult());
    }

    private CreateInAppProvisioningDataResponseDto createResponse(BindingResult r){
        CreateInAppProvisioningDataResponseDto responseDto = new CreateInAppProvisioningDataResponseDto();

        ObjectError objectError = r.getAllErrors().get(0);

        responseDto.setCode(CreateInAppProvisioningDataResponseDto.ERROR_CODE);
        responseDto.setErrorMessage(messageSourceService.getMessage(objectError.getDefaultMessage(), ((FieldError) objectError).getField()));

        return responseDto;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public CreateInAppProvisioningDataResponseDto handleEmptyRequest(HttpMessageNotReadableException e){
        CreateInAppProvisioningDataResponseDto responseDto = new CreateInAppProvisioningDataResponseDto();

        responseDto.setCode(CreateInAppProvisioningDataResponseDto.ERROR_CODE);
        responseDto.setErrorMessage(messageSourceService.getMessage(StandardErrorCodes.INVALID_JSON.name()));

        return responseDto;
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public CreateInAppProvisioningDataResponseDto handleServiceException(ServiceException e){
        CreateInAppProvisioningDataResponseDto responseDto = new CreateInAppProvisioningDataResponseDto();

        responseDto.setCode(CreateInAppProvisioningDataResponseDto.ERROR_CODE);
        responseDto.setErrorMessage(messageSourceService.getMessage(e.getErrorCode().name()));

        return responseDto;
    }
}
