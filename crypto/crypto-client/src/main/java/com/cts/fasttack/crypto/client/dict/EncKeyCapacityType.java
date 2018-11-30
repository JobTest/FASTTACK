package com.cts.fasttack.crypto.client.dict;

/**
 * T – test key / P – production key
*/
public enum EncKeyCapacityType implements Dict {

    /**
     * Test key
     */
    T,
    /**
     * Production key
     */
    P;

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getCaption() {
        return name();
    }

    public static EncKeyCapacityType getInstance(String source) {
        for (EncKeyCapacityType item : EncKeyCapacityType.values()) {
            if (item.name().equals(source)) {
                return item;
            }
        }
        return null;
    }
}
