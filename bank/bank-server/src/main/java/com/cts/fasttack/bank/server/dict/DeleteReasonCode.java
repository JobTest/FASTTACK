package com.cts.fasttack.bank.server.dict;

/**
 * @author a.lipavets
 */
public enum DeleteReasonCode {
    /**
     * Account closed
     */
    C,
    /**
     * Issuer or cardholder confirmed fraudulent token transactions
     */
    T,
    /**
     * Other
     */
    Z,
    /**
     * Cardholder confirmed token device lost
     */
    L,
    /**
     * Cardholder confirmed token device stolen
     */
    S,
    /**
     * Issuer or cardholder confirmed fraudulent token transactions
     */
    F;

    public static DeleteReasonCode getInstance(String key){
        for(DeleteReasonCode reason : values()){
            if(reason.name().equals(key)){
                return reason;
            }
        }
        return null;
    }
}
