package com.cts.fasttack.core.service;

import java.util.Optional;

import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.core.data.BinSetup;
import com.cts.fasttack.core.dto.BinSetupDto;

public interface BinSetupService extends GenericService<Long, BinSetupDto, BinSetup> {

    /**
     * Создание новой конфигурации
     * @param dto dto конфигурации
     * @return bin setup dto
     */
    BinSetupDto createNew(BinSetupDto dto);

    /**
     * Выбор нужной конфигурации по принципу от большей длины к меньшей.
     * Например, если для карты 5467437159375016 присутствует записи с двумя бинами со значениями 5467437 и 546743715, то будет возвращена конфигурация для бина 546743715.
     *
     * @param bin номер карты, для которой нужно найти конфигурацию
     * @return optional bin setup dto
     */
    Optional<BinSetupDto> getSuitableBin(String bin);
}
