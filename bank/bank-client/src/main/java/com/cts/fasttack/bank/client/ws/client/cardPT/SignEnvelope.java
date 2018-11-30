
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
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nameDelivery" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addressDelivery" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contractId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "nameDelivery",
    "addressDelivery",
    "contractId"
})
@XmlRootElement(name = "signEnvelope")
public class SignEnvelope {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer cardId;
    @XmlElement(required = true, nillable = true)
    protected String nameDelivery;
    @XmlElement(required = true, nillable = true)
    protected String addressDelivery;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer contractId;

    /**
     * Gets the value of the cardId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCardId() {
        return cardId;
    }

    /**
     * Sets the value of the cardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCardId(Integer value) {
        this.cardId = value;
    }

    /**
     * Gets the value of the nameDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameDelivery() {
        return nameDelivery;
    }

    /**
     * Sets the value of the nameDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameDelivery(String value) {
        this.nameDelivery = value;
    }

    /**
     * Gets the value of the addressDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressDelivery() {
        return addressDelivery;
    }

    /**
     * Sets the value of the addressDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressDelivery(String value) {
        this.addressDelivery = value;
    }

    /**
     * Gets the value of the contractId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getContractId() {
        return contractId;
    }

    /**
     * Sets the value of the contractId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setContractId(Integer value) {
        this.contractId = value;
    }

}
