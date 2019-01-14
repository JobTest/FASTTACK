package com.cts.fasttack.admin.web.controller;

import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.dto.TokenInfoListDto;
import com.cts.fasttack.admin.web.data.list.CardReplacementFilter;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.admin.web.service.CardService;
import com.cts.fasttack.admin.web.validation.operation.CardReplacementExistsOperation;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.groups.Default;

/**
 * Controller for Card Information
 */
@Controller
@RequestMapping("/card")
@PreAuthorize("isAuthenticated()")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private AccessLogService accessLogService;

    @PreAuthorize("@aclCard.canView")
    @GetMapping("/replacement.htm")
    public String list() {
        return "card/card_replacement";
    }

    @PreAuthorize("@aclCard.canView")
    @GetMapping("/confirm_view.htm")
    public String confirmView(){
        return "card/confirm_view";
    }

    @PreAuthorize("@aclCard.canUpdate")
    @PostMapping("/replacement.json")
    @ResponseBody
    public QueryResultDto<TokenInfoListDto> replacement(@Validated({Default.class, CardReplacementExistsOperation.class}) @RequestBody CardReplacementFilter filter) throws ServiceException {
        accessLogService.create()
                .item(ItemType.TOKEN_INFO)
                .type(AccessType.VIEW_ALL)
                .fields("sort by: " + filter.getSortField() + ", page" + String.valueOf(filter.getPage()))
                .save();

        return cardService.replacement(filter);
    }

}
