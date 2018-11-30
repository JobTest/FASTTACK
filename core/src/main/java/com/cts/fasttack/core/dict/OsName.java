package com.cts.fasttack.core.dict;

/**
 * @author a.lipavets
 */
public enum OsName {
    ANDROID,
    WINDOWS,
    TIZEN,
    IOS,
    BLACKBERRY;


    public static OsName getInstance(String name) {
        for (OsName osName : OsName.values()) {
            if (osName.name().equals(name)) {
                return osName;
            }
        }
        return null;
    }
}
