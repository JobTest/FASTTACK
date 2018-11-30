
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCardAccountBalanceItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCardAccountBalanceItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balanceAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="balanceAmountPos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="balanceAmountCash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCardAccountBalanceItem", propOrder = {
    "balanceAmount",
    "balanceAmountPos",
    "balanceAmountCash",
    "responseCode"
})
public class GetCardAccountBalanceItem {

    @XmlElementRef(name = "balanceAmount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> balanceAmount;
    @XmlElementRef(name = "balanceAmountPos", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> balanceAmountPos;
    @XmlElementRef(name = "balanceAmountCash", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> balanceAmountCash;
    @XmlElementRef(name = "responseCode", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> responseCode;

    /**
     * Gets the value of the balanceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBalanceAmount() {
        return balanceAmount;
    }

    /**
     * Sets the value of the balanceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBalanceAmount(JAXBElement<String> value) {
        this.balanceAmount = value;
    }

    /**
     * Gets the value of the balanceAmountPos property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBalanceAmountPos() {
        return balanceAmountPos;
    }

    /**
     * Sets the value of the balanceAmountPos property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBalanceAmountPos(JAXBElement<String> value) {
        this.balanceAmountPos = value;
    }

    /**
     * Gets the value of the balanceAmountCash property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBalanceAmountCash() {
        return balanceAmountCash;
    }

    /**
     * Sets the value of the balanceAmountCash property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBalanceAmountCash(JAXBElement<String> value) {
        this.balanceAmountCash = value;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResponseCode(JAXBElement<String> value) {
        this.responseCode = value;
    }

}
