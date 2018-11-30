
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for getCardDailyLimitsItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCardDailyLimitsItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cashMaxAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cashMaxCount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="purchaseMaxAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="purchaseMaxCount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="totalMaxAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="totalMaxCount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="canChange" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCardDailyLimitsItem", propOrder = {
    "cashMaxAmount",
    "cashMaxCount",
    "purchaseMaxAmount",
    "purchaseMaxCount",
    "totalMaxAmount",
    "totalMaxCount",
    "endDate",
    "canChange"
})
public class GetCardDailyLimitsItem {

    @XmlElementRef(name = "cashMaxAmount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> cashMaxAmount;
    @XmlElementRef(name = "cashMaxCount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> cashMaxCount;
    @XmlElementRef(name = "purchaseMaxAmount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> purchaseMaxAmount;
    @XmlElementRef(name = "purchaseMaxCount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> purchaseMaxCount;
    @XmlElementRef(name = "totalMaxAmount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> totalMaxAmount;
    @XmlElementRef(name = "totalMaxCount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> totalMaxCount;
    @XmlElementRef(name = "endDate", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> endDate;
    @XmlElementRef(name = "canChange", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> canChange;

    /**
     * Gets the value of the cashMaxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCashMaxAmount() {
        return cashMaxAmount;
    }

    /**
     * Sets the value of the cashMaxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCashMaxAmount(JAXBElement<Long> value) {
        this.cashMaxAmount = value;
    }

    /**
     * Gets the value of the cashMaxCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getCashMaxCount() {
        return cashMaxCount;
    }

    /**
     * Sets the value of the cashMaxCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setCashMaxCount(JAXBElement<BigInteger> value) {
        this.cashMaxCount = value;
    }

    /**
     * Gets the value of the purchaseMaxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPurchaseMaxAmount() {
        return purchaseMaxAmount;
    }

    /**
     * Sets the value of the purchaseMaxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPurchaseMaxAmount(JAXBElement<Long> value) {
        this.purchaseMaxAmount = value;
    }

    /**
     * Gets the value of the purchaseMaxCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getPurchaseMaxCount() {
        return purchaseMaxCount;
    }

    /**
     * Sets the value of the purchaseMaxCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setPurchaseMaxCount(JAXBElement<BigInteger> value) {
        this.purchaseMaxCount = value;
    }

    /**
     * Gets the value of the totalMaxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getTotalMaxAmount() {
        return totalMaxAmount;
    }

    /**
     * Sets the value of the totalMaxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setTotalMaxAmount(JAXBElement<Long> value) {
        this.totalMaxAmount = value;
    }

    /**
     * Gets the value of the totalMaxCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getTotalMaxCount() {
        return totalMaxCount;
    }

    /**
     * Sets the value of the totalMaxCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setTotalMaxCount(JAXBElement<BigInteger> value) {
        this.totalMaxCount = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setEndDate(JAXBElement<XMLGregorianCalendar> value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the canChange property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getCanChange() {
        return canChange;
    }

    /**
     * Sets the value of the canChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setCanChange(JAXBElement<BigInteger> value) {
        this.canChange = value;
    }

}
