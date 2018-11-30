package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.DCProgress;
import com.cts.fasttack.core.dto.DCProgressDto;

/**
 * Convert {@link DCProgressDto} into {@link DCProgress}
 *
 * @author Dmitry Koval
 */
@Component
public class DCProgressDtoToDomainConverter extends AbstractConverter<DCProgressDto, DCProgress> {
    @Override
    protected DCProgress generateTarget() {
        return new DCProgress();
    }

    @Override
    protected void lightConvert(DCProgressDto source, DCProgress target) {
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
        target.setProductConfigID(source.getProductConfigID());
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
