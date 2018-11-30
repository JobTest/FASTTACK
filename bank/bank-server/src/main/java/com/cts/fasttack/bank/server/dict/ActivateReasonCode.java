package com.cts.fasttack.bank.server.dict;

/**
 * @author a.lipavets
 */
public enum ActivateReasonCode {
    /**
     * Cardholder successfully authenticated prior to activation.
     */
    A,
    /**
     * Cardholder successfully authenticated with a customer service agent prior to activation
     */
    C;

    public static ActivateReasonCode getInstance(String key){
        for(ActivateReasonCode reason : values()){
            if(reason.name().equals(key)){
                return reason;
            }
        }
        return null;
    }
}
