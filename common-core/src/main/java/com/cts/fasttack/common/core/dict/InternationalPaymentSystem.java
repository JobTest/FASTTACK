package com.cts.fasttack.common.core.dict;

/**
 * For {@link com.cts.fasttack.core.data.DCProgress}
 *
 * @author Dmitry Koval
 */
public enum InternationalPaymentSystem {
    V,
    M;


    public boolean isVisa() {
        return this == V;
    }

    public boolean isMdes() {
        return this == M;
    }

    public static InternationalPaymentSystem getInstance(String key) {
        for (InternationalPaymentSystem ips : values()) {
            if (ips.name().equals(key)) {
                return ips;
            }
        }
        return null;
    }
}
