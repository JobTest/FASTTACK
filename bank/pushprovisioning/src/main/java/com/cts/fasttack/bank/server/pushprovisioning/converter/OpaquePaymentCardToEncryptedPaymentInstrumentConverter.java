package com.cts.fasttack.bank.server.pushprovisioning.converter;

import com.cts.fasttack.bank.server.pushprovisioning.dict.Intent;
import com.cts.fasttack.bank.server.pushprovisioning.dto.BillingAddress;
import com.cts.fasttack.bank.server.pushprovisioning.dto.CreateOpaquePaymentCardRequestDto;
import com.cts.fasttack.bank.server.pushprovisioning.dto.EncryptedPaymentInstrument;
import com.cts.fasttack.bank.server.pushprovisioning.dto.ExpirationDate;
import com.cts.fasttack.bank.server.pushprovisioning.dto.PaymentInstrumentProvider;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import org.springframework.stereotype.Component;

/**
 * @author Anton Leliuk
 */
@Component
public class OpaquePaymentCardToEncryptedPaymentInstrumentConverter extends AbstractConverter<CreateOpaquePaymentCardRequestDto, EncryptedPaymentInstrument> {

    @Override
    protected EncryptedPaymentInstrument generateTarget() {
        return new EncryptedPaymentInstrument();
    }

    @Override
    protected void lightConvert(CreateOpaquePaymentCardRequestDto source, EncryptedPaymentInstrument target) {
        target.setAccountNumber(source.getPan());
        target.setName(source.getCardholderName());

        BillingAddress address = new BillingAddress();
        address.setCountry(source.getCountry());
        target.setBillingAddress(address);

        ExpirationDate ed = new ExpirationDate();
        ed.setMonth(source.getExpiryMonth());
        ed.setYear("20" + source.getExpiryYear());
        target.setExpirationDate(ed);

        PaymentInstrumentProvider provider = new PaymentInstrumentProvider();
        provider.setClientAppID(source.getClientAppID());
        provider.setClientDeviceID(source.getClientDeviceID());
        provider.setClientWalletAccountID(source.getClientWalletAccountID());
        provider.setClientWalletProvider(source.getClientWalletProvider());
        provider.setIDnV(source.isIDnV());
        provider.setIntent(Intent.valueOf(source.getIntent()));
        target.setProvider(provider);
    }
}
