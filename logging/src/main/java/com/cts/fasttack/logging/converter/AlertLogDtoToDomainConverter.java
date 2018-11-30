package com.cts.fasttack.logging.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.logging.domain.AlertLog;
import com.cts.fasttack.logging.dto.AlertLogDto;

/**
 * Convert {@link com.cts.fasttack.logging.dto.AlertLogDto} into {@link com.cts.fasttack.logging.domain.AlertLog}
 *
 * @author Dmitry Koval
 */
@Component
public class AlertLogDtoToDomainConverter extends AbstractConverter<AlertLogDto, AlertLog> {
    @Override
    protected AlertLog generateTarget() {
        return new AlertLog();
    }

    @Override
    protected void lightConvert(AlertLogDto source, AlertLog target) {
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
