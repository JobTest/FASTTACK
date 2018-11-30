
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
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="branchId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chargeRenewFee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nameOnCard" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newCardProduct" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="insuranceFinRiskStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deliveryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deliveryAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recreateType" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "cardId",
    "branchId",
    "chargeRenewFee",
    "nameOnCard",
    "newCardProduct",
    "insuranceFinRiskStatus",
    "deliveryName",
    "deliveryAddress",
    "recreateType"
})
@XmlRootElement(name = "setDeferredRenewCard")
public class SetDeferredRenewCard {

    @XmlElement(required = true, nillable = true)
    protected String cardId;
    @XmlElement(required = true, nillable = true)
    protected String branchId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer chargeRenewFee;
    @XmlElement(required = true, nillable = true)
    protected String nameOnCard;
    @XmlElement(required = true, nillable = true)
    protected String newCardProduct;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer insuranceFinRiskStatus;
    @XmlElement(required = true, nillable = true)
    protected String deliveryName;
    @XmlElement(required = true, nillable = true)
    protected String deliveryAddress;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer recreateType;

    /**
     * Gets the value of the cardId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * Sets the value of the cardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardId(String value) {
        this.cardId = value;
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
     * Gets the value of the nameOnCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOnCard() {
        return nameOnCard;
    }

    /**
     * Sets the value of the nameOnCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOnCard(String value) {
        this.nameOnCard = value;
    }

    /**
     * Gets the value of the newCardProduct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewCardProduct() {
        return newCardProduct;
    }

    /**
     * Sets the value of the newCardProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewCardProduct(String value) {
        this.newCardProduct = value;
    }

    /**
     * Gets the value of the insuranceFinRiskStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInsuranceFinRiskStatus() {
        return insuranceFinRiskStatus;
    }

    /**
     * Sets the value of the insuranceFinRiskStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInsuranceFinRiskStatus(Integer value) {
        this.insuranceFinRiskStatus = value;
    }

    /**
     * Gets the value of the deliveryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryName() {
        return deliveryName;
    }

    /**
     * Sets the value of the deliveryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryName(String value) {
        this.deliveryName = value;
    }

    /**
     * Gets the value of the deliveryAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Sets the value of the deliveryAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryAddress(String value) {
        this.deliveryAddress = value;
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

}
