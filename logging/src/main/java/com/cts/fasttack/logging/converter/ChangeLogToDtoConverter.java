package com.cts.fasttack.logging.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;
import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.cts.fasttack.common.core.util.DateFormatUtil;
import com.cts.fasttack.logging.domain.ChangeLog;
import com.cts.fasttack.logging.dto.ChangeLogDto;

/**
 * Convertor {@link com.cts.fasttack.logging.domain.ChangeLog} into {@link com.cts.fasttack.logging.dto.ChangeLogDto}
 *
 * @author Dmitry Koval
 */
@Component
public class ChangeLogToDtoConverter extends IdentifierToDtoConverter<Long, ChangeLog, ChangeLogDto> {

    @Override
    protected ChangeLogDto generateTarget() {
        return new ChangeLogDto();
    }

    @Override
    public void convert(ChangeLog source, ChangeLogDto target) {
        target.setId(source.getId());
        target.setAction(source.getAction());
        target.setItemType(source.getItemType());
        target.setItemId(source.getItemId());
        target.setSeverity(source.getSeverity());
        target.setMessage(source.getMessage());
        target.setTime(DateFormatUtil.dateToString(DateFormatEnum.DATETIME, source.getTime()));
        target.setOriginator(source.getOriginator());
        target.setF1(source.getF1());
        target.setF2(source.getF2());
        target.setF3(source.getF3());
        target.setF4(source.getF4());
        target.setF5(source.getF5());
    }

}
