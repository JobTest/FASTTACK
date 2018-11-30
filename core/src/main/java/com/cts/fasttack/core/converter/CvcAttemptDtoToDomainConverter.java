package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.CvcAttempt;
import com.cts.fasttack.core.dto.CvcAttemptDto;

/**
 * @author Dmitry Koval
 */
@Component
public class CvcAttemptDtoToDomainConverter extends AbstractConverter<CvcAttemptDto, CvcAttempt> {
    @Override
    protected CvcAttempt generateTarget() {
        return new CvcAttempt();
    }

    @Override
    protected void lightConvert(CvcAttemptDto source, CvcAttempt target) {
        target.setId(source.getId());
        target.setFailures(source.getFailures());
        target.setLastDate(source.getLastDate());
        target.setPanInternalGUID(source.getPanInternalGUID());
        target.setPanInternalID(source.getPanInternalID());
    }
}
