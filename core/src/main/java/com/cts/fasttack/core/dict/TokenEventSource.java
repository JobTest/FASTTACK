package com.cts.fasttack.core.dict;

/**
 * @author a.lipavets
 */
public enum TokenEventSource {
    /**
     * Issuer
     */
    IS,

    /**
     * Token Requestor
     */
    TR,

    /**
     * Cardholder through a service offered by the Token Requestor
     */
    CH,

    /**
     * System
     */
    SM
}
