package com.cts.fasttack.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.dto.TokenChangeStatusDto;
import com.cts.fasttack.admin.web.data.dto.TokenInfoDto;
import com.cts.fasttack.admin.web.data.dto.TokenInfoListDto;
import com.cts.fasttack.admin.web.data.dto.TokenListInfoId;
import com.cts.fasttack.admin.web.data.dto.TokenUpdateDto;
import com.cts.fasttack.admin.web.data.dto.TokensChangeStatusDto;
import com.cts.fasttack.admin.web.data.dto.TokensInfoListDto;
import com.cts.fasttack.admin.web.data.dto.TokensUpdateDto;
import com.cts.fasttack.admin.web.data.list.TokenListFilter;
import com.cts.fasttack.admin.web.rest.TokenInfoRestClient;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.admin.web.service.TokenService;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsLifecycleTokenResponseDto;
import com.cts.fasttack.jms.dto.TokenLifecycleJmsResponse;
import com.cts.fasttack.jms.dto.UpdateTokenJmsResponse;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;

/**
 * Controller for Token Information
 *
 * @author Dmitry Koval
 */
@Controller
@RequestMapping("/token")
@PreAuthorize("isAuthenticated()")
public class TokenController {

    @Autowired
    private TokenInfoRestClient tokenInfoRestClient;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AccessLogService accessLogService;

    @PreAuthorize("@aclToken.canView")
    @GetMapping("/list.htm")
    public String list() {
        return "token/token_list";
    }

    @PreAuthorize("@aclToken.canView")
    @GetMapping("/view.htm")
    public String view() {
        return "token/token_view";
    }

    @PreAuthorize("@aclToken.canView")
    @GetMapping("/confirm_view.htm")
    public String confirmView(){
        return "token/confirm_view";
    }


    @PreAuthorize("@aclToken.canView")
    @PostMapping("/filter.json")
    @ResponseBody
    public QueryResultDto<TokenInfoListDto> filter(@Validated @RequestBody TokenListFilter filter) throws ServiceException {
        accessLogService.create().item(ItemType.TOKEN_INFO).type(AccessType.VIEW_ALL).fields("sort by: " + filter.getSortField() + ", page" + String.valueOf(filter.getPage())).save();
        return tokenInfoRestClient.list(filter);
    }

    @PreAuthorize("@aclToken.canView")
    @GetMapping("/item.json")
    @ResponseBody
    public TokenInfoDto getToken(@RequestParam String tokenRefId, @RequestParam String tokenRequestorId) throws ServiceException {
        accessLogService.create().item(ItemType.TOKEN_INFO).id(tokenRefId).type(AccessType.VIEW).save();
        return tokenInfoRestClient.get(tokenRefId, tokenRequestorId);
    }

    @PreAuthorize("@aclToken.canView and @aclToken.isCanModify(#request.tokenEventStatus)")
    @PostMapping("/lifecycle.json")
    @ResponseBody
    public TokenLifecycleJmsResponse tokenLifecycle(@Validated @RequestBody TokenChangeStatusDto request) throws ServiceException {
        accessLogService.create().item(ItemType.TOKEN_INFO).id(request.getTokenRefId()).type(AccessType.UPDATE_TOKEN_STATUS).save();
        return tokenService.tokenLifecycle(request);
    }

    @PreAuthorize("@aclToken.canView and @aclToken.isCanModify(#request.tokenEventStatus)")
    @PostMapping("/confirmLifecycle.json")
    @ResponseBody
    public JmsLifecycleTokenResponseDto confirmTokenLifecycle(@Validated @RequestBody TokensChangeStatusDto request) throws ServiceException {
        request.getTokens().forEach(item ->
                accessLogService.create().item(ItemType.TOKEN_INFO).id(item.getTokenRefId()).type(AccessType.VIEW_ALL).fields("token reason: " + request.getTokenReason() + ", token event status: " + request.getTokenEventStatus()).save());
        return tokenService.confirmTokenLifecycle(request);
    }

    @PreAuthorize("@aclToken.canView")
    @PostMapping("/confirmList.json")
    @ResponseBody
    public TokensInfoListDto confirm(@RequestBody TokenListInfoId request) throws ServiceException {
        if (request != null && request.getTokens() != null) {
            request.getTokens().forEach(item -> accessLogService.create().item(ItemType.TOKEN_INFO).id(item.getTokenRefId()).type(AccessType.UPDATE_TOKEN_STATUS).save());
        }
        return new TokensInfoListDto(tokenInfoRestClient.listByTokenInfoId(request.getTokens()));
    }


    @PreAuthorize("@aclToken.canUpdate")
    @PostMapping("/update.json")
    @ResponseBody
    @MessageHistoryOperation(connectorClient = "GUI", rawIn = "#request", maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#request.newPan)",
            tokenId = "#request != null ? #request.tokenRefId : null")
    public UpdateTokenJmsResponse tokenComment(@Validated @RequestBody TokenUpdateDto request) throws ServiceException {
        accessLogService.create().item(ItemType.TOKEN_INFO).id(request.getTokenRefId()).type(AccessType.UPDATE).save();
        return tokenService.tokenUpdate(request);
    }

    @PreAuthorize("@aclToken.canUpdate")
    @PostMapping("/confirmUpdate.json")
    @ResponseBody
    public UpdateTokenJmsResponse tokensUpdate(@Validated @RequestBody TokensUpdateDto request) throws ServiceException {
        request.getTokens().forEach(item -> accessLogService.create().id(item.getTokenRefId()).item(ItemType.TOKEN_COMMENT).type(AccessType.VIEW_ALL).fields("comment: " + request.getComment()).save());
        return tokenService.tokensUpdate(request);
    }
}
