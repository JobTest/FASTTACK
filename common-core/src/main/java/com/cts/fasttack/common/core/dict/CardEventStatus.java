package com.cts.fasttack.common.core.dict;

public enum CardEventStatus {
    ACTIVATE,
    UPDATE_PAN,
    UPDATE_EXP,
    UPDATE,
    SUSPEND,
    RESUME,
    DELETE;


    public boolean isActive() {
        return this == ACTIVATE;
    }

    public boolean isResume(){
        return this == RESUME;
    }

    public static CardEventStatus getInstance(String name) {
        try {
            return CardEventStatus.valueOf(name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
