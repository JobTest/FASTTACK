package com.cts.fasttack.core.dao;

import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.core.data.BinSetup;

public interface BinSetupDao extends GenericDao<Long, BinSetup> {

    /**
     * Выбор нужной конфигурации по принципу от большей длины к меньшей.
     * Например, если для карты 5467437159375016 присутствует записи с двумя бинами со значениями 5467437 и 546743715, то будет возвращена конфигурация для бина 546743715.
     *
     * @param bin номер карты, для которой нужно найти конфигурацию
     * @return bin setup
     */
    BinSetup getSuitableBin(String bin);
}
