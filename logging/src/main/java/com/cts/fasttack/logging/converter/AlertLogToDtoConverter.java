package com.cts.fasttack.logging.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;
import com.cts.fasttack.logging.domain.AlertLog;
import com.cts.fasttack.logging.dto.AlertLogDto;

/**
 * Convert {@link com.cts.fasttack.logging.domain.AlertLog} into {@link com.cts.fasttack.logging.dto.AlertLogDto}
 *
 * @author Dmitry Koval
 */
@Component
public class AlertLogToDtoConverter extends IdentifierToDtoConverter<Long, AlertLog, AlertLogDto> {

    @Override
    protected AlertLogDto generateTarget() {
        return new AlertLogDto();
    }

    @Override
    public void convert(AlertLog source, AlertLogDto target) {
        target.setId(source.getId());
        target.setEvent(source.getEvent());
        target.setData(source.getData());
        target.setDate(source.getDate());
        target.setOriginator(source.getOriginator());
        target.setActUser(source.getActUser());
        target.setActData(source.getActData());
        target.setActDate(source.getActDate());
    }
}
