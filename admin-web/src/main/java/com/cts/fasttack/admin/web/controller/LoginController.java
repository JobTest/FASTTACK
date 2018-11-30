package com.cts.fasttack.admin.web.controller;

import com.cts.fasttack.admin.web.data.menu.MenuItem;
import com.cts.fasttack.admin.web.data.menu.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.fasttack.admin.web.data.JsonResponseWrapper;
import com.cts.fasttack.admin.web.data.dto.UserDto;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.admin.web.validation.operation.EntityPasswordCheckHistoryOperation;
import com.cts.fasttack.admin.web.validation.operation.EntityPasswordRequiredOperation;
import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.exception.ServiceException;

import java.util.Optional;

/**
 * @author Anton Leliuk
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping("/login.htm")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/accessDenied.htm")
    public String accessDenied() {
        return "accessDenied";
    }

    @GetMapping(value = "/restorePassword/username.json")
    @ResponseBody
    public JsonResponseWrapper<?> findUserAndSendSms(@RequestParam String username) throws ServiceException, BusinessLogicException {
        userService.createRestorePasswordSmsCode(username);
        return JsonResponseWrapper.success(true);
    }

    @GetMapping(value = "/restorePassword/sms.json")
    @ResponseBody
    public JsonResponseWrapper<?> checkSms(@RequestParam String username, @RequestParam String smsCode) throws BusinessLogicException {
        return JsonResponseWrapper.result(userService.checkRestorePasswordSmsCode(username, smsCode));
    }

    @PostMapping("/restorePassword/restore.json")
    @ResponseBody
    public JsonResponseWrapper<?> restorePassword(@Validated(value = {EntityPasswordCheckHistoryOperation.class, EntityPasswordRequiredOperation.class}) @RequestBody UserDto dto) throws BusinessLogicException {
        return JsonResponseWrapper.result(userService.resetPassword(dto.getUsername(), dto.getPassword()));
    }

    @GetMapping("/login/success")
    @PreAuthorize("isAuthenticated()")
    public String success() {
        Optional<MenuItem> item = menuItemRepository.getItems().stream().filter(menuItem -> menuItem.getAcl().isCanView()).findFirst();
        return "redirect:" + (item.isPresent() ? item.get().getUrl() : "/accessDenied.htm");
    }
}
