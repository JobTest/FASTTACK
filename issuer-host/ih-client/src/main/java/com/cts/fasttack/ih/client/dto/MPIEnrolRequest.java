package com.cts.fasttack.ih.client.dto;

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
 *         &lt;element ref="{}CardNum"/>
 *         &lt;element ref="{}ExpYear"/>
 *         &lt;element ref="{}ExpMonth"/>
 *         &lt;element ref="{}TotalAmount"/>
 *         &lt;element ref="{}Currency"/>
 *         &lt;element ref="{}Description" minOccurs="0"/>
 *         &lt;element ref="{}DeviceCategory" minOccurs="0"/>
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
    "cardNum",
    "expYear",
    "expMonth",
    "totalAmount",
    "currency",
    "description",
    "deviceCategory"
})
@XmlRootElement(name = "MPIEnrolRequest")
public class MPIEnrolRequest {

    @XmlElement(name = "CardNum")
    protected long cardNum;
    @XmlElement(name = "ExpYear", required = true)
    protected String expYear;
    @XmlElement(name = "ExpMonth", required = true)
    protected String expMonth;
    @XmlElement(name = "TotalAmount")
    protected long totalAmount;
    @XmlElement(name = "Currency", required = true)
    protected String currency;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "DeviceCategory")
    protected String deviceCategory;

    /**
     * Gets the value of the cardNum property.
     * 
     */
    public long getCardNum() {
        return cardNum;
    }

    /**
     * Sets the value of the cardNum property.
     * 
     */
    public void setCardNum(long value) {
        this.cardNum = value;
    }

    /**
     * Gets the value of the expYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpYear() {
        return expYear;
    }

    /**
     * Sets the value of the expYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpYear(String value) {
        this.expYear = value;
    }

    /**
     * Gets the value of the expMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpMonth() {
        return expMonth;
    }

    /**
     * Sets the value of the expMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpMonth(String value) {
        this.expMonth = value;
    }

    /**
     * Gets the value of the totalAmount property.
     * 
     */
    public long getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     * 
     */
    public void setTotalAmount(long value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the deviceCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceCategory() {
        return deviceCategory;
    }

    /**
     * Sets the value of the deviceCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceCategory(String value) {
        this.deviceCategory = value;
    }

}
