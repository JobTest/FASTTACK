package com.cts.fasttack.core.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.core.data.DCProgress;

/**
 * @author Dmitry Koval
 */
@Repository
public class DCProgressDaoImpl extends GenericDaoImpl<Long, DCProgress> implements DCProgressDao {

    @Override
    public Class<DCProgress> getEntityClass() {
        return DCProgress.class;
    }

    @Override
    @Autowired
    protected void setSessionFactory(@Qualifier("h2SessionFactory") SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void deleteExpireAndFinishedDCProgress(Integer expireDays) {
        getSession().createQuery("DELETE FROM com.cts.fasttack.core.data.DCProgress dc WHERE dc.eventDate > :expireDays")
                .setParameter("expireDays", Date.from(LocalDate.now().minusDays(expireDays).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .executeUpdate();

    }

    @Override
    public DCProgress get(String requestId, String correlationId, String tokenRequestorId) {
        return (DCProgress)getSession().createCriteria(getEntityClass())
            .add(Restrictions.and(
                    Restrictions.eq("requestId", requestId),
                    Restrictions.eq("correlationId", correlationId),
                    Restrictions.eq("tokenRequestorId", tokenRequestorId)))
                .addOrder(Order.asc("eventDate"))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public DCProgress get(String correlationId) {
        return (DCProgress) getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("correlationId", correlationId))
                .addOrder(Order.asc("eventDate"))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public boolean tryLock(long id) {
        return getSession().createQuery("UPDATE DCProgress dc SET dc.lock=true WHERE dc.id=:id AND dc.lock=false")
                .setParameter("id", id)
                .executeUpdate() != 0;
    }
}
