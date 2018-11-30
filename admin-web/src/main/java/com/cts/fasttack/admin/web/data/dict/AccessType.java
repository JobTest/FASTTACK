package com.cts.fasttack.admin.web.data.dict;


import com.cts.fasttack.crypto.client.dict.Dict;

/**
 * Тип действия, совершаемого пользователем в системе
 */
public enum AccessType implements Dict {

    /**
     * Просмотр сущности
     */
    VIEW,
    /**
     * Просмотр списка сущностей
     */
    VIEW_ALL,
    /**
     * Создание сущности
     */
    CREATE,
    /**
     * Изменение сущности
     */
    UPDATE,
    /**
     * Удаление сущности
     */
    DELETE,

    /**
     * Вход в систему
     */
    LOGON,

    /**
     * Изменение статуса токена
     */
    UPDATE_TOKEN_STATUS,

    /**
     * Добавление комметария
     */
    ADD_COMMENT;

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getCaption() {
        return name();
    }


}
