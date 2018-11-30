package com.cts.fasttack.admin.web.service;

import com.cts.fasttack.admin.web.data.dto.TokenChangeStatusDto;
import com.cts.fasttack.admin.web.data.dto.TokenUpdateDto;
import com.cts.fasttack.admin.web.data.dto.TokensChangeStatusDto;
import com.cts.fasttack.admin.web.data.dto.TokensUpdateDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsLifecycleTokenResponseDto;
import com.cts.fasttack.jms.dto.TokenLifecycleJmsResponse;
import com.cts.fasttack.jms.dto.UpdateTokenJmsResponse;

/**
 * @author Dmitry Koval
 */
public interface TokenService {

    String TOKEN_LIFECYCLE = "TOKEN_LIFECYCLE";

    /**
     * Update Token
     *
     * @param tokenChangeStatusDto
     * @return
     * @throws ServiceException
     */
    TokenLifecycleJmsResponse tokenLifecycle(TokenChangeStatusDto tokenChangeStatusDto) throws ServiceException;

    /**
     * Update Tokens
     *
     * @param tokensChangeStatusDto
     * @return
     */
    JmsLifecycleTokenResponseDto confirmTokenLifecycle(TokensChangeStatusDto tokensChangeStatusDto) throws ServiceException;

    UpdateTokenJmsResponse tokensUpdate(TokensUpdateDto tokensUpdateDto) throws ServiceException;

    /**
     * Token update Pan
     *
     * @param tokenUpdateDto
     * @return
     * @throws ServiceException
     */
    UpdateTokenJmsResponse tokenUpdate(TokenUpdateDto tokenUpdateDto) throws ServiceException;
}
