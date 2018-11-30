package com.cts.fasttack.jms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dmitry Koval
 */
public class TokenSearchAccountDto {

    @JsonProperty("AccountPanSuffix")
    private String accountPanSuffix;

    @JsonProperty("FinancialAccountSuffix")
    private String financialAccountSuffix;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("InterbankCardAssociationId")
    private String interbankCardAssociationId;

    @JsonProperty("InstitutionName")
    private String institutionName;

    @JsonProperty("ExpirationDate")
    private String expirationDate;

    @JsonProperty("AlternateAccountIdentifierSuffix")
    private String alternateAccountIdentifierSuffix;

    @JsonProperty("Tokens")
    private TokenSearchAccountTokensDto token;

    public String getAccountPanSuffix() {
        return accountPanSuffix;
    }

    public void setAccountPanSuffix(String accountPanSuffix) {
        this.accountPanSuffix = accountPanSuffix;
    }

    public String getFinancialAccountSuffix() {
        return financialAccountSuffix;
    }

    public void setFinancialAccountSuffix(String financialAccountSuffix) {
        this.financialAccountSuffix = financialAccountSuffix;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getInterbankCardAssociationId() {
        return interbankCardAssociationId;
    }

    public void setInterbankCardAssociationId(String interbankCardAssociationId) {
        this.interbankCardAssociationId = interbankCardAssociationId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAlternateAccountIdentifierSuffix() {
        return alternateAccountIdentifierSuffix;
    }

    public void setAlternateAccountIdentifierSuffix(String alternateAccountIdentifierSuffix) {
        this.alternateAccountIdentifierSuffix = alternateAccountIdentifierSuffix;
    }

    public TokenSearchAccountTokensDto getToken() {
        return token;
    }

    public void setToken(TokenSearchAccountTokensDto token) {
        this.token = token;
    }
}
