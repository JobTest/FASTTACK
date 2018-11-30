package com.cts.fasttack.crypto.client.dict;

public enum EncKeyStatus implements Dict {

    ACTIVE,
    EXPIRED,
    FUTURE,
    DISABLED;

    @Override
    public String getKey() {
        return this.name();
    }

    @Override
    public String getCaption() {
        return this.name();
    }

    public static EncKeyStatus getInstance(String source) {
        for (EncKeyStatus item : EncKeyStatus.values()) {
            if (item.name().equals(source)) {
                return item;
            }
        }
        return null;
    }
}
