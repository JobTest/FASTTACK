package com.cts.fasttack.crypto.server.service;

import com.cts.fasttack.crypto.server.data.EncKeyValueHolder;

public interface KeySupportService {

    /**
     * Метод выполняет операции над ключом после его изменения (например, редактирования)
     * */
    void notifyChangeKey(EncKeyValueHolder encKeyHolder, boolean delete);
}
