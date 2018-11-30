package com.cts.fasttack.visa.vtis.server.dict;

/**
 * DeviceType for Visa
 *
 * @author a.lipavets
 */
public enum DeviceType {
    UNKNOWN(0),
    MOBILE_PHONE(1),
    TABLET(2),
    WATCH(3),
    MOBILEPHONE_OR_TABLET(4),

    /**
     * through 99 are undefined
     */
    OTHER(5);

    DeviceType(int code){
        this.code = code;
    }

    private int code;

    public int getCode() {
        return code;
    }
}
