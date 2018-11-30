package com.cts.fasttack.admin.web.data.list;

import java.util.List;

import com.cts.fasttack.admin.web.data.domain.Role;
import com.cts.fasttack.common.core.list.ListFilter;

public class RoleListFilter extends ListFilter<Role> {

    private String id;

    private List<String> roleCodes;

    public class RoleListFilterBuilder extends ListFilterBuilder<RoleListFilterBuilder, RoleListFilter> {

        public RoleListFilterBuilder roleCodes(List<String> roleCodes) {
            RoleListFilter.this.roleCodes = roleCodes;
            return this;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getRoleCodes() {
        return roleCodes;
    }

    public void setRoleCodes(List<String> roleCodes) {
        this.roleCodes = roleCodes;
    }

    public static RoleListFilterBuilder builder() {
        return new RoleListFilter().new RoleListFilterBuilder();
    }
}
