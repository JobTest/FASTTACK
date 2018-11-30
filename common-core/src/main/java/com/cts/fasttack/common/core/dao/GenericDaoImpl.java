package com.cts.fasttack.common.core.dao;

import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.common.core.util.ObjectUtil;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * @author Anton Leliuk
 */
public abstract class GenericDaoImpl<T extends Serializable, I extends Identifiable<T>> extends AbstractDao implements GenericDao<T, I> {

    @Override
    public I get(T id) {
        return (I) getSession().get(getEntityClass(), id);
    }

    @Override
    public I save(I entity) {
        saveEntity(entity);
        return entity;
    }

    @Override
    public boolean isExists(T id) {
        return isExists(
                getSession().createCriteria(getEntityClass()).add(Restrictions.eq("id", id))
        );
    }

    protected boolean isExists(Criteria c) {
        return c.setProjection(Projections.id())
                .setMaxResults(1)
                .uniqueResult() != null;
    }

    @Override
    public void delete(I entity) {
        getSession().delete(entity);
    }

    @Override
    public void delete(I entity, String entityName) {
        getSession().delete(entityName, entity);
    }

    @Override
    public List<I> list() {
        return ObjectUtil.uncheckedCast(getSession().createCriteria(getEntityClass()).list());
    }

    @Override
    public List<I> list(ListFilter<I> filter) {
        return createPageCriteria(getEntityClass()).list(filter);
    }

    @Override
    public Iterator<I> scroll(ListFilter<I> filter) {
        return createPageCriteria(getEntityClass()).scroll(filter);
    }

    @Override
    public int countAll() {
        return ((Number) getSession().createCriteria(getEntityClass())
                .setProjection(Projections.count("id"))
                .uniqueResult()).intValue();
    }

}
