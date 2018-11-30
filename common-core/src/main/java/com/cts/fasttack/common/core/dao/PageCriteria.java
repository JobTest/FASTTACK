package com.cts.fasttack.common.core.dao;

import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.common.core.util.ObjectUtil;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.ResultTransformer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Источник идеи: http://forum.hibernate.org/viewtopic.php?p=2234254#2234254
 * @author Anton Leliuk
 */
public class PageCriteria implements Criteria {

    /**
     * a - запрос, возвращающий список
     * b - запрос, возвращающий полное количество
     * */
    protected Criteria a, b;

    private Set<String> aliases = new HashSet<>();

    private Session session;

    private PageCriteria(Session session, Criteria a, Criteria b) {
        this.a = a;
        this.b = b;
        this.session = session;
    }

    public static PageCriteria createCriteria(Session session, Class<?> clazz) {
        return new PageCriteria(session, session.createCriteria(clazz), session.createCriteria(clazz));
    }

    public static PageCriteria createCriteria(Session session, Class<?> clazz, String alias) {
        return new PageCriteria(session, session.createCriteria(clazz, alias), session.createCriteria(clazz, alias));
    }

    public static PageCriteria createCriteria(Session session, String entityName) {
        return new PageCriteria(session, session.createCriteria(entityName), session.createCriteria(entityName));
    }

    public static PageCriteria createCriteria(Session session, String entityName, String alias) {
        return new PageCriteria(session, session.createCriteria(entityName, alias), session.createCriteria(entityName, alias));
    }

    @Override
    public String getAlias() {
        return a.getAlias();
    }

    @Override
    public Criteria setProjection(Projection projection) {
        a.setProjection(projection);
        return a;
    }

    @Override
    public Criteria add(Criterion criterion) {
        a.add(criterion);
        b.add(criterion);
        return this;
    }

    @Override
    public Criteria addOrder(Order order) {
        a.addOrder(order);
        return this;
    }

    @Override
    public Criteria setFetchMode(String associationPath, FetchMode mode) throws HibernateException {
        a.setFetchMode(associationPath, mode);
        b.setFetchMode(associationPath, mode);
        return this;
    }

    @Override
    public Criteria setLockMode(LockMode lockMode) {
        a.setLockMode(lockMode);
        b.setLockMode(lockMode);
        return this;
    }

    @Override
    public Criteria setLockMode(String alias, LockMode lockMode) {
        a.setLockMode(alias, lockMode);
        b.setLockMode(alias, lockMode);
        return this;
    }

    @Override
    public Criteria createAlias(String associationPath, String alias) throws HibernateException {
        aliases.add(alias);
        a.createAlias(associationPath, alias);
        b.createAlias(associationPath, alias);
        return this;
    }

    @Override
    public Criteria createAlias(String associationPath, String alias, JoinType joinType) throws HibernateException {
        aliases.add(alias);
        a.createAlias(associationPath, alias, joinType);
        b.createAlias(associationPath, alias, joinType);
        return this;
    }

    @Override
    public Criteria createAlias(String associationPath, String alias, int joinType) throws HibernateException {
        aliases.add(alias);
        a.createAlias(associationPath, alias, JoinType.parse(joinType));
        b.createAlias(associationPath, alias, JoinType.parse(joinType));
        return this;
    }

    @Override
    public Criteria createAlias(String associationPath, String alias, JoinType joinType, Criterion withClause) throws HibernateException {
        aliases.add(alias);
        a.createAlias(associationPath, alias, joinType, withClause);
        b.createAlias(associationPath, alias, joinType, withClause);
        return this;
    }

    @Override
    public Criteria createAlias(String associationPath, String alias, int joinType, Criterion withClause) throws HibernateException {
        aliases.add(alias);
        a.createAlias(associationPath, alias, JoinType.parse(joinType), withClause);
        b.createAlias(associationPath, alias, JoinType.parse(joinType), withClause);
        return this;
    }

    @Override
    public PageCriteria createCriteria(String associationPath) throws HibernateException {
        return new PageCriteria(session, a.createCriteria(associationPath), b.createCriteria(associationPath));
    }

    @Override
    public PageCriteria createCriteria(String associationPath, JoinType joinType) throws HibernateException {
        return new PageCriteria(session, a.createCriteria(associationPath, joinType), b.createCriteria(associationPath, joinType));
    }

    @Override
    public PageCriteria createCriteria(String associationPath, int joinType) throws HibernateException {
        return new PageCriteria(session, a.createCriteria(associationPath, JoinType.parse(joinType)), b.createCriteria(associationPath, JoinType.parse(joinType)));
    }

    @Override
    public PageCriteria createCriteria(String associationPath, String alias) throws HibernateException {
        return new PageCriteria(session, a.createCriteria(associationPath, alias), b.createCriteria(associationPath, alias));
    }

    @Override
    public PageCriteria createCriteria(String associationPath, String alias, JoinType joinType) throws HibernateException {
        return new PageCriteria(session, a.createCriteria(associationPath, alias, joinType), b.createCriteria(associationPath, alias, joinType));
    }

    @Override
    public PageCriteria createCriteria(String associationPath, String alias, int joinType) throws HibernateException {
        return new PageCriteria(session, a.createCriteria(associationPath, alias, JoinType.parse(joinType)), b.createCriteria(associationPath, alias, JoinType.parse(joinType)));
    }

    @Override
    public PageCriteria createCriteria(String associationPath, String alias, JoinType joinType, Criterion withClause) throws HibernateException {
        return new PageCriteria(session, a.createCriteria(associationPath, alias, joinType, withClause), b.createCriteria(associationPath, alias, joinType, withClause));
    }

