package com.cts.fasttack.bank.server.pushprovisioning.dto;

/**
 * @author Anton Leliuk
 */
public class EncryptedPaymentInstrument {

    private String accountNumber;
    private String name;
    private ExpirationDate expirationDate;
    private BillingAddress billingAddress;
    private PaymentInstrumentProvider provider;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ExpirationDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public PaymentInstrumentProvider getProvider() {
        return provider;
    }

    public void setProvider(PaymentInstrumentProvider provider) {
        this.provider = provider;
    }
}
