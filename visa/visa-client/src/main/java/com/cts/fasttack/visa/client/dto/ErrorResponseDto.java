package com.cts.fasttack.visa.client.dto;

/**
 * Visa error response DTO
 * @author Anton Leliuk
 */
public class ErrorResponseDto {

    private ErrorDto errorResponse;

    public ErrorDto getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorDto errorResponse) {
        this.errorResponse = errorResponse;
    }
}
