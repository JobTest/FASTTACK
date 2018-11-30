package com.cts.fasttack.mdes.server.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.ActivationMethodDto;
import com.cts.fasttack.mdes.server.dto.ActivationMethod;

/**
 * @author Dmitry Koval
 */
@Component
public class ActivationMethodDtoToDomainConverter extends AbstractConverter<ActivationMethodDto, ActivationMethod> {
    @Override
    protected ActivationMethod generateTarget() {
        return new ActivationMethod();
    }

    @Override
    protected void lightConvert(ActivationMethodDto source, ActivationMethod target) {
        target.setType(source.getType());
        target.setValue(source.getValue());
    }
}
