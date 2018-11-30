package com.cts.fasttack.common.core.dict;

/**
 * @author Dmitry Koval
 */
public enum TokenEventStatus {
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

    public static TokenEventStatus getInstance(String name) {
        try {
            return TokenEventStatus.valueOf(name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
