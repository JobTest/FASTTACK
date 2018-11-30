package com.cts.fasttack.common.core.converter;

import java.util.Collection;
import java.util.List;

/**
 * @author Anton Leliuk
 */
public interface Converter<SOURCE, TARGET> extends SimpleConverter<SOURCE, TARGET> {

    void convert(SOURCE source, TARGET target);

    void convertPrimitives(SOURCE source, TARGET target);

    void convert(Collection<SOURCE> sources, Collection<TARGET> targets);

    List<TARGET> convert(Collection<SOURCE> sources);
}
