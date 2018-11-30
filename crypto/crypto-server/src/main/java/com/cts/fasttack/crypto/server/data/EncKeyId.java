package com.cts.fasttack.crypto.server.data;


import com.cts.fasttack.crypto.client.dict.KeyAlg;
import com.cts.fasttack.crypto.client.dict.KeyType;

/**
 * Содержит атрибуты, идентифицирующие ключ в хранилище ключей - keyType и refCode
 */
public class EncKeyId {

    private KeyType keyType;
    private String refCode;


    public EncKeyId(KeyType keyType, String refCode) {
        this.keyType = keyType;
        this.refCode = refCode;
    }

    public KeyType getKeyType() {
        return keyType;
    }

    public String getRefCode() {
        return refCode;
    }

    public KeyAlg getAlg() {
        return keyType.keyAlg();
    }

    @Override
    public String toString() {
        return "<" + keyType.name() + ", " + refCode + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EncKeyId encKeyId = (EncKeyId) o;

        return (keyType != null ? keyType.equals(encKeyId.keyType) : encKeyId.keyType == null) &&
                (refCode != null ? refCode.equals(encKeyId.refCode) : encKeyId.refCode == null);
    }

    @Override
    public int hashCode() {
        int result = keyType != null ? keyType.hashCode() : 0;
        result = 31 * result + (refCode != null ? refCode.hashCode() : 0);
        return result;
    }

}
