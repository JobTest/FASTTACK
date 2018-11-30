package com.cts.fasttack.bank.server.dict;

import com.cts.fasttack.common.core.exception.ErrorCode;

/**
 * @author a.lipavets
 */
public enum BankErrorCodes implements ErrorCode {
    INVALID_INPUT("1"),
    NO_DATA_FOUND("2"),
    INVALID_TOKEN_STATUS("2"),
    INTERNAL_ERROR("3");

    private String code;

    BankErrorCodes(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
