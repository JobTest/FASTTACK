package com.cts.fasttack.visa.vtis.server.dict;

/**
 * @author Dmitry Koval
 */
public enum EventType {
    TOKEN_CREATED,
    TOKEN_STATUS_UPDATED;

    public boolean isTokenCreated(){
        return this == TOKEN_CREATED;
    }

    public boolean isTokenStatusUpdated(){
        return this == TOKEN_STATUS_UPDATED;
    }
}