    @Override
    public PageCriteria createCriteria(String associationPath, String alias, int joinType, Criterion withClause) throws HibernateException {
        return new PageCriteria(session, a.createCriteria(associationPath, alias, JoinType.parse(joinType), withClause), b.createCriteria(associationPath, alias, JoinType.parse(joinType), withClause));
    }

    @Override
    public Criteria setResultTransformer(ResultTransformer resultTransformer) {
        a.setResultTransformer(resultTransformer);
        b.setResultTransformer(resultTransformer);
        return this;
    }

    @Override
    public Criteria setMaxResults(int maxResults) {
        a.setMaxResults(maxResults);
        return this;
    }

    @Override
    public Criteria setFirstResult(int firstResult) {
        a.setFirstResult(firstResult);
        return this;
    }

    @Override
    public boolean isReadOnlyInitialized() {
        return a.isReadOnlyInitialized();
    }

    @Override
    public boolean isReadOnly() {
        return a.isReadOnly();
    }

    @Override
    public Criteria setReadOnly(boolean readOnly) {
        a.setReadOnly(readOnly);
        return this;
    }

    @Override
    public Criteria setFetchSize(int fetchSize) {
        a.setFetchSize(fetchSize);
        b.setFetchSize(fetchSize);
        return this;
    }

    @Override
    public Criteria setTimeout(int timeout) {
        a.setTimeout(timeout);
        b.setTimeout(timeout);
        return this;
    }

    @Override
    public Criteria setCacheable(boolean cacheable) {
        a.setCacheable(cacheable);
        b.setCacheable(cacheable);
        return this;
    }

    @Override
    public Criteria setCacheRegion(String cacheRegion) {
        a.setCacheRegion(cacheRegion);
        b.setCacheRegion(cacheRegion);
        return this;
    }

    @Override
    public Criteria setComment(String comment) {
        a.setComment(comment);
        b.setComment(comment);
        return this;
    }

    @Override
    public Criteria addQueryHint(String hint) {
        a.addQueryHint(hint);
        b.addQueryHint(hint);
        return this;
    }

    @Override
    public Criteria setFlushMode(FlushMode flushMode) {
        a.setFlushMode(flushMode);
        b.setFlushMode(flushMode);
        return this;
    }

    @Override
    public Criteria setCacheMode(CacheMode cacheMode) {
        a.setCacheMode(cacheMode);
        b.setCacheMode(cacheMode);
        return this;
    }

    @Override
    public List<?> list() throws HibernateException {
        return a.list();
    }

    @Override
    public ScrollableResults scroll() throws HibernateException {
        return a.scroll();
    }

    @Override
    public ScrollableResults scroll(ScrollMode scrollMode) throws HibernateException {
        return a.scroll(scrollMode);
    }

    @Override
    public Object uniqueResult() throws HibernateException {
        return a.uniqueResult();
    }

    /**
     * Возвращает список объектов, соответствующих заданной странице.
     * Реальная страница и полное количество объектов будут записаны в передаваемый объект Filter.
     * */
    public <T>List<T> list(ListFilter<T> filter) {
        List<T> result = null;

        applyOrdering(filter, a);
        a.setMaxResults(filter.getLimit());

        boolean needsToRequestCount = true;
        if (filter.getPage() <= 1){
			/* Если находимся на 1-й странице, то ищем записи сразу без получения count */
            result = ObjectUtil.uncheckedCast(a.list());
            if (result.size() < filter.getLimit()){
				/* Количество найденных записей меньше размера страницы, значит запршивать count нет смысла */
                needsToRequestCount = false;
                filter.setTotalCount(result.size());
            }
        }

        if (needsToRequestCount){
            int totalCount = ((Number)b.setProjection(Projections.rowCount()).uniqueResult()).intValue();
            filter.setTotalCount(totalCount);
        }

        if (filter.getPage() > 1){
            int page = definePage(filter.getPage(), filter.getLimit(), filter.getTotalCount());
            filter.setPage(page);
            a.setFirstResult((page - 1) * filter.getLimit());
            result = ObjectUtil.uncheckedCast(a.list());
        }

        return result;
    }

    public <T>Iterator<T> scroll(ListFilter<T> filter){
        applyOrdering(filter, a);
        a.setMaxResults(filter.getScrollableRowCount());
        ScrollableResults scr = a.scroll(ScrollMode.FORWARD_ONLY);
        return new ScrollableResultsIterator<T>(scr, session, 50);
    }

    private <T> void applyOrdering(ListFilter<T> filter, Criteria c) {
        List<String> sortFields = filter.getSortFields();
        if(sortFields != null && !sortFields.isEmpty()) {
            boolean isAsc = filter.isAsc();
            boolean id = false;
            for (String sortField : sortFields){
                if("id".equals(sortField)) {
                    id = true;
                }
                c.addOrder(getOrder(sortField, isAsc));
            }
            if(!id){
                c.addOrder(Order.asc("id"));
            }
        }else{
            c.addOrder(Order.asc("id"));
        }
    }

    private Order getOrder(String sortField, boolean isAsc){
        return isAsc ? Order.asc(sortField) : Order.desc(sortField);
    }

    private int definePage(int requestedPage, int countOnPage, int totalCount){
        if (totalCount <= 0){
            return 1;
        }
        if ((requestedPage-1) * countOnPage >= totalCount) {
            return totalCount / countOnPage + (totalCount % countOnPage > 0 ? 1 : 0);
        } else {
            return requestedPage;
        }
    }
}
