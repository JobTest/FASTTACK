package com.cts.fasttack.visa.vtis.server.converter;

import com.cts.fasttack.visa.vtis.server.dto.ExpirationDateDto;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsExpirationDateDto;

/**
 * @author Dmitry Koval
 */
@Component
public class ExpirationDateToJmsDtoConverter extends AbstractConverter<ExpirationDateDto, JmsExpirationDateDto> {

    @Override
    protected JmsExpirationDateDto generateTarget() {
        return new JmsExpirationDateDto();
    }

    @Override
    protected void lightConvert(ExpirationDateDto source, JmsExpirationDateDto target) {
        target.setMonth(source.getMonth());
        target.setYear(source.getYear());
    }
}
