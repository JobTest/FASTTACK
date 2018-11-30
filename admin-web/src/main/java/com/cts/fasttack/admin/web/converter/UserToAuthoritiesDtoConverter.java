package com.cts.fasttack.admin.web.converter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.domain.Role;
import com.cts.fasttack.admin.web.data.domain.User;
import com.cts.fasttack.admin.web.data.dto.RoleDto;
import com.cts.fasttack.admin.web.security.data.UserAuthoritiesDto;

@Component
public class UserToAuthoritiesDtoConverter extends AbstractUserToDtoConverter<User, UserAuthoritiesDto> {

    @Override
    protected UserAuthoritiesDto generateTarget() {
        return new UserAuthoritiesDto();
    }

    @Override
    protected void lightConvert(User source, UserAuthoritiesDto target) {
        super.lightConvert(source, target);

        Set<GrantedAuthority> authorities = new HashSet<>();
        Set<RoleDto> roles = new HashSet<>(source.getRoles().size());
        for (Role role : source.getRoles()) {
            roles.add(roleToDtoConverter.convert(role));
            authorities.addAll(role.getPrivileges().stream().map(p -> new SimpleGrantedAuthority(p.getId())).collect(Collectors.toList()));
        }
        target.setRoles(roles);
        target.setAuthorities(authorities);
    }

}
