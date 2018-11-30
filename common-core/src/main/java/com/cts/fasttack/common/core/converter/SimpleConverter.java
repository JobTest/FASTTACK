package com.cts.fasttack.common.core.converter;

/**
 * @author Anton Leliuk
 */
public interface SimpleConverter<SOURCE, TARGET> {

    TARGET convert(SOURCE source);
}
