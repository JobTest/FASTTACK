package com.cts.fasttack.mdes.server.dict;

/**
 * The decision recommended by the Wallet Provider
 *
 * @author Dmitry Koval
 */
public enum RecomendedDecision {

    /**
     * Services request was approved
     */
    APPROVED,

    /**
     * Services request was declined
     */
    DECLINED,

    /**
     * Services request requires additional authentication to be approved
     */
    REQUIRE_ADDITIONAL_AUTHENTICATION;
}
