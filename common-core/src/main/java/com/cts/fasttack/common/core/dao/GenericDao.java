package com.cts.fasttack.common.core.dao;

import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.common.core.list.ListFilter;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;


/**
 * @author Anton Leliuk
 */
public interface GenericDao<T extends Serializable, I extends Identifiable<?>> extends Dao {

    Class<I> getEntityClass();

    I get(T id);

    I save(I item);

    void delete(I item);

    void delete(I entity, String entityName);

    List<I> list();

    List<I> list(ListFilter<I> filter);

    Iterator<I> scroll(ListFilter<I> filter);

    boolean isExists(T id);

    int countAll();

}
