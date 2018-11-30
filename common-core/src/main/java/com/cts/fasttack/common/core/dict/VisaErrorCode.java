package com.cts.fasttack.common.core.dict;

import java.util.Arrays;
import java.util.Optional;

import com.cts.fasttack.common.core.exception.ErrorCode;

/**
 * Error Codes used for Visa API
 *
 * @author a.lipavets
 */
public enum VisaErrorCode implements ErrorCode {

    MISSING_REQUIRED_FIELD(Codes.MISSING_REQUIRED_FIELD),
    INVALID_FIELD_LENGTH(Codes.INVALID_FIELD_LENGTH),
    INVALID_FIELD_TYPE(Codes.INVALID_FIELD_TYPE),
    DATA_ELEMENT_NOT_VALID(Codes.DATA_ELEMENT_NOT_VALID),
    TOKEN_REFERENCE_ID_IS_NOT_VALID(Codes.TOKEN_REFERENCE_ID_IS_NOT_VALID),
    RESOLUTION_METHOD_ID_IS_NOT_VALID(Codes.RESOLUTION_METHOD_ID_IS_NOT_VALID),
    CURRENT_CHANNEL_IS_NOT_AVAILABLE(Codes.CURRENT_CHANNEL_IS_NOT_AVAILABLE),
    RESOLUTION_METHOD_ID_IS_NOT_VALID_ANY_MORE(Codes.RESOLUTION_METHOD_ID_IS_NOT_VALID_ANY_MORE),
    INTERNAL_SERVICE_FAILURE(Codes.INTERNAL_SERVICE_FAILURE),
    CRYPTOGRAPHY_ERROR(Codes.CRYPTOGRAPHY_ERROR);

    private String code;

    VisaErrorCode(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static VisaErrorCode getByCode(String code){
        Optional<VisaErrorCode> error = Arrays.stream(VisaErrorCode.values()).filter(item -> item.getCode().equals(code)).findFirst();
        return error.isPresent() ? error.get() : null;
    }

    public interface Codes {
        String MISSING_REQUIRED_FIELD = "ISE40000";
        String INVALID_FIELD_LENGTH = "ISE40005";
        String INVALID_FIELD_TYPE = "ISE40006";
        String DATA_ELEMENT_NOT_VALID = "ISE40011";
        String TOKEN_REFERENCE_ID_IS_NOT_VALID = "ISE40500";
        String RESOLUTION_METHOD_ID_IS_NOT_VALID = "ISE40501";
        String CURRENT_CHANNEL_IS_NOT_AVAILABLE = "ISE40502";
        String RESOLUTION_METHOD_ID_IS_NOT_VALID_ANY_MORE = "ISE40503";
        String INTERNAL_SERVICE_FAILURE = "ISE40504";
        String CRYPTOGRAPHY_ERROR = "ISE40010";
    }

    public interface Names {
        String MISSING_REQUIRED_FIELD = "MISSING_REQUIRED_FIELD";
        String INVALID_FIELD_LENGTH = "INVALID_FIELD_LENGTH";
        String INVALID_FIELD_TYPE = "INVALID_FIELD_TYPE";
        String DATA_ELEMENT_NOT_VALID = "DATA_ELEMENT_NOT_VALID";
        String TOKEN_REFERENCE_ID_IS_NOT_VALID = "TOKEN_REFERENCE_ID_IS_NOT_VALID";
        String RESOLUTION_METHOD_ID_IS_NOT_VALID = "RESOLUTION_METHOD_ID_IS_NOT_VALID";
        String CURRENT_CHANNEL_IS_NOT_AVAILABLE = "CURRENT_CHANNEL_IS_NOT_AVAILABLE";
        String RESOLUTION_METHOD_ID_IS_NOT_VALID_ANY_MORE = "RESOLUTION_METHOD_ID_IS_NOT_VALID_ANY_MORE";
        String INTERNAL_SERVICE_FAILURE = "INTERNAL_SERVICE_FAILURE";
        String CRYPTOGRAPHY_ERROR = "CRYPTOGRAPHY_ERROR";
    }

}
