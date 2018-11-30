package com.cts.fasttack.logging.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.cts.fasttack.common.core.util.DateFormatUtil;
import com.cts.fasttack.logging.domain.ChangeLog;
import com.cts.fasttack.logging.dto.ChangeLogDto;

/**
 * @author Dmitry Koval
 */
@Component
public class ChangeLogDtoToDomainConverter  extends AbstractConverter<ChangeLogDto,ChangeLog>{
    @Override
    protected ChangeLog generateTarget() {
        return new ChangeLog();
    }

    @Override
    protected void lightConvert(ChangeLogDto source, ChangeLog target) {
        target.setId(source.getId());
        target.setAction(source.getAction());
        target.setItemType(source.getItemType());
        target.setItemId(source.getItemId());
        target.setSeverity(source.getSeverity());
        target.setMessage(source.getMessage());
        target.setTime(DateFormatUtil.stringToDate(DateFormatEnum.DATETIME, source.getTime()));
        target.setOriginator(source.getOriginator());
        target.setF1(source.getF1());
        target.setF2(source.getF2());
        target.setF3(source.getF3());
        target.setF4(source.getF4());
        target.setF5(source.getF5());
    }
}
