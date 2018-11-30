package com.cts.fasttack.admin.web.service.impl;

import java.util.Random;

import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.dict.RandomGenerateSequenceType;
import com.cts.fasttack.admin.web.service.RandomSequenceGenerator;

/**
 * Класс для генерации рандомного набора hex символов с заданой длиной.
 * В случае если задается нечетная длина для последовательности генерируем на один символ меньше.
 */
@Component
public class RandomHexSequenceGenerator implements RandomSequenceGenerator {

    private Random random = new Random();

    @Override
    public String generate(int length, RandomGenerateSequenceType type) {
        byte[] bytes = new byte[length / 2];
        random.nextBytes(bytes);
        return Hex.encodeHexString(bytes);
    }

    @Override
    public boolean support(RandomGenerateSequenceType type) {
        return type.equals(RandomGenerateSequenceType.HEX);
    }
}
