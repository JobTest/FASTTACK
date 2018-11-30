package com.cts.fasttack.admin.web.data.list;

import com.cts.fasttack.admin.web.data.domain.User;
import com.cts.fasttack.common.core.list.ListFilter;

public class UserListFilter extends ListFilter<User> {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
