package com.cts.fasttack.common.core.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Anton Leliuk
 */
public abstract class AbstractConverter<S, T> implements Converter<S, T> {

    protected abstract T generateTarget();

    protected abstract void lightConvert(S source, T target);

    public T convert(S source) {
        if (source != null) {
            T target = generateTarget();
            convert(source, target);
            return target;
        }
        return null;
    }

    @Override
    public void convert(S source, T target) {
        lightConvert(source, target);
    }

    @Override
    public void convertPrimitives(S source, T target) {
        throw new UnsupportedOperationException();
    }

    public void convert(Collection<S> sources, Collection<T> targets) {
        if (sources != null) {
            for (S s : sources) {
                T target = generateTarget();
                convert(s, target);
                targets.add(target);
            }
        }
    }

    public List<T> convert(Collection<S> sources) {
        if(sources != null){
            List<T> targets = new ArrayList<>(sources.size());
            convert(sources, targets);
            return targets;
        }
        return new ArrayList<>(1);
    }
}
