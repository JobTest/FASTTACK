package com.cts.fasttack.visa.vtis.server.dto;

/**
 * @author Dmitry Koval
 */
public class TokenNotificationCardHolderInfoDto {

    private String primaryAccountNumber;

    private String cvv2;

    private String name;

    private ExpirationDateDto expirationDate;

    public String getPrimaryAccountNumber() {
        return primaryAccountNumber;
    }

    public void setPrimaryAccountNumber(String primaryAccountNumber) {
        this.primaryAccountNumber = primaryAccountNumber;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExpirationDateDto getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ExpirationDateDto expirationDate) {
        this.expirationDate = expirationDate;
    }

}
