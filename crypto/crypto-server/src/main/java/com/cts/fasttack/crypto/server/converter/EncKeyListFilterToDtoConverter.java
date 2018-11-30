package com.cts.fasttack.crypto.server.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.crypto.client.dto.EncKeyListFilterDto;
import com.cts.fasttack.crypto.server.filter.EncKeyListFilter;

/**
 * @author Dmitry Koval
 */
@Component
public class EncKeyListFilterToDtoConverter extends AbstractConverter<EncKeyListFilter, EncKeyListFilterDto> {
    @Override
    protected EncKeyListFilterDto generateTarget() {
        return new EncKeyListFilterDto();
    }

    @Override
    protected void lightConvert(EncKeyListFilter source, EncKeyListFilterDto target) {
        target.setKeyType(source.getKeyType());
        target.setRefCode(source.getRefCode());
        target.setAsc(source.isAsc());
        target.setLimit(source.getLimit());
        target.setPage(source.getPage());
        target.setPageRecordsCount(source.getPageRecordsCount());
        target.setScrollableRowCount(source.getScrollableRowCount());
        target.setSearched(source.isSearched());
        target.setSortField(source.getSortField());
        target.setTotalCount(source.getTotalCount());
    }
}
