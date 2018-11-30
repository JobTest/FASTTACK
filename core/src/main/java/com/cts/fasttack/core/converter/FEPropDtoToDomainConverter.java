package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.FEProp;
import com.cts.fasttack.core.dto.FEPropDto;

/**
 * {@link FEPropDto} to {@link FEProp} converter.
 *
 * @author v.semerkov
 */
@Component
public class FEPropDtoToDomainConverter extends AbstractConverter<FEPropDto, FEProp> {

    @Override
    protected FEProp generateTarget() {
        return new FEProp();
    }

    @Override
    protected void lightConvert(FEPropDto source, FEProp target) {
        target.setPropName(source.getPropName());
        target.setPropValue(source.getPropValue());
    }
}
