package com.cts.fasttack.core.dto;

import java.util.Date;

import com.cts.fasttack.core.dict.Source;

/**
 * Object that's containing the Account PAN information
 * @author a.lipavets
 */
public class CardInfoDataDto {

    /**
     * The Account PAN of the card associated with the service or the token PAN
     */
    private String accountNumber;

    /**
     * The month of the expiration date of the card to be digitized
     */
    private String expiryMonth;

    /**
     * The year of the expiration date of the card to be digitized
     */
    private String expiryYear;

    /**
     * The source of this card information
     */
    private Source source;

    /**
     * The name of the Cardholder in the format LASTNAME/FIRSTNAME or FIRSTNAME LASTNAME
     */
    private String cardholderName;

    /**
     * The CVC2 for the card to be digitized, as entered by the Cardholder
     */
    private String securityCode;

    /**
     * The date/time after which this CardInfoData object is considered invalid
     */
    private Date dataValidUntilTimestamp;

    /**
     * Cardholder billing address information
     */
    private BillingAddressDto billingAddress;

    /**
     * Cardholder information used for authorizing the account.
     */
    private CardholderDataDto cardholderData;

    /* getters and setters */

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

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Date getDataValidUntilTimestamp() {
        return dataValidUntilTimestamp;
    }

    public void setDataValidUntilTimestamp(Date dataValidUntilTimestamp) {
        this.dataValidUntilTimestamp = dataValidUntilTimestamp;
    }

    public BillingAddressDto getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddressDto billingAddress) {
        this.billingAddress = billingAddress;
    }

    public CardholderDataDto getCardholderData() {
        return cardholderData;
    }

    public void setCardholderData(CardholderDataDto cardholderData) {
        this.cardholderData = cardholderData;
    }
}
