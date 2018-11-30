package com.cts.fasttack.mdes.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;
import com.cts.fasttack.jms.dto.TokenSearchResponseWrapper;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import com.cts.fasttack.mdes.client.config.MdesRestParameters;
import com.cts.fasttack.mdes.client.dto.SystemStatusResponseDto;
import com.cts.fasttack.mdes.client.dto.TokenActivateRequestDto;
import com.cts.fasttack.mdes.client.dto.TokenActivateResponseWrapper;
import com.cts.fasttack.mdes.client.dto.TokenDeleteRequestDto;
import com.cts.fasttack.mdes.client.dto.TokenDeleteResponseWrapper;
import com.cts.fasttack.mdes.client.dto.TokenSearchRequestDto;
import com.cts.fasttack.mdes.client.dto.TokenSuspendRequestDto;
import com.cts.fasttack.mdes.client.dto.TokenSuspendResponseWrapper;
import com.cts.fasttack.mdes.client.dto.TokenUnsuspendRequestDto;
import com.cts.fasttack.mdes.client.dto.TokenUnsuspendResponseWrapper;
import com.cts.fasttack.mdes.client.dto.TokenUpdateRequestDto;
import com.cts.fasttack.mdes.client.dto.TokenUpdateResponseWrapper;
import com.cts.fasttack.mdes.client.exception.MdesExceptionHandler;

/**
 * @author Anton Leliuk
 */
@Component
public class MdesRestClientImpl extends RestClientImpl implements MdesRestClient {

    @Autowired
    public MdesRestClientImpl(@Qualifier("mdesRestTemplate") RestTemplate restTemplate, MdesRestParameters parameters) {
        super(restTemplate, parameters.getAddress());
    }

    @Override
    @MessageHistoryOperation(connectorClient = "MDES", rawIn = "", responseMediaType = MediaType.APPLICATION_XML_VALUE)
    public SystemStatusResponseDto systemStatus() throws ServiceException {
        return get(SYSTEM_STATUS_ENDPOINT, "", SystemStatusResponseDto.class, MdesExceptionHandler.INSTANCE);
    }

    @Override
    @MessageHistoryOperation(connectorClient = "MDES", rawIn = "#requestDto", responseMediaType = MediaType.APPLICATION_XML_VALUE, maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#requestDto.accountPan)",
            tokenId = "#requestDto != null ? #requestDto.tokenUniqueReference : null")
    public TokenActivateResponseWrapper tokenActivate(TokenActivateRequestDto requestDto) throws ServiceException {
        return post(TOKEN_ACTIVATE_ENDPOINT, requestDto, TokenActivateResponseWrapper.class, MdesExceptionHandler.INSTANCE);
    }

    @MessageHistoryOperation(connectorClient = "MDES", rawIn = "#requestDto", responseMediaType = MediaType.APPLICATION_XML_VALUE, maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#requestDto.accountPan)",
            tokenId = "#requestDto != null ? #requestDto.tokenUniqueReference : null")
    public TokenSuspendResponseWrapper tokenSuspend(TokenSuspendRequestDto requestDto) throws ServiceException {
        return post(TOKEN_SUSPEND_ENDPOINT, requestDto, TokenSuspendResponseWrapper.class, MdesExceptionHandler.INSTANCE);

    }

    @MessageHistoryOperation(connectorClient = "MDES", rawIn = "#requestDto", responseMediaType = MediaType.APPLICATION_XML_VALUE, maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#requestDto.accountPan)",
            tokenId = "#requestDto != null ? #requestDto.tokenUniqueReference : null")
    public TokenUnsuspendResponseWrapper tokenUnsuspend(TokenUnsuspendRequestDto requestDto) throws ServiceException {
        return post(TOKEN_UNSUSPEND_ENDPOINT, requestDto, TokenUnsuspendResponseWrapper.class, MdesExceptionHandler.INSTANCE);
    }

    @Override
    @MessageHistoryOperation(connectorClient = "MDES", rawIn = "#requestDto", responseMediaType = MediaType.APPLICATION_XML_VALUE, maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#requestDto.newAccountPan)",
            tokenId = "#requestDto != null ? #requestDto.tokenUniqueReference : null")
    public TokenUpdateResponseWrapper tokenUpdate(TokenUpdateRequestDto requestDto) throws ServiceException {
        return post(TOKEN_UPDATE_ENDPOINT, requestDto, TokenUpdateResponseWrapper.class, MdesExceptionHandler.INSTANCE);
    }

    @Override
    @MessageHistoryOperation(connectorClient = "MDES", rawIn = "#requestDto", responseMediaType = MediaType.APPLICATION_XML_VALUE, maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#requestDto.accountPan)",
            tokenId = "#requestDto != null ? #requestDto.tokenUniqueReference : null")
    public TokenDeleteResponseWrapper tokenDelete(TokenDeleteRequestDto requestDto) throws ServiceException {
        return post(TOKEN_DELETE_ENDPOINT, requestDto, TokenDeleteResponseWrapper.class, MdesExceptionHandler.INSTANCE);
    }

    @Override
    @MessageHistoryOperation(connectorClient = "MDES", rawIn = "#requestDto", responseMediaType = MediaType.APPLICATION_XML_VALUE, maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#requestDto.accountPan)",
            tokenId = "#requestDto != null ? #requestDto.tokenUniqueReference : null")
    public TokenSearchResponseWrapper tokenSearch(TokenSearchRequestDto requestDto) throws ServiceException {
        return post(TOKEN_SEARCH_ENDPOINT, requestDto, TokenSearchResponseWrapper.class, MdesExceptionHandler.INSTANCE);
    }
}
