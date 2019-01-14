package com.cts.fasttack.mdes.server.rest;

import com.cts.fasttack.common.core.exception.CryptographyException;
import com.cts.fasttack.common.core.exception.ErrorCode;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.messages.MessageSourceService;
import com.cts.fasttack.mdes.server.dto.CommonMdesRequestDto;
import com.cts.fasttack.mdes.server.dto.CommonMdesResponseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author a.lipavets
 */
public class AbstractMdesRestController {

    private Logger logger = LogManager.getLogger(AbstractMdesRestController.class);

    @Autowired
    private MessageSourceService messageSourceService;

    <T extends CommonMdesResponseDto>ResponseEntity<T> processRequest(CommonMdesRequestDto request, T response, ProcessingCallback<T> callback) {
        try {
            if(request == null){
                setResponseErrorAttributes(response, StandardErrorCodes.INVALID_JSON);
                return new ResponseEntity<T>(response, HttpStatus.OK);
            }
            callback.execute(response);
        } catch (ServiceException | CryptographyException e) {
            response.setResponseId(request.getRequestId());
            setResponseErrorAttributes(response, e.getErrorCode(), e.getErrorDescription());
            return new ResponseEntity<>(response, e.getHttpStatus());
        } catch (Exception e) {
            logger.error("Error while processing request", e);
            setResponseErrorAttributes(response, StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
        }
        response.setResponseId(request.getRequestId());
        return new ResponseEntity<T>(response, HttpStatus.OK);
    }

    protected void setResponseErrorAttributes(CommonMdesResponseDto response, ErrorCode errorCode) {
        response.setErrorDescription(messageSourceService.getMessage(errorCode.name()));
        response.setErrorCode(errorCode.name());
    }

    protected void setResponseErrorAttributes(CommonMdesResponseDto response, ErrorCode errorCode, String errorDescription) {
        response.setErrorDescription(messageSourceService.getMessage(errorDescription));
        response.setErrorCode(errorCode.name());
    }

    protected interface ProcessingCallback<T extends CommonMdesResponseDto> {
        void execute(T response) throws ServiceException;
    }
}
