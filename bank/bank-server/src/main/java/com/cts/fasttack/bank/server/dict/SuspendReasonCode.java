package com.cts.fasttack.bank.server.dict;

/**
 * @author a.lipavets
 */
public enum SuspendReasonCode {
    /**
     * Cardholder reported token device lost
     */
    L,
    /**
     * Cardholder reported token device stolen
     */
    S,
    /**
     * Issue or cardholder reported fraudulent token transactions
     */
    T,
    /**
     * Other
     */
    Z;

    public static SuspendReasonCode getInstance(String key){
        for(SuspendReasonCode reason : values()){
            if(reason.name().equals(key)){
                return reason;
            }
        }
        return null;
    }
}

