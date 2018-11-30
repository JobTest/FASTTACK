package com.cts.fasttack.visa.common.dto;

import java.util.List;

import com.cts.fasttack.visa.common.dict.VisaErrorReasonCode;

/**
 * Visa error response DTO
 * @author Anton Leliuk
 */
public class ErrorResponseDto {

    private ErrorDto errorResponse;

    public ErrorResponseDto() {
    }

    public ErrorResponseDto(VisaErrorReasonCode errorReasonCode, List<ErrorDetailsDto> details) {
        ErrorDto errorResponseDto = new ErrorDto();
        errorResponseDto.setReason(errorReasonCode.name());
        errorResponseDto.setStatus(errorReasonCode.getStatus());
        errorResponseDto.setMessage(errorReasonCode.getMessage());
        if (details != null) {
            errorResponseDto.setDetails(details);
        }
        this.errorResponse = errorResponseDto;
    }

    public ErrorDto getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorDto errorResponse) {
        this.errorResponse = errorResponse;
    }
}
