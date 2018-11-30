package com.cts.fasttack.crypto.server.service;

import java.util.List;

import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dto.CreateInAppProvisioningDataCryptoResponse;

/**
 * @author d.ishchenko
 */
public interface InAppProvisioningCryptoService {

    CreateInAppProvisioningDataCryptoResponse createInAppProvisioningData(String accountNumber, String expiryMonth, String expiryYear, String cardholderName, InternationalPaymentSystem ips, String nonce, String nonceSignature, List<String> certificates, String visaWsdKeyEncryptionRule, String visaWsdKeyIndex, String visaPaymentDataFormat, Integer visaPanPrefixLength) throws ServiceException;

}
