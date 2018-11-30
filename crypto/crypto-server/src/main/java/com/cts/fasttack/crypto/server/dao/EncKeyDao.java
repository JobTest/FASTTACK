package com.cts.fasttack.crypto.server.dao;

import java.util.List;

import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.server.data.EncKey;

/**
 * Дао для операций с ключами шифрования {@link EncKey}.
 */
public interface EncKeyDao extends GenericDao<Long, EncKey> {

    EncKey getByKeyTypeAndRefCode(KeyType keyType, String refCode);

    /**
     * Возвращает самый активный ключ, у которого максимальная expDate.
     */
    EncKey getActualKeyByKeyType(KeyType keyType);

    /**
     * Возвращает список активных ключей с заданным keyType.
     * Текущая дата попадает в промежуток между effDate и expDate
     * */
    List<EncKey> listActiveKeysByType(KeyType keyType);

    /**
     * Проверяет существование ключа с заданным keyType и refCode
     * */
    boolean existsByParams(KeyType keyType, String refCode);
}
