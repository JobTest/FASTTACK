package com.cts.fasttack.admin.web.service;

import com.cts.fasttack.admin.web.data.dict.RandomGenerateSequenceType;

public interface RandomSequenceGenerator {

    /**
     * Генерация рандомного набора символов
     */
    String generate(int length, RandomGenerateSequenceType type);

    boolean support(RandomGenerateSequenceType type);
}
