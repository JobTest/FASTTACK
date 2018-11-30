package com.cts.fasttack.common.core.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * Wraps list of objects resolved from data source (e.g. DB). QueryResult can be used for transfer paginated results for queries
 * trough application layers. Contains following info:
 * <ul>
 *     <li><b>objects<b/> - list fo objects, which were received from data source<li/>
 *     <li><b>filter<b/> - a filter for which query result was created.<li/>
 *     <li><b>totalCount<b/> - amount of objects, which are present in data source on query.<li/>
 * </ul>
 *
 * User: emospan, A. Petrenko
 */
public class QueryResult<T> implements Serializable {

	private static final long serialVersionUID = -4323166243052533741L;

	private static final int maxPages2Display = 5;

    private List<T> objects;
    private ListFilter<?> filter;

    public QueryResult() {}

    public QueryResult(List<T> objects, ListFilter<?> filter) {
        this.objects = objects;
        this.filter = filter;
    }

    public int getPage() {
        return filter.getPage();
    }

    public int getLimit() {
        return filter.getLimit();
    }

    public int getMaxPage() {
        return (int)Math.ceil((double)filter.getTotalCount() / filter.getLimit());
    }

    public int getTotalCount() {
        return filter.getTotalCount();
    }

    public String getSortField() {
        return filter.getSortField();
    }

    public boolean isAsc() {
        return filter.isAsc();
    }

    public boolean isPreviousPagePossible() {
        return filter.getPage() > 1;
    }

    public boolean isNextPagePossible() {
        return filter.getPage() < getMaxPage();
    }

    public Collection<Integer> getDisplayedPages() {
        Collection<Integer> result = new ArrayList<>();
        int minPage = (filter.getPage() - maxPages2Display / 2) > 1 ? Math.min(filter.getPage() - maxPages2Display / 2, getMaxPage() - maxPages2Display / 2) : 1;
        minPage = Math.max(1, minPage);
        int maxPage = Math.min(minPage + maxPages2Display - 1, getMaxPage());
        for (int i = minPage; i <= maxPage; i++) {
            result.add(i);
        }
        return result;
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    public ListFilter<?> getFilter() {
        return filter;
    }

    public void setFilter(ListFilter<?> filter) {
        this.filter = filter;
    }
}
