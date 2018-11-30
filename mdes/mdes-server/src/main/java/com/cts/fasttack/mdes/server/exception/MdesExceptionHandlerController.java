package com.cts.fasttack.mdes.server.exception;

import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.mdes.server.dto.CommonMdesRequestDto;
import com.cts.fasttack.mdes.server.dto.CommonMdesResponseDto;
import com.cts.fasttack.common.core.messages.MessageSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ValidationException;

/**
 * Service exception handler for mdes server
 *
 * @author a.lipavets
 */
@ControllerAdvice
public class MdesExceptionHandlerController {

    @Autowired
    private MessageSourceService messageSourceService;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonMdesResponseDto handleValidationException(MethodArgumentNotValidException e) {
        CommonMdesResponseDto responseDto = new CommonMdesResponseDto();
        responseDto.setResponseId(((CommonMdesRequestDto) e.getBindingResult().getTarget()).getRequestId());
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        responseDto.setErrorCode(objectError.getDefaultMessage());
        responseDto.setErrorDescription(messageSourceService.getMessage(objectError.getDefaultMessage(), ((FieldError) objectError).getField()));
        return responseDto;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public CommonMdesResponseDto handleEmptyRequest(HttpMessageNotReadableException e){
        CommonMdesResponseDto responseDto = new CommonMdesResponseDto();
        responseDto.setErrorCode(StandardErrorCodes.INVALID_JSON.name());
        responseDto.setErrorDescription(messageSourceService.getMessage(StandardErrorCodes.INVALID_JSON.name()));
        return responseDto;
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public CommonMdesResponseDto handleUnexpectedException(ValidationException e){
        CommonMdesResponseDto responseDto = new CommonMdesResponseDto();
        responseDto.setErrorCode(StandardErrorCodes.INVALID_JSON.name());
        responseDto.setErrorDescription(messageSourceService.getMessage(StandardErrorCodes.INVALID_JSON.name()));
        return responseDto;
    }
}
