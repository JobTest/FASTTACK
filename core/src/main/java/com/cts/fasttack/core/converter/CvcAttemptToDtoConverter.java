package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.CvcAttempt;
import com.cts.fasttack.core.dto.CvcAttemptDto;

/**
 * @author Dmitry Koval
 */
@Component
public class CvcAttemptToDtoConverter extends AbstractConverter<CvcAttempt, CvcAttemptDto> {
    @Override
    protected CvcAttemptDto generateTarget() {
        return new CvcAttemptDto();
    }

    @Override
    protected void lightConvert(CvcAttempt source, CvcAttemptDto target) {
        target.setId(source.getId());
        target.setFailures(source.getFailures());
        target.setLastDate(source.getLastDate());
        target.setPanInternalGUID(source.getPanInternalGUID());
        target.setPanInternalID(source.getPanInternalID());
    }
}

