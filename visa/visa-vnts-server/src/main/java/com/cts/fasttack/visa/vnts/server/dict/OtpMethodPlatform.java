package com.cts.fasttack.visa.vnts.server.dict;

/**
 * @author a.lipavets
 */
public enum OtpMethodPlatform {
    IOS,
    ANDROID,
    WINDOWS,
    WEB;

    public static OtpMethodPlatform getInstance(String key){
        for(OtpMethodPlatform p : values()){
            if(p.name().equals(key)){
                return p;
            }
        }
        return null;
    }
}
