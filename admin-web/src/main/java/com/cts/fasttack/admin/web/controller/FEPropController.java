package com.cts.fasttack.admin.web.controller;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.fasttack.admin.web.data.JsonResponseWrapper;
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.dto.FEPropDto;
import com.cts.fasttack.admin.web.rest.FEPropertyRestClient;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.admin.web.validation.operation.EntityCreateOperation;
import com.cts.fasttack.admin.web.validation.operation.EntityUpdateOperation;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.common.core.list.QueryResult;

@Controller
@RequestMapping("/feProp")
@PreAuthorize("isAuthenticated()")
public class FEPropController {

    @Autowired
    private FEPropertyRestClient fePropertyRestClient;

    @Autowired
    private AccessLogService accessLogService;

    @PreAuthorize("@aclFEProp.isCanView()")
    @GetMapping("/list.htm")
    public String list() {
        return "feProp/feProp_list";
    }

    @PreAuthorize("@aclFEProp.isCanView()")
    @GetMapping("/view.htm")
    public String view() {
        return "feProp/feProp_view";
    }

    @PreAuthorize("@aclFEProp.isCanCreate()")
    @GetMapping("/new.htm")
    public String createNew() {
        return "feProp/feProp_create";
    }

    @PreAuthorize("@aclFEProp.isCanEdit()")
    @GetMapping("/edit.htm")
    public String edit() {
        return "feProp/feProp_edit";
    }

    @PreAuthorize("@aclFEProp.isCanView()")
    @PostMapping("/filter.json")
    @ResponseBody
    public QueryResult<FEPropDto> filter(@RequestBody ListFilter<FEPropDto> filter) throws ServiceException {
        accessLogService.create().item(ItemType.FEPROP).type(AccessType.VIEW_ALL).fields("sort by: " + filter.getSortField() + ", page" + String.valueOf(filter.getPage())).save();
        return fePropertyRestClient.filterFEProperty(filter);
    }

    @PreAuthorize("@aclFEProp.isCanView()")
    @GetMapping("/item.json")
    @ResponseBody
    public FEPropDto getFEProp(@RequestParam("propName") String propName) throws ServiceException {
        accessLogService.create().item(ItemType.FEPROP).id(propName).type(AccessType.VIEW).save();
        return fePropertyRestClient.getFEProp(propName);
    }

    @PreAuthorize("@aclFEProp.isCanCreate()")
    @PostMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> createFEProp(@Validated({Default.class, EntityCreateOperation.class}) @RequestBody FEPropDto dto) throws ServiceException {
        accessLogService.create().item(ItemType.FEPROP).type(AccessType.CREATE).id(dto.getPropName()).fields(dto.getPropValue()).save();
        fePropertyRestClient.createFEProp(dto);
        return JsonResponseWrapper.success(dto);
    }

    @PreAuthorize("@aclFEProp.isCanEdit()")
    @PutMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> updateFEProp(@Validated({Default.class, EntityUpdateOperation.class}) @RequestBody FEPropDto dto) throws ServiceException {
        accessLogService.create().item(ItemType.FEPROP).type(AccessType.UPDATE).id(dto.getPropName()).fields(dto.getPropValue()).save();
        fePropertyRestClient.updateFEProp(dto);
        return JsonResponseWrapper.success(dto);
    }

    @PreAuthorize("@aclFEProp.isCanDelete()")
    @DeleteMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> deleteFEProp(@RequestParam String propName) throws ServiceException {
        accessLogService.create().item(ItemType.ENC_KEY).id(propName).type(AccessType.DELETE).save();
        fePropertyRestClient.deleteFEProp(propName);
        return JsonResponseWrapper.success(propName);
    }
}
