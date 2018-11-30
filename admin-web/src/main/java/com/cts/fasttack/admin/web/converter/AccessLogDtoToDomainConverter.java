package com.cts.fasttack.admin.web.converter;


import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.domain.AccessLog;
import com.cts.fasttack.admin.web.data.dto.AccessLogDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.util.StringUtil;

@Component
public class AccessLogDtoToDomainConverter extends AbstractConverter<AccessLogDto, AccessLog> {

	//TOTAL 255 bytes -> use [200]...[252] - up to 255 total
	private static final int FIELD_SUBSTR_START = 200;
	private static final int FIELD_SUBSTR_END = 52;
	
    @Override
    protected AccessLog generateTarget() {
        return new AccessLog();
    }

    @Override
    protected void lightConvert(AccessLogDto source, AccessLog target) {
        target.setId(source.getId() == null ? -1L : source.getId());
        target.setUsername(source.getUsername());
        target.setItemType(source.getItemType());
        target.setAccessType(source.getAccessType());
        target.setAccessDate(source.getAccessDate());
        target.setItemId(source.getItemId());
        target.setField1(StringUtil.substringLimitInBytes(source.getField1(), FIELD_SUBSTR_START, FIELD_SUBSTR_END));
        target.setField2(StringUtil.substringLimitInBytes(source.getField2(), FIELD_SUBSTR_START, FIELD_SUBSTR_END));
        target.setField3(StringUtil.substringLimitInBytes(source.getField3(), FIELD_SUBSTR_START, FIELD_SUBSTR_END));
        target.setField4(StringUtil.substringLimitInBytes(source.getField4(), FIELD_SUBSTR_START, FIELD_SUBSTR_END));
        target.setField5(StringUtil.substringLimitInBytes(source.getField5(), FIELD_SUBSTR_START, FIELD_SUBSTR_END));
    }
}
