package com.cts.fasttack.admin.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.fasttack.admin.web.data.OptionWrapperDto;
import com.cts.fasttack.admin.web.rest.TokenReasonRestClient;
import com.cts.fasttack.common.core.dict.TokenEventStatus;
import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * @author Dmitry Koval
 */
@Controller
@RequestMapping("/tokenReason")
@PreAuthorize("isAuthenticated()")
public class TokenReasonController {

    @Autowired
    private TokenReasonRestClient tokenReasonRestClient;


    @GetMapping("/items.json")
    @ResponseBody
    public List<OptionWrapperDto> listTokenSuspendReason(@RequestParam TokenEventStatus tokenEventStatus) throws ServiceException {
        return tokenReasonRestClient.listByStatus(tokenEventStatus).stream().map(item -> new OptionWrapperDto(String.valueOf(item.getId()), item.getReason())).collect(Collectors.toList());
    }

}
