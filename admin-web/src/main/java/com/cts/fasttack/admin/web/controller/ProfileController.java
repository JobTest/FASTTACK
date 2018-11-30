package com.cts.fasttack.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.fasttack.admin.web.data.JsonResponseWrapper;
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.dto.ProfileDto;
import com.cts.fasttack.admin.web.data.dto.UserDto;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.common.core.exception.BusinessLogicException;

@Controller
@RequestMapping("/profile")
@PreAuthorize("isAuthenticated()")
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccessLogService accessLogService;

    @GetMapping("/view.htm")
    public String view() {
        return "profile/profile_view";
    }

    @PreAuthorize("@aclUser.isCanEdit()")
    @GetMapping("/edit.htm")
    public String edit() {
        return "profile/profile_edit";
    }

    @GetMapping("/item.json")
    @ResponseBody
    public UserDto getProfile() throws BusinessLogicException {
        return userService.get(userService.getCurrentUser().getId());
    }

    @PreAuthorize("@aclUser.isCanEdit()")
    @PutMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> updateProfile(@RequestBody @Validated final UserDto dto) throws BusinessLogicException {
        accessLogService.create()
                .item(ItemType.USER)
                .id(dto.getId())
                .type(AccessType.UPDATE)
                .fields(dto.getName(), dto.getPhone(), dto.getStatus().name(), dto.getUsername())
                .save();
        return JsonResponseWrapper.success(userService.save(dto));
    }

    @RequestMapping(value = "/changePassword.json", method = RequestMethod.POST)
    @ResponseBody
    public ProfileDto changePassword(@Validated @RequestBody ProfileDto profileDto) {
        boolean result = userService.changePassword(profileDto.getUsername(), profileDto.getNewPassword());
        if (result) {
            accessLogService.create().item(ItemType.USER).id(profileDto.getUsername()).type(AccessType.UPDATE).fields(profileDto.getNewPassword()).save();
        }
        return profileDto;
    }
}
