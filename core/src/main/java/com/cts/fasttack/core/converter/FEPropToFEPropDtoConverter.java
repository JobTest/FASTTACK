package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.FEProp;
import com.cts.fasttack.core.dto.FEPropDto;

/**
 * {@link FEProp} to {@link FEPropDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class FEPropToFEPropDtoConverter extends AbstractConverter<FEProp, FEPropDto> {

    @Override
    protected FEPropDto generateTarget() {
        return new FEPropDto();
    }

    @Override
    protected void lightConvert(FEProp source, FEPropDto target) {
        target.setPropName(source.getPropName());
        target.setPropValue(source.getPropValue());
    }
}
