package com.cts.fasttack.crypto.server.controller;

import com.cts.fasttack.common.core.exception.CryptographyException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.crypto.client.dto.CryptoResponseDto;
import com.cts.fasttack.crypto.server.exception.UnexpectedKidException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Anton Leliuk
 */
@RestControllerAdvice
public class ExceptionController {

    private final Logger log = LogManager.getLogger(getClass());

    @ExceptionHandler(CryptographyException.class)
    public CryptoResponseDto handleCryptographyException(CryptographyException e){
    	log.error("Cryptography exception: " + e.getMessage(), e);

    	CryptoResponseDto response = new CryptoResponseDto();
        response.setErrorCode(StandardErrorCodes.CRYPTOGRAPHY_ERROR);
        return response;
    }

    @ExceptionHandler(UnexpectedKidException.class)
    public CryptoResponseDto handleUnexpectedKidException(UnexpectedKidException e){
    	log.error("Unexpected JWE Key ID value found in request data: " + e.getMessage(), e);

    	CryptoResponseDto response = new CryptoResponseDto();
        response.setErrorCode(StandardErrorCodes.INVALID_FIELD_VALUE);
        return response;
    }
}
