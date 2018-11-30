package com.cts.fasttack.admin.web.data.dict;

import com.cts.fasttack.crypto.client.dict.Dict;

/**
 * @author Anton Leliuk
 */
public enum TokenStatus implements Dict {

    /**
     * Inactive
     */
    I,
    /**
     * Active
     */
    A,
    /**
     * Suspend
     */
    S,
    /**
     * Delete
     */
    D;


    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getCaption() {
        return name();
    }

    public boolean isInactive(){
        return this == I;
    }

    public boolean isActivate(){
        return this == A;
    }

    public boolean isSuspend(){
        return this == S;
    }

    public boolean isDelete(){
        return this == D;
    }
}
