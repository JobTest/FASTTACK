package com.cts.fasttack.mdes.server.dict;

/**
 * The reason code for why the notification is being sent.
 *
 * @author a.lipavets
 */
public enum ReasonCode {

    STATUS_UPDATE,
    REDIGITIZATION_COMPLETE,
    DELETED_FROM_CONSUMER_APP;

    public boolean isRedigitizationComplete() {
        return this == REDIGITIZATION_COMPLETE;
    }

    public boolean isDeleteFromConsumerApp() {
        return this == DELETED_FROM_CONSUMER_APP;
    }

    public static ReasonCode getInstance(String value) {
        for (ReasonCode reasonCode : ReasonCode.values()) {
            if (reasonCode.name().equals(value)) {
                return reasonCode;
            }
        }
        return null;
    }
}
