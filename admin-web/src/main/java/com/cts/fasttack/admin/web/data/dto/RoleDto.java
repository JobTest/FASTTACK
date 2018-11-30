package com.cts.fasttack.admin.web.data.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.crypto.client.dict.Dict;
import com.cts.fasttack.admin.web.service.RoleService;
import com.cts.fasttack.admin.web.validation.common.UniqueIdentifier;
import com.cts.fasttack.admin.web.validation.operation.EntityCreateOperation;
import com.cts.fasttack.admin.web.validation.operation.EntityUpdateOperation;
import com.cts.fasttack.common.core.dto.IdentifierDto;

public class RoleDto extends IdentifierDto<String> implements Dict {

	private static final long serialVersionUID = -8746669293259081077L;

	private boolean _new = false;

    @NotEmpty(message = "{roles.validation.empty.description}")
    private String description = "";

    @NotEmpty(message = "{roles.validation.empty.privileges}")
    private Set<PrivilegeDto> privileges = new HashSet<>();

    @UniqueIdentifier(groups = {EntityCreateOperation.class}, service = RoleService.class, message = "{roles.validation.exist.id}")
    @NotEmpty(groups = {EntityCreateOperation.class, EntityUpdateOperation.class}, message = "{roles.validation.empty.id}")
    public String getId(){
        return super.getId();
    }

    public String getPrivilegeDescriptions() {
        return this.privileges.stream().map(PrivilegeDto::getDescription).collect(Collectors.joining(", "));
    }

    public List<String> getPrivilegeCodes() {
        return this.privileges.stream().map(IdentifierDto::getId).collect(Collectors.toList());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PrivilegeDto> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<PrivilegeDto> privileges) {
        this.privileges = privileges;
    }

    @Override
    public boolean isNew() {
        return _new;
    }

    public void setNew(boolean new_) {
        _new = new_;
    }

    @Override
    public String getKey() {
        return getId();
    }

    @Override
    public String getCaption() {
        return getDescription();
    }
}
