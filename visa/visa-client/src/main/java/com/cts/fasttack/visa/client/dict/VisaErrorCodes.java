package com.cts.fasttack.visa.client.dict;

import com.cts.fasttack.common.core.exception.ErrorCode;

/**
 * @author Anton Leliuk
 */
public enum VisaErrorCodes implements ErrorCode {

    // Для проблемы коммуникации (Connection timeout, read timeout)
    VTS_COMMUNICATION_ERROR,

    // 500 serviceError
    // 503 serviceError
    VTS_TEMP_ERROR,

    // 400 invalidParameters
    // 400 incompleteRequest
    VTS_INVALID_PARAMETERS,

    // 403 notAllowed
    VTS_OPERATIONS_NOT_ALLOWED,

    // confirm provision, 403 serviceError
    VTS_SERVICE_ERROR,

    // 409 notAllowed
    VTS_INVALID_CARD,

    // other
    VTS_ERROR
}
