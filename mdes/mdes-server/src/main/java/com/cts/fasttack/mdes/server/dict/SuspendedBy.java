package com.cts.fasttack.mdes.server.dict;

/**
 * Who or what caused the token to be suspended.
 *
 * @author a.lipavets
 */
public enum SuspendedBy {
    /**
     * Suspended by the Issuer.
     */
    ISSUER,
    /**
     * Suspended by the Token Requestor
     */
    TOKEN_REQUESTOR,
    /**
     * Suspended due to the Mobile PIN being locked
     */
    MOBILE_PIN_LOCKED,
    /**
     * Suspended by the Cardholder
     */
    CARDHOLDER
}
