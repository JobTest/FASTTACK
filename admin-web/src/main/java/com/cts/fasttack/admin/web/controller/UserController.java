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
import com.cts.fasttack.admin.web.data.dto.UserDto;
import com.cts.fasttack.admin.web.data.list.UserListFilter;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.admin.web.validation.operation.EntityCreateOperation;
import com.cts.fasttack.admin.web.validation.operation.EntityPasswordCheckHistoryOperation;
import com.cts.fasttack.admin.web.validation.operation.EntityPasswordRequiredOperation;
import com.cts.fasttack.admin.web.validation.operation.EntityUpdateOperation;
import com.cts.fasttack.admin.web.validation.operation.UsernameExistsOperation;
import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.list.QueryResult;

@Controller
@RequestMapping("/user")
@PreAuthorize("isAuthenticated()")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccessLogService accessLogService;

    @PreAuthorize("@aclUser.isCanView()")
    @GetMapping("/list.htm")
    public String list() {
        return "user/user_list";
    }

    @PreAuthorize("@aclUser.isCanView()")
    @GetMapping("/view.htm")
    public String view() {
        return "user/user_view";
    }

    @PreAuthorize("@aclUser.isCanCreate()")
    @GetMapping("/new.htm")
    public String create() {
        return "user/user_create";
    }

    @PreAuthorize("@aclUser.isCanEdit()")
    @GetMapping("/edit.htm")
    public String edit() {
        return "user/user_edit";
    }

    @PreAuthorize("@aclUser.isCanView()")
    @PostMapping("/filter.json")
    @ResponseBody
    public QueryResult<UserDto> filter(@RequestBody UserListFilter filter) {
        QueryResult<UserDto> queryResult = userService.listUsers(filter);
        accessLogService.create().item(ItemType.USER).type(AccessType.VIEW_ALL).fields(filter.getUsername(), "sort by: " + filter.getSortField() + ", page" + String.valueOf(filter.getPage())).save();
        return queryResult;
    }

    @PreAuthorize("@aclUser.isCanView()")
    @GetMapping("/item.json")
    @ResponseBody
    public UserDto getUser(@RequestParam String id) throws BusinessLogicException {
        UserDto userDto = userService.get(id);
        accessLogService.create().item(ItemType.USER).id(id).type(AccessType.VIEW).save();
        return userDto;
    }

    @PreAuthorize("@aclUser.isCanCreate()")
    @RequestMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> createUser(@Validated({Default.class, EntityCreateOperation.class, EntityPasswordRequiredOperation.class, UsernameExistsOperation.class}) @RequestBody UserDto dto) throws BusinessLogicException {
        UserDto saved = userService.createUser(dto);
        accessLogService.create()
                .item(ItemType.USER)
                .id(saved.getId())
                .type(AccessType.CREATE)
                .fields(saved.getName(), saved.getPhone(), saved.getStatus().name(), saved.getUsername());
        return JsonResponseWrapper.success(saved);
    }

    @PreAuthorize("@aclUser.isCanEdit()")
    @PutMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> updateUser(@Validated @RequestBody UserDto dto) throws BusinessLogicException {
        UserDto saved = userService.save(dto);
        accessLogService.create()
                .item(ItemType.USER)
                .id(saved.getId())
                .type(AccessType.UPDATE)
                .fields(saved.getName(), saved.getPhone(), saved.getStatus().name(), saved.getUsername())
                .save();
        return JsonResponseWrapper.success(saved);
    }

    @PreAuthorize("@aclUser.isCanDelete()")
    @DeleteMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> deleteUser(@RequestParam String id) throws BusinessLogicException {
        userService.delete(id);
        accessLogService.create().item(ItemType.USER).id(id).type(AccessType.DELETE).save();
        return JsonResponseWrapper.success(id);
    }

    @PreAuthorize("@aclUser.isCanChangePassword()")
    @PutMapping("/changePassword.json")
    @ResponseBody
    public UserDto changePassword(@Validated({EntityUpdateOperation.class, EntityPasswordRequiredOperation.class, EntityPasswordCheckHistoryOperation.class}) @RequestBody UserDto dto) {
        boolean result = userService.changePassword(dto.getId(), dto.getPassword());
        if (result) {
            accessLogService.create().item(ItemType.USER).id(dto.getId()).type(AccessType.UPDATE).fields(dto.getPassword()).save();
        }
        return dto;
    }
}
