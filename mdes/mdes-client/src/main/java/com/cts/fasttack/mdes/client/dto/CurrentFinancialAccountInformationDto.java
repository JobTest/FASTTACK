package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The current Financial Account Information the token(s) of whom must be updated to a new Financial Account Identifier.
 *
 * @author a.lipavets
 */
@XmlRootElement(name = "CurrentFinancialAccountInformation")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("CurrentFinancialAccountInformation")
public class CurrentFinancialAccountInformationDto {

    @JsonProperty("FinancialAccountId")
    @XmlElement(name = "FinancialAccountId")
    private String financialAccountId;

    @JsonProperty("InterbankCardAssociationId")
    @XmlElement(name = "InterbankCardAssociationId")
    private String interbankCardAssociationId;

    @JsonProperty("CountryCode")
    @XmlElement(name = "CountryCode")
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
