package com.cts.fasttack.bank.server.controller;

import com.cts.fasttack.bank.server.dict.BankErrorCodes;
import com.cts.fasttack.bank.server.dto.CommonTokenLifecycleRequestDto;
import com.cts.fasttack.bank.server.dto.CommonTokenResponseDto;
import com.cts.fasttack.common.core.exception.CryptographyException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.messages.MessageSourceService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author a.lipavets
 */
public class AbstractBankRestController {

    @Autowired
    private MessageSourceService messageSourceService;

    <T extends CommonTokenResponseDto> T processRequest(CommonTokenLifecycleRequestDto request, T response, ProcessingCallback<T> callback) {
        try {
            if(request == null){
                setResponseErrorAttributes(response, StandardErrorCodes.INVALID_JSON.name(), BankErrorCodes.INVALID_INPUT.getCode());
                return response;
            }
            callback.execute(response);
        } catch (ServiceException | CryptographyException e) {
            response.setRequestId(request.getRequestId());
            if(StandardErrorCodes.NO_DATA_FOUND.name().equals(e.getErrorCode().name())) {
                setResponseErrorAttributes(response, e.getErrorCode().name(), BankErrorCodes.NO_DATA_FOUND.getCode(), e.getParams());
            } else if(StandardErrorCodes.INVALID_TOKEN_STATUS.name().equals(e.getErrorCode().name())) {
                setResponseErrorAttributes(response, e.getErrorCode().name(), BankErrorCodes.INVALID_TOKEN_STATUS.getCode(), e.getParams());
            } else {
                setResponseErrorAttributes(response, e.getErrorCode().name(), BankErrorCodes.INTERNAL_ERROR.getCode(), e.getParams());
            }
            return response;
        } catch (Exception e) {
            setResponseErrorAttributes(response, StandardErrorCodes.INTERNAL_SERVICE_FAILURE.name(), BankErrorCodes.INTERNAL_ERROR.getCode());
        }
        response.setRequestId(request.getRequestId());
        return response;
    }

    protected void setResponseErrorAttributes(CommonTokenResponseDto response, String errorKey, String errorCode, Object... params) {
        response.setCode(errorCode);
        response.setErrorMessage(messageSourceService.getMessage(errorKey, params));
    }

    protected interface ProcessingCallback<T extends CommonTokenResponseDto> {
        void execute(T response) throws ServiceException;
    }
}
