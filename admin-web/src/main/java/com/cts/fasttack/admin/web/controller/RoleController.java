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
import com.cts.fasttack.admin.web.data.dto.RoleDto;
import com.cts.fasttack.admin.web.data.list.RoleListFilter;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.admin.web.service.RoleService;
import com.cts.fasttack.admin.web.validation.operation.EntityCreateOperation;
import com.cts.fasttack.admin.web.validation.operation.EntityUpdateOperation;
import com.cts.fasttack.common.core.list.QueryResult;

@Controller
@RequestMapping("/role")
@PreAuthorize("isAuthenticated()")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private AccessLogService accessLogService;

    @PreAuthorize("@aclRole.isCanView()")
    @GetMapping("/list.htm")
    public String list() {
        return "role/role_list";
    }

    @PreAuthorize("@aclRole.isCanView()")
    @GetMapping("/view.htm")
    public String view() {
        return "role/role_view";
    }

    @PreAuthorize("@aclRole.isCanCreate()")
    @GetMapping("/new.htm")
    public String createNew() {
        return "role/role_create";
    }

    @PreAuthorize("@aclRole.isCanEdit()")
    @GetMapping("/edit.htm")
    public String edit() {
        return "role/role_edit";
    }

    @PreAuthorize("@aclRole.isCanView()")
    @PostMapping("/filter.json")
    @ResponseBody
    public QueryResult<RoleDto> filter(@RequestBody RoleListFilter filter) {
        accessLogService.create().item(ItemType.ROLE).type(AccessType.VIEW_ALL).fields("sort by: " + filter.getSortField() + ", page" + String.valueOf(filter.getPage())).save();
        return roleService.list(filter);
    }

    @PreAuthorize("@aclRole.isCanView()")
    @GetMapping("/item.json")
    @ResponseBody
    public RoleDto getRole(@RequestParam String id) {
        accessLogService.create().item(ItemType.ROLE).id(id).type(AccessType.VIEW).save();
        return roleService.get(id);
    }

    @PreAuthorize("@aclRole.isCanCreate()")
    @PostMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> createRole(@Validated({Default.class, EntityCreateOperation.class}) @RequestBody RoleDto dto) {
        RoleDto saved = roleService.createRole(dto);
        accessLogService.create().item(ItemType.ROLE).id(saved.getId()).type(AccessType.CREATE).fields(saved.getDescription()).save();
        return JsonResponseWrapper.success(saved);
    }

    @PreAuthorize("@aclRole.isCanEdit()")
    @PutMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> updateRole(@Validated({Default.class, EntityUpdateOperation.class}) @RequestBody RoleDto dto) {
        accessLogService.create().item(ItemType.ROLE).id(dto.getId()).type(AccessType.UPDATE).fields(dto.getDescription()).save();
        return JsonResponseWrapper.success(roleService.save(dto));
    }

    @PreAuthorize("@aclRole.isCanDelete()")
    @DeleteMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> deleteRole(@RequestParam String id) {
        accessLogService.create().item(ItemType.ROLE).id(id).type(AccessType.DELETE).save();
        roleService.delete(id);
        return JsonResponseWrapper.success(id);
    }
}
