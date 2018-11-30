package com.cts.fasttack.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.fasttack.admin.web.converter.MessageHistoryDtoToMessageHistoryViewableDtoConverter;
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.dto.MessageHistoryViewableDto;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.logging.domain.filter.MessageHistoryListFilter;
import com.cts.fasttack.logging.dto.MessageHistoryDto;
import com.cts.fasttack.logging.service.MessageHistoryService;
import org.apache.commons.lang3.StringUtils;

/**
 * Message history controller.
 *
 * @author v.semerkov
 */
@Controller
@RequestMapping("/messageHistory")
@PreAuthorize("isAuthenticated()")
public class MessageHistoryController {

    @Autowired
    private MessageHistoryService messageHistoryService;

    @Autowired
    private AccessLogService accessLogService;

    @Autowired
    private MessageHistoryDtoToMessageHistoryViewableDtoConverter messageHistoryDtoToMessageHistoryViewableDtoConverter;

    @PreAuthorize("@aclMessageHistory.canView")
    @GetMapping("/list.htm")
    public String list() {
        return "messageHistory/messageHistory_list";
    }

    @PreAuthorize("@aclMessageHistory.isCanView()")
    @RequestMapping(value = "/filter.json", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public QueryResult<MessageHistoryDto> filter(@Validated @RequestBody MessageHistoryListFilter filter) throws ServiceException {
        if(StringUtils.isBlank(filter.getSortField())) {
            filter.setSortField("msgDateIn");
            filter.setAsc(false);
        }

        accessLogService.create().item(ItemType.ENC_KEY).type(AccessType.VIEW_ALL).fields(
                filter.getConnectorClient(),
                filter.getMsgType(),
                String.valueOf(filter.getMsgDateInFrom()) + "-" +String.valueOf(filter.getMsgDateInTill()),
                String.valueOf(filter.getMsgDateOutFrom()) + "-" +String.valueOf(filter.getMsgDateOutTill()),
                filter.getMaskedPan(),
                filter.getPanInternalId(),
                filter.getPanInternalGuid(),
                "sort by: " + filter.getSortField() + ", page" + String.valueOf(filter.getPage())).save();
        return messageHistoryService.list(filter);
    }

    @PreAuthorize("@aclMessageHistory.isCanView()")
    @GetMapping("/view.htm")
    public String view() {
        return "messageHistory/messageHistory_view";
    }

    @PreAuthorize("@aclMessageHistory.isCanView()")
    @GetMapping("/item.json")
    @ResponseBody
    public MessageHistoryViewableDto getMessageHistory(@RequestParam Long id) throws ServiceException {
        accessLogService.create().item(ItemType.MESSAGE_HISTORY).id(String.valueOf(id)).type(AccessType.VIEW).save();
        return messageHistoryDtoToMessageHistoryViewableDtoConverter.convert(messageHistoryService.get(id));
    }
}
