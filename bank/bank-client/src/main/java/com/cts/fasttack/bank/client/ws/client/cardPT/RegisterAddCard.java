
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardHashNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firstNameLatin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastNameLatin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeWord" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="additionalInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prefixId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="authRangeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codeCardId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="riskClassId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="chargeRenewFee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cardOwnerFullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cardHashNumber",
    "firstNameLatin",
    "lastNameLatin",
    "codeWord",
    "additionalInfo",
    "prefixId",
    "authRangeId",
    "codeCardId",
    "riskClassId",
    "chargeRenewFee",
    "cardOwnerFullName"
})
@XmlRootElement(name = "registerAddCard")
public class RegisterAddCard {

    @XmlElement(required = true, nillable = true)
    protected String cardHashNumber;
    @XmlElement(required = true, nillable = true)
    protected String firstNameLatin;
    @XmlElement(required = true, nillable = true)
    protected String lastNameLatin;
    @XmlElement(required = true, nillable = true)
    protected String codeWord;
    @XmlElement(required = true, nillable = true)
    protected String additionalInfo;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer prefixId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer authRangeId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codeCardId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer riskClassId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer chargeRenewFee;
    @XmlElement(required = true, nillable = true)
    protected String cardOwnerFullName;

    /**
     * Gets the value of the cardHashNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardHashNumber() {
        return cardHashNumber;
    }

    /**
     * Sets the value of the cardHashNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardHashNumber(String value) {
        this.cardHashNumber = value;
    }

    /**
     * Gets the value of the firstNameLatin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstNameLatin() {
        return firstNameLatin;
    }

    /**
     * Sets the value of the firstNameLatin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstNameLatin(String value) {
        this.firstNameLatin = value;
    }

    /**
     * Gets the value of the lastNameLatin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastNameLatin() {
        return lastNameLatin;
    }

    /**
     * Sets the value of the lastNameLatin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastNameLatin(String value) {
        this.lastNameLatin = value;
    }

    /**
     * Gets the value of the codeWord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeWord() {
        return codeWord;
    }

    /**
     * Sets the value of the codeWord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeWord(String value) {
        this.codeWord = value;
    }

    /**
     * Gets the value of the additionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets the value of the additionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalInfo(String value) {
        this.additionalInfo = value;
    }

    /**
     * Gets the value of the prefixId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPrefixId() {
        return prefixId;
    }

    /**
     * Sets the value of the prefixId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPrefixId(Integer value) {
        this.prefixId = value;
    }

    /**
     * Gets the value of the authRangeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAuthRangeId() {
        return authRangeId;
    }

    /**
     * Sets the value of the authRangeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAuthRangeId(Integer value) {
        this.authRangeId = value;
    }

    /**
     * Gets the value of the codeCardId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodeCardId() {
        return codeCardId;
    }

    /**
     * Sets the value of the codeCardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodeCardId(Integer value) {
        this.codeCardId = value;
    }

    /**
     * Gets the value of the riskClassId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRiskClassId() {
        return riskClassId;
    }

    /**
     * Sets the value of the riskClassId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRiskClassId(Integer value) {
        this.riskClassId = value;
    }

    /**
     * Gets the value of the chargeRenewFee property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getChargeRenewFee() {
        return chargeRenewFee;
    }

    /**
     * Sets the value of the chargeRenewFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setChargeRenewFee(Integer value) {
        this.chargeRenewFee = value;
    }

    /**
     * Gets the value of the cardOwnerFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardOwnerFullName() {
        return cardOwnerFullName;
    }

    /**
     * Sets the value of the cardOwnerFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardOwnerFullName(String value) {
        this.cardOwnerFullName = value;
    }

}
