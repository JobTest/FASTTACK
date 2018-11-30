package com.cts.fasttack.core.dict;

/**
 * For {@link com.cts.fasttack.core.data.DCProgress}
 *
 * @author Dmitry Koval
 */
public enum DCProgressStatus {
    SUCCESS,
    DECLINE;

    public boolean isSuccess() {
        return this == SUCCESS;
    }

    public boolean isDecline() {
        return this == DECLINE;
    }
}
