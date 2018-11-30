package com.cts.fasttack.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.logging.domain.filter.ChangeLogFilter;
import com.cts.fasttack.logging.dto.ChangeLogDto;
import com.cts.fasttack.logging.service.ChangeLogService;

@Controller
@RequestMapping("/changeLog")
@PreAuthorize("isAuthenticated()")
public class ChangeLogController {

    @Autowired
    private ChangeLogService changeLogService;

    @Autowired
    private AccessLogService accessLogService;

    @PreAuthorize("@aclChangeLog.isCanView()")
    @RequestMapping(value = "/list.htm", method = RequestMethod.GET)
    public String list() {
        return "logs/changeLog";
    }

    @PreAuthorize("@aclChangeLog.isCanView()")
    @RequestMapping(value = "/filter.json", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public QueryResult<ChangeLogDto> filter(@RequestBody ChangeLogFilter filter) {
        accessLogService.create().item(ItemType.CHANGE_LOG).type(AccessType.VIEW_ALL)
                .fields(filter.getAction(),
                        filter.getItemId(),
                        filter.getItemType(),
                        String.valueOf(filter.getDateFrom()) + "-" +String.valueOf(filter.getDateTill()),
                        "sort by: " + filter.getSortField() + ", page" + String.valueOf(filter.getPage())).save();
        return changeLogService.list(filter);
    }


}
