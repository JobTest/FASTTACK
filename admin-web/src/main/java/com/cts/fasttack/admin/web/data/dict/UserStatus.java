package com.cts.fasttack.admin.web.data.dict;

import com.cts.fasttack.common.core.hibernate.CustomStringEnumeration;
import com.cts.fasttack.crypto.client.dict.Dict;

public enum UserStatus implements Dict, CustomStringEnumeration {

    ACTIVE("00"),
    BLOCKED("01"),
    TEMP_BLOCKED("02");

    private String key;

    UserStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getCaption() {
        return name();
    }


    @Override
    public String getDataBaseValue() {
        return key;
    }

    public boolean isBlocked(){
        return this == BLOCKED;
    }

    public boolean isActive(){
        return this == ACTIVE;
    }
}
