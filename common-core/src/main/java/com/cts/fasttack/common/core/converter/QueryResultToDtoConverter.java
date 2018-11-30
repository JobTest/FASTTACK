package com.cts.fasttack.common.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.dto.QueryResultDto;

/**
 * @author Dmitry Koval
 */
@Component
public class QueryResultToDtoConverter<T> extends AbstractConverter<QueryResult<T>, QueryResultDto<T>> {
    @Override
    protected QueryResultDto<T> generateTarget() {
        return new QueryResultDto<>();
    }

    @Override
    protected void lightConvert(QueryResult<T> source, QueryResultDto<T> target) {
        target.setDisplayedPages(source.getDisplayedPages());
        target.setLimit(source.getLimit());
        target.setMaxPage(source.getMaxPage());
        target.setObjects(source.getObjects());
        target.setPage(source.getPage());
        target.setSortField(source.getSortField());
        target.setTotalCount(source.getTotalCount());
        target.setAsc(source.isAsc());
    }
}
