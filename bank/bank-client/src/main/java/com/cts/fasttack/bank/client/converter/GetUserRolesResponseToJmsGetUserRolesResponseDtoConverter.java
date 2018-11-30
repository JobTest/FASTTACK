package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.bank.client.ws.client.GetUserRolesResponse;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsGetUserRolesResponseDto;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetUserRolesResponseToJmsGetUserRolesResponseDtoConverter extends AbstractConverter<GetUserRolesResponse, JmsGetUserRolesResponseDto> {
    @Override
    protected JmsGetUserRolesResponseDto generateTarget() {
        return new JmsGetUserRolesResponseDto();
    }

    @Override
    protected void lightConvert(GetUserRolesResponse source, JmsGetUserRolesResponseDto target) {
        List<String> userRoles = source.getUserRoles().stream()
                .map(value -> value.getValue())
                .collect(Collectors.toList());
        target.setUserRoles(new Gson().toJson(userRoles));

        if (source.getTraidPointType()!=null)
            target.setTraidPointType(source.getTraidPointType().getValue());
    }
}
