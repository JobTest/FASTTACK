package com.cts.fasttack.admin.web.security.service;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;

public interface CurrentUserService {

    default UserAuthoritiesDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            return ((UserAuthoritiesDto) authentication.getPrincipal());
        }
        return null;
    }
}
