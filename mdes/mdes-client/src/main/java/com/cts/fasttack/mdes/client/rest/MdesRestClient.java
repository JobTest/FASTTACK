package com.cts.fasttack.mdes.client.rest;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClient;
import com.cts.fasttack.jms.dto.TokenSearchResponseWrapper;
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

/**
 * @author Anton Leliuk
 */
public interface MdesRestClient extends RestClient {

    String SYSTEM_STATUS_ENDPOINT = "/systemstatus";
    String TOKEN_ACTIVATE_ENDPOINT = "/token/activate";
    String TOKEN_SUSPEND_ENDPOINT = "/token/suspend";
    String TOKEN_UNSUSPEND_ENDPOINT = "/token/unsuspend";
    String TOKEN_UPDATE_ENDPOINT = "/token/update";
    String TOKEN_DELETE_ENDPOINT = "/token/delete";
    String TOKEN_SEARCH_ENDPOINT = "/search";

    SystemStatusResponseDto systemStatus() throws ServiceException;

    TokenActivateResponseWrapper tokenActivate(TokenActivateRequestDto requestDto) throws ServiceException;

    TokenSuspendResponseWrapper tokenSuspend(TokenSuspendRequestDto requestDto) throws ServiceException;

    TokenUnsuspendResponseWrapper tokenUnsuspend(TokenUnsuspendRequestDto requestDto) throws ServiceException;

    TokenUpdateResponseWrapper tokenUpdate(TokenUpdateRequestDto requestDto) throws ServiceException;

    TokenDeleteResponseWrapper tokenDelete(TokenDeleteRequestDto requestDto) throws ServiceException;

    TokenSearchResponseWrapper tokenSearch(TokenSearchRequestDto requestDto) throws ServiceException;

}
