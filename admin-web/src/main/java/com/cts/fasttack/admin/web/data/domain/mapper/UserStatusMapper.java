package com.cts.fasttack.admin.web.data.domain.mapper;

import com.cts.fasttack.admin.web.data.dict.UserStatus;
import com.cts.fasttack.common.core.hibernate.CustomStringEnumerationMapper;

public class UserStatusMapper extends CustomStringEnumerationMapper<UserStatus> {

    @Override
    public Class<UserStatus> returnedClass() {
        return UserStatus.class;
    }
}
