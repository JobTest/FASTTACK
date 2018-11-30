package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;
import com.cts.fasttack.core.data.DCProgress;
import com.cts.fasttack.core.dto.DCProgressDto;

/**
 * Convert {@link DCProgress} into {@link DCProgressDto}
 *
 * @author Dmitry Koval
 */
@Component
public class DCProgressToDtoConverter extends IdentifierToDtoConverter<Long, DCProgress, DCProgressDto> {

    @Override
    protected DCProgressDto generateTarget() {
        return new DCProgressDto();
    }

    @Override
    public void convert(DCProgress source, DCProgressDto target) {
        target.setId(source.getId());
        target.setDcId(source.getDcId());
        target.setIps(source.getIps());
        target.setRequestId(source.getRequestId());
        target.setCorrelationId(source.getCorrelationId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setPanDisplay(source.getPanDisplay());
        target.setTokenUniqueReference(source.getTokenUniqueReference());
        target.setPanUniqueReference(source.getPanUniqueReference());
        target.setPanInternalId(source.getPanInternalId());
        target.setPanInternalGUID(source.getPanInternalGUID());
        target.setCustomerPhone(source.getCustomerPhone());
        target.setProvisioningError(source.getProvisioningError());
        target.setProvisioningDecision(source.getProvisioningDecision());
        target.setProvisioningStatus(source.getProvisioningStatus());
        target.setAsvErr(source.getAsvErr());
        target.setAsvStatus(source.getAsvStatus());
        target.setTaskId(source.getTaskId());
        target.setEventDate(source.getEventDate());
        target.setFinished(source.getFinished());
        target.setLock(source.getLock());
    }
}
