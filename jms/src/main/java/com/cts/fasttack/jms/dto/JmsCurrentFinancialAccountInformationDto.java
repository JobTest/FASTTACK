package com.cts.fasttack.jms.dto;

/**
 * @author Dmitry Koval
 */
public class JmsCurrentFinancialAccountInformationDto {

    private String financialAccountId;

    private String interbankCardAssociationId;

    private String countryCode;

    public String getFinancialAccountId() {
        return financialAccountId;
    }

    public void setFinancialAccountId(String financialAccountId) {
        this.financialAccountId = financialAccountId;
    }

    public String getInterbankCardAssociationId() {
        return interbankCardAssociationId;
    }

    public void setInterbankCardAssociationId(String interbankCardAssociationId) {
        this.interbankCardAssociationId = interbankCardAssociationId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
