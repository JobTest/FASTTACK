package com.cts.fasttack.admin.web.converter;


import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.domain.AccessLog;
import com.cts.fasttack.admin.web.data.dto.AccessLogDto;
import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;

@Component
public class AccessLogToDtoConverter extends IdentifierToDtoConverter<Long, AccessLog, AccessLogDto> {

    @Override
    protected AccessLogDto generateTarget() {
        return new AccessLogDto();
    }

    @Override
    protected void lightConvert(AccessLog source, AccessLogDto target) {
        super.lightConvert(source, target);
        target.setUsername(source.getUsername());
        target.setItemType(source.getItemType());
        target.setAccessType(source.getAccessType());
        target.setAccessDate(source.getAccessDate());
        target.setItemId(source.getItemId());
        target.setField1(source.getField1());
        target.setField2(source.getField2());
        target.setField3(source.getField3());
        target.setField4(source.getField4());
        target.setField5(source.getField5());
    }
}
