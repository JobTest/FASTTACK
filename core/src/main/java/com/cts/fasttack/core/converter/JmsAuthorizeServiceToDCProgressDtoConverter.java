package com.cts.fasttack.core.converter;

import java.util.Date;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.dto.DCProgressDto;
import com.cts.fasttack.jms.dto.JmsAuthorizeServiceDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class JmsAuthorizeServiceToDCProgressDtoConverter extends AbstractConverter<JmsAuthorizeServiceDto, DCProgressDto> {
    @Override
    protected DCProgressDto generateTarget() {
        return new DCProgressDto();
    }

    @Override
    protected void lightConvert(JmsAuthorizeServiceDto source, DCProgressDto target) {
        target.setCorrelationId(source.getCorrelationId());
        target.setEventDate(new Date());
        target.setPanUniqueReference(source.getPanUniqueReference());
        target.setRequestId(source.getRequestId());
        target.setTokenRequestorId(source.getTokenRequestorId());
    }
}
