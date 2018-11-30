package com.cts.fasttack.common.core.dto;

import java.util.Collection;
import java.util.List;

/**
 * @author Dmitry Koval
 */
public class QueryResultDto<T> {

    private Collection<Integer> displayedPages;

    private int limit;

    private int maxPage;

    private List<T> objects;

    private int page;

    private String sortField;

    private int totalCount;

    private boolean asc;

    public Collection<Integer> getDisplayedPages() {
        return displayedPages;
    }

    public void setDisplayedPages(Collection<Integer> displayedPages) {
        this.displayedPages = displayedPages;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isPreviousPagePossible() {
        return page > 1;
    }

    public boolean isNextPagePossible() {
        return page < maxPage;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }
}
