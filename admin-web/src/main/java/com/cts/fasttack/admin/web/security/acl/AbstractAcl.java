package com.cts.fasttack.admin.web.security.acl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.cts.fasttack.common.core.util.ObjectUtil;

public abstract class AbstractAcl implements Acl {

    public boolean isHasPrivilege(Priv priv) {
        return isHasPrivilege(getAuthorities(), priv);
    }

    protected boolean isHasPrivilege(List<GrantedAuthority> authorities, Priv priv) {
        return authorities.parallelStream().anyMatch(a -> priv.getCode().equals(a.getAuthority()));
    }

    private List<GrantedAuthority> getAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ObjectUtil.uncheckedCast((authentication != null ? authentication.getAuthorities() : new ArrayList<GrantedAuthority>()));
    }
}
