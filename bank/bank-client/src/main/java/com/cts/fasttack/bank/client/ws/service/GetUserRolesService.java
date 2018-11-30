package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsGetUserRolesRequestDto;
import com.cts.fasttack.jms.dto.JmsGetUserRolesResponseDto;

public interface GetUserRolesService {

    JmsGetUserRolesResponseDto getUserRoles(JmsGetUserRolesRequestDto requestDto) throws ServiceException;
}
