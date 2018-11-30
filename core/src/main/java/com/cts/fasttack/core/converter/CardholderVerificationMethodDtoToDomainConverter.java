package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.CardholderVerificationMethod;
import com.cts.fasttack.core.dto.CardholderVerificationMethodDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class CardholderVerificationMethodDtoToDomainConverter extends AbstractConverter<CardholderVerificationMethodDto, CardholderVerificationMethod> {
    @Override
    protected CardholderVerificationMethod generateTarget() {
        return new CardholderVerificationMethod();
    }

    @Override
    protected void lightConvert(CardholderVerificationMethodDto source, CardholderVerificationMethod target) {
        target.setId(source.getId());
        target.setRequestId(source.getRequestId());
        target.setBankAppName(source.getBankappName());
        target.setCellPhone(source.getCellPhone());
        target.setCorrelationId(source.getCorrelationId());
        target.setCustomerService(source.getCustomerService());
        target.setTransactionDate(source.getTransactionDate());
        target.setEmail(source.getEmail());
        target.setOtpMethodPlatform(source.getOtpMethodPlatform());
        target.setOutboundCall(source.getOutboundCall());
        target.setTokenRefId(source.getTokenRefId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setCvmIdentifierOtp(source.getCvmIdentifierOtp());
        target.setPanInternalId(source.getPanInternalId());
        target.setPanInternalGUID(source.getPanInternalGUID());
        target.setMaskedPan(source.getMaskedPan());
        target.setTokenizationPath(source.getTokenizationPath());
        target.setWpDeviceScore(source.getWpDeviceScore());
        target.setWpAccountScore(source.getWpAccountScore());
        target.setWpPhonenumberScore(source.getWpPhonenumberScore());
        target.setWpReasonCodes(source.getWpReasonCodes());
        target.setColorTokenizationStandardVersion(source.getColorTokenizationStandardVersion());
        target.setDeviceType(source.getDeviceType());
        target.setDeviceName(source.getDeviceName());
    }
}
