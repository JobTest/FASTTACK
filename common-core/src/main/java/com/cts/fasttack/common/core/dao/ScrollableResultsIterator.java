package com.cts.fasttack.common.core.dao;

import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.common.core.util.ObjectUtil;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.Iterator;

/**
 * @author Anton Leliuk
 */
public class ScrollableResultsIterator<E> implements Iterator<E> {

    private static final int DEFAULT_BUFFER_SIZE = 100;

    private ScrollableResults scr;
    private Session session;
    private int lastReturnedIdx = -1;
    private int bufferSize;
    private boolean hasNext;
    private boolean first = true;

    private Serializable prevId;

    public ScrollableResultsIterator(ScrollableResults scr) {
        this(scr, null);
    }

    public ScrollableResultsIterator(ScrollableResults scr, Session session) {
        this(scr, session, DEFAULT_BUFFER_SIZE);
    }

    public ScrollableResultsIterator(ScrollableResults scr, Session session, int bufferSize) {
        this.scr = scr;
        this.session = session;
        this.bufferSize = bufferSize;
        this.hasNext = scr != null && scr.next();
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public E next() {
        checkSessionCleanup();
        E e = getObject();
        if (e instanceof Identifiable) {
            if (prevId != null && ((Identifiable<?>) e).getId() == prevId) {
                while (((Identifiable<?>) e).getId() == prevId && hasNext) {
                    e = getObject();
                }
                if (((Identifiable<?>) e).getId() == prevId && !hasNext) {
                    return null;
                }
            }
            prevId = ((Identifiable<?>) e).getId();
        }
        lastReturnedIdx++;
        return e;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove() isn't supported by ScrollableResultsIterator");
    }

    private E getObject() {
        if(first){
            first = false;
        } else {
            scr.next();
        }
        E e = ObjectUtil.uncheckedCast(scr.get(0));
        hasNext = !scr.isLast();
        return e;
    }

    private void checkSessionCleanup() {

		/* Если нет объекта session, у нас неочищаемый итератор */
        if (session == null) {
            return;
        }

		/*
		 * Если было загружено число объектов, кратное bufferSize, почистим
		 * сессию
		 */
        if (lastReturnedIdx > 1 && (lastReturnedIdx % bufferSize == 0)) {
            session.flush();
            session.clear();
        }
    }
}
