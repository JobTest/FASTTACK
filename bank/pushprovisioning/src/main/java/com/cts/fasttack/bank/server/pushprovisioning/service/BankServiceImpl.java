package com.cts.fasttack.bank.server.pushprovisioning.service;

import com.cts.fasttack.bank.server.pushprovisioning.converter.InAppProvisioningDataToCryptoRequestConverter;
import com.cts.fasttack.bank.server.pushprovisioning.converter.OpaquePaymentCardToCryptoRequestConverter;
import com.cts.fasttack.bank.server.pushprovisioning.converter.OpaquePaymentCardToEncryptedPaymentInstrumentConverter;
import com.cts.fasttack.bank.server.pushprovisioning.dto.CreateInAppProvisioningDataRequestDto;
import com.cts.fasttack.bank.server.pushprovisioning.dto.CreateOpaquePaymentCardRequestDto;
import com.cts.fasttack.bank.server.pushprovisioning.dto.EncryptedPaymentInstrument;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.crypto.client.dto.CreateInAppProvisioningDataCryptoResponse;
import com.cts.fasttack.crypto.client.dto.CreateOpaqueCardCryptoResponse;
import com.cts.fasttack.crypto.client.rest.CreateInAppProvisioningDataRestClient;
import com.cts.fasttack.crypto.client.rest.CreateOpaqueCardRestClient;
import com.cts.fasttack.logging.interceptor.ChangeLoggable;
import com.cts.fasttack.visa.common.service.VisaSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Anton Leliuk
 * @author d.ishchenko
 */
@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private VisaSecurityService visaSecurityService;

    @Autowired
    private OpaquePaymentCardToEncryptedPaymentInstrumentConverter paymentInstrumentConverter;

    @Autowired
    private OpaquePaymentCardToCryptoRequestConverter cryptoRequestConverter;

    @Autowired
    private InAppProvisioningDataToCryptoRequestConverter inAppProvisioningCryptoRequestConverter;

    @Autowired
    private CreateOpaqueCardRestClient cardRestClient;

    @Autowired
    private CreateInAppProvisioningDataRestClient inAppProvisioningRestClient;

    @ChangeLoggable(itemId = "#request.clientWalletAccountID", itemType = "DC", fields = {"#request.cardholderName", "#request.ips", "#request.intent"})
    @Override
    public CreateOpaqueCardCryptoResponse createOpaqueCardBody(CreateOpaquePaymentCardRequestDto request) throws ServiceException {
        // create opaque body for VISA
        if(InternationalPaymentSystem.V.name().equals(request.getIps())){
            EncryptedPaymentInstrument epi = paymentInstrumentConverter.convert(request);
            String epiAsJson = JsonUtil.toJson(epi);

            CreateOpaqueCardCryptoResponse response = new CreateOpaqueCardCryptoResponse();
            response.setOpaqueBody(visaSecurityService.createSharedSecretJwe(epiAsJson));
            return response;
        }
        // create opaque body for MDES
        return cardRestClient.createOpaqueBody(cryptoRequestConverter.convert(request));
    }

    @ChangeLoggable(itemId = "#request.nonce", itemType = "NONCE", fields = {"#request.cardholderName", "#request.ips"})
    @Override
    public CreateInAppProvisioningDataCryptoResponse createInAppProvisioningData(CreateInAppProvisioningDataRequestDto request) throws ServiceException {
 
        return inAppProvisioningRestClient.createInAppProvisioningData(inAppProvisioningCryptoRequestConverter.convert(request));
    }

}
