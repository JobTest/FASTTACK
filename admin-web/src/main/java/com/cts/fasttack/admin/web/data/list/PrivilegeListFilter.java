package com.cts.fasttack.admin.web.data.list;

import java.util.List;

import com.cts.fasttack.admin.web.data.domain.Privilege;
import com.cts.fasttack.common.core.list.ListFilter;

public class PrivilegeListFilter extends ListFilter<Privilege> {

    private String id;

    private List<String> privilegeCodes;

    public static PrivilegeListFilterBuilder builder() {
        return new PrivilegeListFilter().new PrivilegeListFilterBuilder();
    }

    public class PrivilegeListFilterBuilder extends ListFilterBuilder<PrivilegeListFilterBuilder, PrivilegeListFilter> {

        public PrivilegeListFilterBuilder privilegeCodes(List<String> privilegeCodes) {
            PrivilegeListFilter.this.privilegeCodes = privilegeCodes;
            return this;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getPrivilegeCodes() {
        return privilegeCodes;
    }

    public void setPrivilegeCodes(List<String> privilegeCodes) {
        this.privilegeCodes = privilegeCodes;
    }
}
