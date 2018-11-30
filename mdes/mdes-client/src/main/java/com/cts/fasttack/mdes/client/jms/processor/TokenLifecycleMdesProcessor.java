package com.cts.fasttack.mdes.client.jms.processor;

import org.apache.camel.Exchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.dict.TokenEventStatus;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.jms.dto.TokenLifecycleIpsJmsMessage;
import com.cts.fasttack.jms.dto.TokenLifecycleMdesJmsResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.mdes.client.converter.JmsLifecycleToTokenDeleteDtoConverter;
import com.cts.fasttack.mdes.client.converter.JmsLifecycleToTokenSuspendDtoConverter;
import com.cts.fasttack.mdes.client.converter.JmsLifecycleToTokenUnsuspendDtoConverter;
import com.cts.fasttack.mdes.client.converter.TokenActivateJmsMessageToRequestDtoConverter;
import com.cts.fasttack.mdes.client.converter.TokenLifecycleResponseToJmsResponseDtoConverter;
import com.cts.fasttack.mdes.client.dto.AbstractTokenLifecycleResponseWrapper;
import com.cts.fasttack.mdes.client.rest.MdesRestClient;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenLifecycleMdesProcessor extends AbstractCamelProcessor<TokenLifecycleIpsJmsMessage, TokenLifecycleMdesJmsResponseDto> {

    private Logger logger = LogManager.getLogger(TokenLifecycleMdesProcessor.class);

	@Autowired
    private MdesRestClient mdesRestClient;

    @Autowired
    private TokenActivateJmsMessageToRequestDtoConverter tokenActivateJmsMessageToRequestDtoConverter;

    @Autowired
    private JmsLifecycleToTokenSuspendDtoConverter jmsLifecycleToTokenSuspendDtoConverter;

    @Autowired
    private JmsLifecycleToTokenUnsuspendDtoConverter jmsLifecycleToTokenUnsuspendDtoConverter;

    @Autowired
    private TokenLifecycleResponseToJmsResponseDtoConverter tokenLifecycleResponseToJmsResponseDtoConverter;

    @Autowired
    private JmsLifecycleToTokenDeleteDtoConverter jmsLifecycleToTokenDeleteDtoConverter;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, TokenLifecycleIpsJmsMessage.class,
                request -> {
                    TokenEventStatus eventStatus = TokenEventStatus.getInstance(request.getJmsTokenActivateIpsDto().getStatus());
                    if (eventStatus != null) {
                        AbstractTokenLifecycleResponseWrapper responseWrapper = null;
                        switch (eventStatus){
                            case ACTIVATE:
                                responseWrapper = mdesRestClient.tokenActivate(tokenActivateJmsMessageToRequestDtoConverter.convert(request));
                                break;
                            case SUSPEND:
                                responseWrapper = mdesRestClient.tokenSuspend(jmsLifecycleToTokenSuspendDtoConverter.convert(request));
                                break;
                            case RESUME:
                                responseWrapper = mdesRestClient.tokenUnsuspend(jmsLifecycleToTokenUnsuspendDtoConverter.convert(request));
                                break;
                            case DELETE:
                                responseWrapper = mdesRestClient.tokenDelete(jmsLifecycleToTokenDeleteDtoConverter.convert(request));
                                break;
                            default:
                                logger.warn("FIXME: EventStatus value '" + eventStatus.name() + "' not supposed to be found here", new Exception());
                                break;
                        }

                        if (responseWrapper != null) {
                            return tokenLifecycleResponseToJmsResponseDtoConverter.convert(responseWrapper.getResponseDto());
                        }
                    }
                    throw new ServiceException(StandardErrorCodes.INVALID_FIELD_VALUE, "eventStatus");
                });
    }
}
