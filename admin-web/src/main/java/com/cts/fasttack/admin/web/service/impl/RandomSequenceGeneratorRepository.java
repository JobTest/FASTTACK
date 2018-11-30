package com.cts.fasttack.admin.web.service.impl;

import java.util.Collection;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import com.cts.fasttack.admin.web.data.dict.RandomGenerateSequenceType;
import com.cts.fasttack.admin.web.service.RandomSequenceGenerator;

/**
 * Класс определяет нужную реализацию RandomGenerateSequence
 */
public class RandomSequenceGeneratorRepository {

    private int length;

    private RandomGenerateSequenceType type;

    private RandomSequenceGenerator randomSequenceGenerator;

    @Autowired
    private Collection<RandomSequenceGenerator> sequences;

    public RandomSequenceGeneratorRepository(RandomGenerateSequenceType type, int length) {
        this.type = type;
        this.length = length;
    }

    @PostConstruct
    public void setDefaultRandomSequenceGenerator() {
        this.randomSequenceGenerator = sequences.stream().filter(s -> s.support(type)).findFirst().orElse(null);
    }

    public String generate() {
        return randomSequenceGenerator.generate(length, type);
    }

    public RandomGenerateSequenceType getType() {
        return type;
    }

    public void setType(RandomGenerateSequenceType type) {
        this.type = type;
    }

    public RandomSequenceGenerator getRandomSequenceGenerator() {
        return randomSequenceGenerator;
    }

    public void setRandomSequenceGenerator(RandomSequenceGenerator randomSequenceGenerator) {
        this.randomSequenceGenerator = randomSequenceGenerator;
    }

    public Collection<RandomSequenceGenerator> getSequences() {
        return sequences;
    }

    public void setSequences(Collection<RandomSequenceGenerator> sequences) {
        this.sequences = sequences;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
