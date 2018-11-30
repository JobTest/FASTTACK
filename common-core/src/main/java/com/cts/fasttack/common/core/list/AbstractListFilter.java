package com.cts.fasttack.common.core.list;

import com.cts.fasttack.common.core.util.ObjectUtil;

/**
 * @author Anton Leliuk
 */
public class AbstractListFilter {

    protected int limit = 20;

    protected boolean asc = true;

    protected int page = 1;

    protected int totalCount;

    protected abstract class AbstractListFilterBuilder<BUILDER extends AbstractListFilterBuilder<BUILDER, FILTER>, FILTER extends AbstractListFilter> {

        public FILTER build() {
            return ObjectUtil.uncheckedCast(AbstractListFilter.this);
        }

        public BUILDER first() {
            AbstractListFilter.this.limit = 1;
            AbstractListFilter.this.page = 1;
            return ObjectUtil.uncheckedCast(this);
        }

        public BUILDER firstPage() {
            AbstractListFilter.this.page = 1;
            return ObjectUtil.uncheckedCast(this);
        }

        public BUILDER limit(int limit) {
            AbstractListFilter.this.limit = limit;
            return ObjectUtil.uncheckedCast(this);
        }

        public BUILDER unlimited() {
            AbstractListFilter.this.limit = Integer.MAX_VALUE;
            return ObjectUtil.uncheckedCast(this);
        }
    }

    /** getters and setters */
    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void nextPage(){
        page++;
    }

    public void prevPage(){
        if (page > 1){
            page--;
        }
    }

    public void firstPage(){
        page = 1;
    }

    public void lastPage(){
        page = getTotalPages();
    }

    public int getTotalPages() {
        return getTotalCount() / getLimit() + ((getTotalCount() % getLimit() == 0) ? 0 : 1);
    }

    public int getFirstPage() {
        return getPage() * getLimit() - getLimit() + 1;
    }

    public int getLastPage() {
        return getPage() * getLimit() > getTotalCount() ? getTotalCount() : getPage() * getLimit();
    }

    public void setPageRecordsCount(int pageSize) {
        if(pageSize>0 && pageSize<500){
            this.limit =pageSize;
        }else if(pageSize>500){
            pageSize=500;
        }
    }

    public void setUnlimited(boolean asc) {
        this.asc = asc;
        this.limit = Integer.MAX_VALUE;
    }

    public int getPageRecordsCount(){
        return limit;
    }

}
