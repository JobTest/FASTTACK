package com.cts.fasttack.bank.server.pushprovisioning.converter;

import com.cts.fasttack.bank.server.pushprovisioning.config.CreateInAppProvisioningDataParameters;
import com.cts.fasttack.bank.server.pushprovisioning.dto.CreateInAppProvisioningDataRequestDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.crypto.client.dto.CreateInAppProvisioningDataCryptoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author d.ishchenko
 */
@Component
public class InAppProvisioningDataToCryptoRequestConverter extends AbstractConverter<CreateInAppProvisioningDataRequestDto, CreateInAppProvisioningDataCryptoRequest> {

    @Autowired
    private CreateInAppProvisioningDataParameters parameters;

    @Override
    protected CreateInAppProvisioningDataCryptoRequest generateTarget() {
        return new CreateInAppProvisioningDataCryptoRequest();
    }

    @Override
    protected void lightConvert(CreateInAppProvisioningDataRequestDto source, CreateInAppProvisioningDataCryptoRequest target) {
        target.setAccountNumber(source.getPan());
        target.setCardholderName(source.getCardholderName());
        target.setExpiryMonth(source.getExpiryMonth());
        target.setExpiryYear(source.getExpiryYear());
        target.setIps(InternationalPaymentSystem.getInstance(source.getIps()));
        target.setNonce(source.getNonce());
        target.setNonceSignature(source.getNonceSignature());
        target.setCertificates(source.getCertificates());
        target.setVisaWsdKeyEncryptionRule(parameters.getVisaWsdKeyEncryptionRule());
        target.setVisaWsdKeyIndex(parameters.getVisaWsdKeyIndex());
        target.setVisaPaymentDataFormat(parameters.getVisaPaymentDataFormat());
        target.setVisaPanPrefixLength(parameters.getVisaPanPrefixLength());
    }
}
