package com.cts.fasttack.mdes.server.dict;

/**
 * The result of the CVC2 validation performed against the value provided by the cardholder
 *
 * @author Dmitry Koval
 */
public enum CvcValidationStatus {

    /**
     * Valid CVC2
     */
    MATCH,

    /**
     * Invalid CVC2
     */
    INVALID,

    /**
     * CVC2 was not processed (issuer temporarily unavailable)
     */
    NOT_PROCESSED;

    public static CvcValidationStatus getInstance(String key){
        for (CvcValidationStatus status : values()) {
            if(status.name().equals(key)){
                return status;
            }
        }
        return null;
    }

}
