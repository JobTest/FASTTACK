package com.cts.fasttack.crypto.client.dict;

/**
 * List values for field Wrapping Key
 */
public enum WrappingKey implements Dict {

    LMK1, LMK2, LMK3;

    @Override
    public String getKey() {
        return this.name();
    }

    @Override
    public String getCaption() {
        return this.name();
    }
}
