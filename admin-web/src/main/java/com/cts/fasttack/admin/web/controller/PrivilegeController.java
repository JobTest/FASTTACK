package com.cts.fasttack.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.fasttack.admin.web.data.domain.Privilege;
import com.cts.fasttack.admin.web.data.dto.PrivilegeDto;
import com.cts.fasttack.admin.web.service.PrivilegeService;
import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.common.core.list.QueryResult;

@Controller
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    @PostMapping("/filter.json")
    @ResponseBody
    public QueryResult<PrivilegeDto> filter(@RequestBody ListFilter<Privilege> filter) {
        return privilegeService.list(filter);
    }

    @GetMapping("/item.json")
    @ResponseBody
    public PrivilegeDto getPrivilege(@RequestParam String id) throws BusinessLogicException {
        return privilegeService.get(id);
    }
}
