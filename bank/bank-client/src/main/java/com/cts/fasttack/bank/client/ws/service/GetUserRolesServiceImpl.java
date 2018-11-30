package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.bank.client.converter.GetUserRolesResponseToJmsGetUserRolesResponseDtoConverter;
import com.cts.fasttack.bank.client.converter.JmsGetUserRolesDtoToDomainConverter;
import com.cts.fasttack.bank.client.exception.WebServiceExceptionHandler;
import com.cts.fasttack.bank.client.ws.client.GetUserRoles;
import com.cts.fasttack.bank.client.ws.client.GetUserRolesResponse;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsGetUserRolesRequestDto;
import com.cts.fasttack.jms.dto.JmsGetUserRolesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service("getUserRolesService")
public class GetUserRolesServiceImpl extends WebServiceClient implements GetUserRolesService {

    @Autowired
    public GetUserRolesServiceImpl(@Qualifier("webServiceTemplate") WebServiceTemplate webServiceTemplate) {
        super(webServiceTemplate);
    }

    @Autowired
    private JmsGetUserRolesDtoToDomainConverter jmsGetUserRolesDtoToDomainConverter;

    @Autowired
    private GetUserRolesResponseToJmsGetUserRolesResponseDtoConverter getUserRolesResponseToJmsGetUserRolesResponseDtoConverter;

    @Override
    public JmsGetUserRolesResponseDto getUserRoles(JmsGetUserRolesRequestDto requestDto) throws ServiceException {
        GetUserRoles request = jmsGetUserRolesDtoToDomainConverter.convert(requestDto);
        return executeWithResponse(() -> getUserRolesResponseToJmsGetUserRolesResponseDtoConverter.convert(
                GetUserRolesResponse.class.cast(
                                webServiceTemplate.marshalSendAndReceive(webServiceTemplate.getDefaultUri() + "/Authentication", request,
                                        new SoapActionCallback("urn:getUserRoles")))
        ), WebServiceExceptionHandler.INSTANCE);
    }
}
