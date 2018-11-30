package com.cts.fasttack.visa.common.exception;

import java.util.Collections;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.fasttack.visa.common.dict.VisaErrorReasonCode;
import com.cts.fasttack.visa.common.dto.ErrorDetailsDto;
import com.cts.fasttack.visa.common.dto.ErrorResponseDto;

/**
 * @author Dmitry Koval
 */
@ControllerAdvice
public class VisaExceptionHandlerController {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResponseEntity<?> handleValidationException(MissingServletRequestParameterException e) {
        return new ResponseEntity<>(
                new ErrorResponseDto(
                        VisaErrorReasonCode.invalidParameter,
                        Collections.singletonList(new ErrorDetailsDto(e.getParameterName(), "Missing required field"))), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseEntity<?> handleServiceException(ServiceException e){
        if(StandardErrorCodes.INTERNAL_SERVICE_FAILURE.name().equals(e.getErrorCode().name()) ||
        		StandardErrorCodes.HOST_NOT_AVAILABLE.name().equals(e.getErrorCode().name()) ||
        		StandardErrorCodes.HOST_TIMEOUT.name().equals(e.getErrorCode().name())){
            return new ResponseEntity<>(new ErrorResponseDto(VisaErrorReasonCode.serviceError, Collections.singletonList(new ErrorDetailsDto(null, e.getMessage()))), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(
                    new ErrorResponseDto(
                            VisaErrorReasonCode.invalidParameter,
                            Collections.singletonList(new ErrorDetailsDto(null, e.getMessage()))), HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> handleException(Exception e){
        return new ResponseEntity<>(new ErrorResponseDto(VisaErrorReasonCode.serviceError, Collections.singletonList(new ErrorDetailsDto(null, e.getMessage()))), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
