package com.cts.fasttack.visa.client.exception;

import com.cts.fasttack.common.core.exception.ErrorCode;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.handler.ExceptionHandler;
import com.cts.fasttack.common.core.exception.handler.ServiceExceptionHandler;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.visa.client.dict.VisaErrorCodes;
import com.cts.fasttack.visa.client.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

/**
 * Exception handler for Visa services
 * @author Anton Leliuk
 */
public class VisaExceptionHandler extends ServiceExceptionHandler implements ExceptionHandler {

    public static final VisaExceptionHandler INSTANCE = new VisaExceptionHandler();

    @Override
    public <RESPONSE> RESPONSE handle(Exception e) throws ServiceException {
        ErrorCode errorCode = null;
        StringBuilder text = new StringBuilder("Error calling VTS service");
        if (e instanceof HttpStatusCodeException) {
            HttpStatusCodeException he = (HttpStatusCodeException) e;
            text.append(": ");
            String responseBodyAsString = he.getResponseBodyAsString();
            if(responseBodyAsString.contains("errorResponse")){
                ErrorResponseDto response = JsonUtil.fromJson(responseBodyAsString, ErrorResponseDto.class);
                text.append(response.getErrorResponse().toString());

                if (response.getErrorResponse() != null
                        && HttpStatus.FORBIDDEN.equals(he.getStatusCode())
                        && "serviceError".equalsIgnoreCase(response.getErrorResponse().getReason())) {
                    // logic for Confirm Provisioning only
                    errorCode = VisaErrorCodes.VTS_SERVICE_ERROR;
                }
            } else {
                text.append(responseBodyAsString);
            }

            if (errorCode == null) {
                switch (he.getStatusCode()) {
                    case INTERNAL_SERVER_ERROR :
                    case SERVICE_UNAVAILABLE : {
                        errorCode = VisaErrorCodes.VTS_TEMP_ERROR;
                        break;
                    }
                    case BAD_REQUEST: {
                        errorCode = VisaErrorCodes.VTS_INVALID_PARAMETERS;
                        break;
                    }
                    case FORBIDDEN: {
                        errorCode = VisaErrorCodes.VTS_OPERATIONS_NOT_ALLOWED;
                        break;
                    }
                    case CONFLICT: {
                        errorCode = VisaErrorCodes.VTS_INVALID_CARD;
                        break;
                    }
                    default:
                    	// do nothing
                    	break;
                }
            }


        } else if (e instanceof ResourceAccessException) {
            text.append(": ").append(e.getMessage());
            errorCode = VisaErrorCodes.VTS_COMMUNICATION_ERROR;
        }

        if (errorCode == null) {
            errorCode = VisaErrorCodes.VTS_ERROR;
        }

        String finalErrorText = text.toString();
        log.error(finalErrorText, e);
        throw ServiceException.withDescription(errorCode, finalErrorText);
    }
}
