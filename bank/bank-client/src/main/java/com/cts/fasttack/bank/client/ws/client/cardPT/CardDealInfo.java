
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cardDealInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cardDealInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="overdraftAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditLimit" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="minPayment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minPaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cardDealInfo", propOrder = {
    "overdraftAmount",
    "creditLimit",
    "minPayment",
    "minPaymentDate"
})
public class CardDealInfo {

    @XmlElementRef(name = "overdraftAmount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> overdraftAmount;
    @XmlElementRef(name = "creditLimit", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> creditLimit;
    @XmlElementRef(name = "minPayment", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> minPayment;
    @XmlElementRef(name = "minPaymentDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> minPaymentDate;

    /**
     * Gets the value of the overdraftAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOverdraftAmount() {
        return overdraftAmount;
    }

    /**
     * Sets the value of the overdraftAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOverdraftAmount(JAXBElement<String> value) {
        this.overdraftAmount = value;
    }

    /**
     * Gets the value of the creditLimit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the value of the creditLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCreditLimit(JAXBElement<Long> value) {
        this.creditLimit = value;
    }

    /**
     * Gets the value of the minPayment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMinPayment() {
        return minPayment;
    }

    /**
     * Sets the value of the minPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMinPayment(JAXBElement<String> value) {
        this.minPayment = value;
    }

    /**
     * Gets the value of the minPaymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMinPaymentDate() {
        return minPaymentDate;
    }

    /**
     * Sets the value of the minPaymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMinPaymentDate(JAXBElement<String> value) {
        this.minPaymentDate = value;
    }

}
