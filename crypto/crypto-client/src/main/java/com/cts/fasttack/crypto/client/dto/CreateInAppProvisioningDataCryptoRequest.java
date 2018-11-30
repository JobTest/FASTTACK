package com.cts.fasttack.crypto.client.dto;

import java.util.List;

import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;

/**
 * @author d.ishchenko
 */
public class CreateInAppProvisioningDataCryptoRequest implements CryptoRequest {

    private String visaWsdKeyEncryptionRule;

    private String visaWsdKeyIndex;

    private String visaPaymentDataFormat;

    private Integer visaPanPrefixLength;

    private String accountNumber;

    private String expiryMonth;

    private String expiryYear;

    private String cardholderName;

    private InternationalPaymentSystem ips;

    private String nonce;

    private String nonceSignature;

    private List<String> certificates;

    public String getVisaWsdKeyEncryptionRule() {
        return visaWsdKeyEncryptionRule;
    }

    public void setVisaWsdKeyEncryptionRule(String visaWsdKeyEncryptionRule) {
        this.visaWsdKeyEncryptionRule = visaWsdKeyEncryptionRule;
    }

    public String getVisaWsdKeyIndex() {
        return visaWsdKeyIndex;
    }

    public void setVisaWsdKeyIndex(String visaWsdKeyIndex) {
        this.visaWsdKeyIndex = visaWsdKeyIndex;
    }

    public String getVisaPaymentDataFormat() {
        return visaPaymentDataFormat;
    }

    public void setVisaPaymentDataFormat(String visaPaymentDataFormat) {
        this.visaPaymentDataFormat = visaPaymentDataFormat;
    }

    public Integer getVisaPanPrefixLength() {
        return visaPanPrefixLength;
    }

    public void setVisaPanPrefixLength(Integer visaPanPrefixLength) {
        this.visaPanPrefixLength = visaPanPrefixLength;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public InternationalPaymentSystem getIps() {
        return ips;
    }

    public void setIps(InternationalPaymentSystem ips) {
        this.ips = ips;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getNonceSignature() {
        return nonceSignature;
    }

    public void setNonceSignature(String nonceSignature) {
        this.nonceSignature = nonceSignature;
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

}
