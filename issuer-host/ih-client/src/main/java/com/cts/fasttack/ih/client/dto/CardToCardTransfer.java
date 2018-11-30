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
 *         &lt;element ref="{}PayData"/>
 *         &lt;element ref="{}CardTo"/>
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
    "payData",
    "cardTo"
})
@XmlRootElement(name = "CardToCardTransfer")
public class CardToCardTransfer {

    @XmlElement(name = "PayData", required = true)
    protected PayData payData;
    @XmlElement(name = "CardTo")
    protected long cardTo;

    /**
     * Gets the value of the payData property.
     * 
     * @return
     *     possible object is
     *     {@link PayData }
     *     
     */
    public PayData getPayData() {
        return payData;
    }

    /**
     * Sets the value of the payData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PayData }
     *     
     */
    public void setPayData(PayData value) {
        this.payData = value;
    }

    /**
     * Gets the value of the cardTo property.
     * 
     */
    public long getCardTo() {
        return cardTo;
    }

    /**
     * Sets the value of the cardTo property.
     * 
     */
    public void setCardTo(long value) {
        this.cardTo = value;
    }

}
