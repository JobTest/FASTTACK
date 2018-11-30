package com.cts.fasttack.common.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.cts.fasttack.common.core.data.Identifiable;

/**
 * @author Anton Leliuk
 */
public class AbstractDao implements Dao {

    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void flushSession() {
        getSession().flush();
    }

    @Override
    public void clearSession() {
        getSession().clear();
    }

    protected PageCriteria createPageCriteria(Class<?> clazz) {
        return PageCriteria.createCriteria(getSession(), clazz);
    }

    protected PageCriteria createPageCriteria(Class<?> clazz, String alias) {
        return PageCriteria.createCriteria(getSession(), clazz, alias);
    }

    public Identifiable<?> merge(Identifiable<?> entity) {
        return (Identifiable<?>) getSession().merge(entity);
    }

    protected void saveEntity(Identifiable<?> entity) {
        save(null, entity);
    }

    public void save(String entityName, Identifiable<?> entity) {
        if (entity.isNew()) {
            getSession().save(entityName, entity);
        } else {
            Object merged = getSession().merge(entityName, entity);
            getSession().saveOrUpdate(entityName, merged);
        }
    }

    @Autowired
    protected void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
