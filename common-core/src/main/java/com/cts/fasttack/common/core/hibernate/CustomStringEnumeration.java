package com.cts.fasttack.common.core.hibernate;

/**
 * Интерфейс необходим для произвольного маппинга значений энумераций на базу данных
 */
public interface CustomStringEnumeration {

    /**
     * @return Значение, которое будет замаплено на базу данных
     */
    String getDataBaseValue();
}
