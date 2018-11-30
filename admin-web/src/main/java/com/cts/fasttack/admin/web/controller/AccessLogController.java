package com.cts.fasttack.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.fasttack.admin.web.data.dto.AccessLogDto;
import com.cts.fasttack.admin.web.data.filter.AccessLogFilter;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.common.core.list.QueryResult;

@Controller
@RequestMapping("/accessLog")
@PreAuthorize("isAuthenticated()")
public class AccessLogController {

    @Autowired
    private AccessLogService accessLogService;

    @PreAuthorize("@aclAccessLog.isCanView()")
    @RequestMapping(value = "/list.htm", method = RequestMethod.GET)
    public String list() {
        return "accessLog/accessLog_list";
    }

    @PreAuthorize("@aclAccessLog.isCanView()")
    @RequestMapping(value = "/filter.json", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public QueryResult<AccessLogDto> filter(@RequestBody AccessLogFilter filter) {
        return accessLogService.listPaged(filter);
    }

}
