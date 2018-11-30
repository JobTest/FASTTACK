package com.cts.fasttack.admin.web.util;

import com.cts.fasttack.admin.web.dao.UserPasswordHistoryDao;
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.dict.UserStatus;
import com.cts.fasttack.admin.web.data.domain.UserPasswordHistory;
import com.cts.fasttack.admin.web.data.dto.RoleDto;
import com.cts.fasttack.admin.web.data.dto.UserDto;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.admin.web.service.RoleService;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.logging.service.CallingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Date;
import com.google.gson.Gson;

@Component
public class AlfaBankAuthenticationHelper {

    @Value("${ldap.provider.alfa-bank:false}")
    private Boolean isLdapFromAlfaBank;

    @Value("${ldap.provider.alfa-bank.reclaimUsers:true}")
    private Boolean isReclaimUsersFromAlfaBank;

    @Autowired
    private AccessLogService accessLogService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserPasswordHistoryDao userPasswordHistoryDao;

    @Autowired
    private CallingContext callingContext;

    @Transactional
    public void deleteCurrentUser() {
        UserAuthoritiesDto userAuthorities = userService.getCurrentUser();
        if (userAuthorities!=null) {
            String currentUser = userAuthorities.getName();

            userService.delete(currentUser);
            for (UserPasswordHistory userPasswordHistory : userPasswordHistoryDao.listUsernameHistories(currentUser)) userPasswordHistoryDao.delete(userPasswordHistory);
        }
    }

    public void saveOrUpdate(String username, String password, List<String> roles) {
        Set<RoleDto>       roleDtos = getUserRoles(roles);
        Optional<UserDto> existUser = getUser(username);
        UserDto          createUser = createUser(username, password, roleDtos);

        saveOrUpdate(existUser, createUser, password, roleDtos);
    }

    public List<String> getUserRoles(String jsonUserRoles) {
        List<String> userRoles = new Gson().fromJson(jsonUserRoles, ArrayList.class);

        return userRoles.stream()
                .filter(userRole -> { try { return roleService.isExists(userRole); } catch (ServiceException e) { } return false; })
                .collect(Collectors.toList());
    }

    public boolean isLdapFromAlfaBank() {
        return isLdapFromAlfaBank;
    }

    public boolean isReclaimUsersFromAlfaBank() {
        return isLdapFromAlfaBank && isReclaimUsersFromAlfaBank;
    }

    private void saveOrUpdate(Optional<UserDto> existUser, UserDto createUser, String password, Set<RoleDto> roleDtos) {
        if (existUser.isPresent()) {
            UserDto saved = existUser.get();

            String passwordEncode = DigestEncoderHelper.encode(password, saved.getUsername());
            boolean isPasswordEqualsForUser = userService.isPasswordEqualsForUser(saved.getUsername(), passwordEncode);
            if (!isPasswordEqualsForUser) {
                userService.changePassword(saved.getUsername(), password);
            }

            boolean equalsRoles = equalsRole(saved.getRoles(), roleDtos);
            if (!equalsRoles) {
                callingContext.setContext("USER");
                saved.setRoles(roleDtos);
                saved = userService.save(saved);
                accessLogService.create()
                        .item(ItemType.USER)
                        .id(saved.getId())
                        .type(AccessType.UPDATE)
                        .fields(saved.getName(), saved.getPhone(), saved.getStatus().name(), saved.getUsername());
            }
        } else {
            UserDto saved = userService.createUser(createUser);
            accessLogService.create()
                    .item(ItemType.USER)
                    .id(saved.getId())
                    .type(AccessType.CREATE)
                    .fields(saved.getName(), saved.getPhone(), saved.getStatus().name(), saved.getUsername());
        }
    }

    private Optional<UserDto> getUser(String username) {
        try {
            return Optional.ofNullable(userService.get(username));
        } catch (BusinessLogicException ex) {
            return Optional.empty();
        }
    }

    private Set<RoleDto> getUserRoles(List<String> roles) {
        Set<RoleDto> roleDtos = new HashSet<>();
        for (String role: roles) {
            Optional<RoleDto> roleDto = Optional.ofNullable(roleService.get(role));
            if (roleDto.isPresent()) roleDtos.add(roleDto.get());
        }
        return roleDtos;
    }

    private UserDto createUser(String username, String password, Set<RoleDto> roles) {
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(password);
        userDto.setName(username);
        userDto.setStatus(UserStatus.ACTIVE);
        userDto.setPwdchDate(new Date());
        userDto.setLastlogonDate(new Date());
        userDto.setRoles(roles);
        return userDto;
    }

    private boolean equalsRole(Set<RoleDto> roles1, Set<RoleDto> roles2) {
        List<String> keyRoles1 = roles1.stream()
                .map(role -> role.getKey())
                .collect(Collectors.toList());

        List<String> keyRoles2 = roles2.stream()
                .map(role -> role.getKey())
                .collect(Collectors.toList());

        return keyRoles1.equals(keyRoles2);
    }
}