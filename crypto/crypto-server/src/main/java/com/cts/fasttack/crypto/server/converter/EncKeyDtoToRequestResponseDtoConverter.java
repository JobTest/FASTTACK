package com.cts.fasttack.crypto.server.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.crypto.client.dto.EncKeyRequestResponseDto;
import com.cts.fasttack.crypto.server.dto.EncKeyDto;

/**
 * @author Dmitry Koval
 */
@Component
public class EncKeyDtoToRequestResponseDtoConverter extends AbstractConverter<EncKeyDto, EncKeyRequestResponseDto> {
    @Override
    protected EncKeyRequestResponseDto generateTarget() {
        return new EncKeyRequestResponseDto();
    }

    @Override
    protected void lightConvert(EncKeyDto source, EncKeyRequestResponseDto target) {
        target.setId(source.getId());
        target.setKeyType(source.getKeyType().name());
        target.setRefCode(source.getRefCode());
        target.setCapacity(source.getCapacity().name());
        target.setStatusCode(source.getStatusCode().name());
        target.setKeyValue(source.getKeyValue());
        target.setCheckValue(source.getCheckValue());
        target.setPublicExponent(source.getPublicExponent());
        target.setEffDate(source.getEffDate());
        target.setExpDate(source.getExpDate());
        target.setWrappingKey(source.getWrappingKey());
        target.setNew(source.isNew());
    }
}
