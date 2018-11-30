package com.cts.fasttack.crypto.server.service;

import java.util.Date;

import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.crypto.client.dto.EncKeyRequestResponseDto;
import com.cts.fasttack.crypto.server.data.EncKey;
import com.cts.fasttack.crypto.server.data.EncKeyValueHolder;
import com.cts.fasttack.crypto.client.dict.EncKeyStatus;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.server.dto.EncKeyDto;
import com.cts.fasttack.crypto.server.filter.EncKeyListFilter;

/**
 * Сервис для операций с ключами шифрования.
 *  Описание -  <a href = "https://docs.google.com/document/d/17Buf3zrhZH7-kRvPcLASzZxD8mhp80iTV_zi2mfprps/edit#heading=h.oyhvbd20p1qh"> Криптооперации. Шифрование данных </a>
 */
public interface EncKeyService extends GenericService<Long, EncKeyDto, EncKey> {

    EncKeyValueHolder getKey(KeyType keyType, String refCode);

    /**
     * Возвращает самый активный ключ, у которого максимальная expDate.
     */
    EncKeyValueHolder getActualKey(KeyType keyType);

    /**
     * Возвращает список активных ключей с заданным keyType.
     * Текущая дата попадает в промежуток между effDate и expDate
     * */
    EncKeyValueHolder[] listActiveKeysByType(KeyType type);

    void registerKeySupportService(KeySupportService kss);

    QueryResult<EncKeyRequestResponseDto> listPaged(EncKeyListFilter filter);

    /**
     * Проверяет существование ключа с заданным keyType и refCode
     * */
    boolean existsByParams(KeyType keyType, String refCode);

    EncKeyDto createNew(EncKeyDto dto);

    /**
     * Проверяет ключ на активность
     */
    static boolean isActive(EncKeyDto dto) {
        Date currentDate = new Date();
        return dto.getStatusCode() == EncKeyStatus.ACTIVE
                && (dto.getEffDate() == null || currentDate.after(dto.getEffDate()))
                && (dto.getExpDate() == null || currentDate.before(dto.getExpDate()));

    }
}
