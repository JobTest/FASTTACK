package com.cts.fasttack.admin.web.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.dict.RandomGenerateSequenceType;
import com.cts.fasttack.admin.web.service.RandomSequenceGenerator;

/**
 * Класс для генерации рандомного набора символов (буквы, цифры) с заданой длиной.
 */
@Component
public class RandomCharacterSequenceGenerator implements RandomSequenceGenerator {

    @Override
    public String generate(int length, RandomGenerateSequenceType type) {
        return RandomStringUtils.random(length, type.isAlpha(), type.isNumeric());
    }

    @Override
    public boolean support(RandomGenerateSequenceType type) {
        return type.equals(RandomGenerateSequenceType.ALPHA_NUMERIC) || type.equals(RandomGenerateSequenceType.NUMERIC);
    }
}
