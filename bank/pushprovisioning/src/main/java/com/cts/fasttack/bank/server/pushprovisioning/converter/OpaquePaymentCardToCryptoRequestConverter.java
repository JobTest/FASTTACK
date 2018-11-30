package com.cts.fasttack.bank.server.pushprovisioning.converter;

import com.cts.fasttack.bank.server.pushprovisioning.config.CreateOpaqueCardParameters;
import com.cts.fasttack.bank.server.pushprovisioning.dto.CreateOpaquePaymentCardRequestDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.crypto.client.dto.CreateOpaqueCardCryptoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Anton Leliuk
 */
@Component
public class OpaquePaymentCardToCryptoRequestConverter extends AbstractConverter<CreateOpaquePaymentCardRequestDto, CreateOpaqueCardCryptoRequest> {

    @Autowired
    private CreateOpaqueCardParameters parameters;

    @Override
    protected CreateOpaqueCardCryptoRequest generateTarget() {
        return new CreateOpaqueCardCryptoRequest();
    }

    @Override
    protected void lightConvert(CreateOpaquePaymentCardRequestDto source, CreateOpaqueCardCryptoRequest target) {
        target.setAccountNumber(source.getPan());
        target.setCardholderName(source.getCardholderName());
        target.setExpiryMonth(source.getExpiryMonth());
        target.setExpiryYear(source.getExpiryYear());
        target.setPublicKeyFingerprint(parameters.getPublicKeyFingerprint());
        target.setTavKeyFingerprint(parameters.getTavKeyFingerprint());
        target.setOaepHashingAlgorithm(parameters.getOaepHashingAlgorithm());
    }
}
