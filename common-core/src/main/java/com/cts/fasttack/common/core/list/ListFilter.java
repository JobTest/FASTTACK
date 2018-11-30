package com.cts.fasttack.common.core.list;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

import com.cts.fasttack.common.core.util.ObjectUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Anton Leliuk
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListFilter<T> extends AbstractListFilter {

	private String sortField = "";

	/**
	 * органичение на количество записей при использовании метода scroll
	 * */
	private int scrollableRowCount = 65000;

	/**
	 * стандартный размер страницы
	 * */
	private int standardPageSize = 20;

	private boolean searched = false;

	public class ListFilterBuilder<BUILDER extends ListFilterBuilder<BUILDER, FILTER>, FILTER extends ListFilter<T>> extends AbstractListFilterBuilder<BUILDER, FILTER> {

		public BUILDER sortField(String sortField) {
			ListFilter.this.sortField = sortField;
            return ObjectUtil.uncheckedCast(this);
		}

		public BUILDER scrollableRowCount(int scrollableRowCount) {
			ListFilter.this.scrollableRowCount = scrollableRowCount;
            return ObjectUtil.uncheckedCast(this);
		}

		public BUILDER standardPageSize(int standardPageSize) {
			ListFilter.this.standardPageSize = standardPageSize;
            return ObjectUtil.uncheckedCast(this);
		}

		public BUILDER searched(boolean searched) {
			ListFilter.this.searched = searched;
            return ObjectUtil.uncheckedCast(this);
		}
	}

	/** getters and setters */
	public ListFilter<T> pageSize(int size){
		limit = size;
		return this;
	}

	public ListFilter<T> pageSizeUnLimit(){
		return pageSize(Integer.MAX_VALUE);
	}

	public void setScrollablePageSize(){
		limit = scrollableRowCount;
	}

	public void setStandardPageSize(){
		limit = standardPageSize;
	}

	public void setPageAsLong(Long page) {
		if (page >= 1 && page <= getTotalPages()){
			this.page = page.intValue();
		}
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
        this.sortField = sortField;
    }

	public List<String> getSortFields() {
		String delimiter = ",";
		List<String> sortFields = new ArrayList<>();
		if(StringUtils.isNotEmpty(getSortField())) {
			StringTokenizer st = new StringTokenizer(getSortField(), delimiter);
			while(st.hasMoreTokens()) {
				sortFields.add(st.nextToken().trim());
			}
		}
		return sortFields;
	}

	public int getScrollableRowCount() {
		return scrollableRowCount;
	}

	public void setScrollableRowCount(int rowSize) {
		this.scrollableRowCount = rowSize;
	}

	public boolean isSearched() {
		return searched;
	}

	public void setSearched(boolean searched) {
		this.searched = searched;
	}

}
