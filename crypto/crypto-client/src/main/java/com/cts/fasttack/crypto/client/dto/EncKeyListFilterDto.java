package com.cts.fasttack.crypto.client.dto;

/**
 * @author Dmitry Koval
 */
public class EncKeyListFilterDto {

    private String keyType;

    private String refCode;

    private boolean asc;

    private int limit;

    private int page;

    private int pageRecordsCount;

    private int scrollableRowCount;

    private boolean searched;

    private String sortField;

    private int totalCount;

    private boolean unlimited;

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageRecordsCount() {
        return pageRecordsCount;
    }

    public void setPageRecordsCount(int pageRecordsCount) {
        this.pageRecordsCount = pageRecordsCount;
    }

    public int getScrollableRowCount() {
        return scrollableRowCount;
    }

    public void setScrollableRowCount(int scrollableRowCount) {
        this.scrollableRowCount = scrollableRowCount;
    }

    public boolean isSearched() {
        return searched;
    }

    public void setSearched(boolean searched) {
        this.searched = searched;
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

    public boolean isUnlimited() {
        return unlimited;
    }

    public void setUnlimited(boolean unlimited) {
        this.unlimited = unlimited;
    }
}
