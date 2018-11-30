package com.cts.fasttack.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.dto.TokenHistoryRowDto;
import com.cts.fasttack.admin.web.data.list.TokenHistoryFilter;
import com.cts.fasttack.admin.web.rest.TokenHistoryRestClient;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * @author Dmitry Koval
 */
@Controller
@RequestMapping("/token/history")
@PreAuthorize("isAuthenticated()")
public class TokenHistoryController {

    @Autowired
    private TokenHistoryRestClient tokenHistoryRestClient;

    @Autowired
    private AccessLogService accessLogService;

    @PreAuthorize("@aclToken.canView")
    @PostMapping("/{tokenRefId}/{tokenRequestorId}/filter.json")
    @ResponseBody
    public QueryResultDto<TokenHistoryRowDto> filter(@RequestBody TokenHistoryFilter<?> filter, @PathVariable String tokenRefId, @PathVariable String tokenRequestorId) throws ServiceException {
        accessLogService.create().item(ItemType.TOKEN_HISTORY).type(AccessType.VIEW_ALL).fields("sort by: " + filter.getSortField() + ", page" + String.valueOf(filter.getPage())).save();
        filter.setTokenRefId(tokenRefId);
        filter.setTokenRequestorId(tokenRequestorId);
        return tokenHistoryRestClient.listTokenHistory(filter);
    }
}
