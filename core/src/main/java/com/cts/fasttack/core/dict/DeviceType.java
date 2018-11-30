package com.cts.fasttack.core.dict;

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

    DeviceType(int type) {
        this.type = type;
    }

    public static DeviceType valueOfType(int type) {
        switch (type) {
            case 0:
                return UNKNOWN;
            case 1:
                return MOBILE_PHONE;
            case 2:
                return TABLET;
            case 3:
                return WATCH;
            case 4:
                return MOBILEPHONE_OR_TABLET;
            case 5:
                return OTHER;
        }
        return null;
    }

    private int type;

    public int getType() {
        return type;
    }
}
