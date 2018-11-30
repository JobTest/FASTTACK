package com.cts.fasttack.mdes.client.exception;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.exception.handler.ServiceExceptionHandler;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.mdes.client.dict.MdesErrorCode;
import com.cts.fasttack.mdes.client.dto.MdesErrorDto;
import com.cts.fasttack.mdes.client.dto.MdesErrorResponseDto;
import com.cts.fasttack.mdes.client.dto.MdesErrorsDto;
import org.apache.camel.StringSource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * Rest exception handler for MDES services
 *
 * @author Anton Leliuk
 */
public class MdesExceptionHandler extends ServiceExceptionHandler {

    public static final MdesExceptionHandler INSTANCE = new MdesExceptionHandler();

    private Jaxb2Marshaller marshaller;

    private MdesExceptionHandler(){
        marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.cts.fasttack.mdes.client.dto");
    }

    @Override
    public <RESPONSE> RESPONSE handle(Exception e) throws ServiceException {
        log.error("Error calling MDES service: " + ": " + e.getMessage(), e);

        if(e instanceof HttpStatusCodeException){
            HttpStatusCodeException cee = (HttpStatusCodeException) e;

            String response = cee.getResponseBodyAsString();

            MdesErrorsDto errorsDto = null;
            MediaType mediaType = cee.getResponseHeaders().getContentType();

            if(StringUtils.isNotBlank(response)){
                if(mediaType.isCompatibleWith(MediaType.APPLICATION_JSON)){
                    errorsDto = JsonUtil.fromJson(response, MdesErrorResponseDto.class).getError();
                } else if(mediaType.isCompatibleWith(MediaType.APPLICATION_XML)){
                    errorsDto = ((MdesErrorsDto) marshaller.unmarshal(new StringSource(response)));
                }
            }
            if(errorsDto != null){
                MdesErrorDto mdesErrorDto = errorsDto.getErrors().get(0);
                MdesErrorCode errorCode = MdesErrorCode.getInstance(mdesErrorDto.getReasonCode());


                throw new ServiceException(errorCode,
                        errorCode.getHttpStatus(),
                        errorCode.getHttpStatus().value(),
                        mdesErrorDto.getDescription());
            }

            throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE, cee.getStatusCode(), ExceptionUtils.getMessage(e));
        }
        throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE,  ExceptionUtils.getMessage(e));

    }
}
