package com.cts.fasttack.crypto.client.dto;

import com.cts.fasttack.common.core.exception.StandardErrorCodes;

/**
 * @author Anton Leliuk
 */
public class CryptoResponseDto {

    private String text;

    private StandardErrorCodes errorCode;

    public CryptoResponseDto() {}

    public CryptoResponseDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public StandardErrorCodes getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(StandardErrorCodes errorCode) {
        this.errorCode = errorCode;
    }
}
