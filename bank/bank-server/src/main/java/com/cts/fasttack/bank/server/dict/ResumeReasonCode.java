package com.cts.fasttack.bank.server.dict;

/**
 * @author a.lipavets
 */
public enum ResumeReasonCode {
    /**
     * Issuer or cardholder confirmed no fraudulent token transactions
     */
    T,
    /**
     * Other
     */
    Z,
    /**
     * Cardholder reported token device found or not stolen
     */
    F;

    public static ResumeReasonCode getInstance(String key){
        for(ResumeReasonCode reason : values()){
            if(reason.name().equals(key)){
                return reason;
            }
        }
        return null;
    }
}
