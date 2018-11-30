package com.cts.fasttack.crypto.server.data;

import com.cts.fasttack.crypto.client.dict.KeyType;

/**
 * Данные криптографического ключа.
 * Содержит метод, возвращающий значение ключа.
 */
public interface EncKeyValueHolder {

    KeyType getKeyType();

    String getRefCode();

    String getKeyValue();

    String getPublicExponent();

}
