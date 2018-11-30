
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
 *         &lt;element name="recreateType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="branchId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="oldCardStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="chargeRenewFee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="firstNameLatin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastNameLatin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="projectId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isPersonalized" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "recreateType",
    "branchId",
    "oldCardStatus",
    "chargeRenewFee",
    "firstNameLatin",
    "lastNameLatin",
    "projectId",
    "isPersonalized"
})
@XmlRootElement(name = "recreateCard")
public class RecreateCard {

    @XmlElement(required = true, nillable = true)
    protected String cardHashNumber;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer recreateType;
    @XmlElement(required = true, nillable = true)
    protected String branchId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer oldCardStatus;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer chargeRenewFee;
    @XmlElement(required = true, nillable = true)
    protected String firstNameLatin;
    @XmlElement(required = true, nillable = true)
    protected String lastNameLatin;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer projectId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer isPersonalized;

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
     * Gets the value of the recreateType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRecreateType() {
        return recreateType;
    }

    /**
     * Sets the value of the recreateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRecreateType(Integer value) {
        this.recreateType = value;
    }

    /**
     * Gets the value of the branchId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchId() {
        return branchId;
    }

    /**
     * Sets the value of the branchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchId(String value) {
        this.branchId = value;
    }

    /**
     * Gets the value of the oldCardStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOldCardStatus() {
        return oldCardStatus;
    }

    /**
     * Sets the value of the oldCardStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOldCardStatus(Integer value) {
        this.oldCardStatus = value;
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
     * Gets the value of the projectId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * Sets the value of the projectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProjectId(Integer value) {
        this.projectId = value;
    }

    /**
     * Gets the value of the isPersonalized property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIsPersonalized() {
        return isPersonalized;
    }

    /**
     * Sets the value of the isPersonalized property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIsPersonalized(Integer value) {
        this.isPersonalized = value;
    }

}
