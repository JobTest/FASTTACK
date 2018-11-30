package com.cts.fasttack.visa.client.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClient;
import com.cts.fasttack.visa.client.dto.PingRequestDto;
import com.cts.fasttack.visa.client.dto.PingResponseDto;
import com.cts.fasttack.visa.client.dto.TokenInquiryRequestDto;
import com.cts.fasttack.visa.client.dto.TokenInquiryResponseDto;
import com.cts.fasttack.visa.client.dto.TokenLifecycleRequestDto;
import com.cts.fasttack.visa.client.dto.TokenLifecycleResponseDto;

/**
 * @author Anton Leliuk
 */
public interface VisaRestClient extends RestClient {

    String PING_ENDPOINT = "rsrv_VNTSTokenUpdateService/Ping/v1";

    String TOKEN_ACTIVATE_ENDPOINT = "rsrv_VNTSTokenUpdateService/LifeCycle/v1";

    String TOKEN_INQUIRY_ENDPOINT = "rsrv_VNTSTokenUpdateService/Inquiry/v1";

    PingResponseDto ping(PingRequestDto request) throws ServiceException;

    TokenLifecycleResponseDto tokenLifecycle(TokenLifecycleRequestDto request) throws ServiceException;

    TokenInquiryResponseDto tokenInquiry(TokenInquiryRequestDto request) throws ServiceException;
}
