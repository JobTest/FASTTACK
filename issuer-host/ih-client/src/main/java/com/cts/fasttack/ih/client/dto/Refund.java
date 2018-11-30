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
 *         &lt;element ref="{}RefundData"/>
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
    "refundData"
})
@XmlRootElement(name = "Refund")
public class Refund {

    @XmlElement(name = "RefundData", required = true)
    protected RefundData refundData;

    /**
     * Gets the value of the refundData property.
     * 
     * @return
     *     possible object is
     *     {@link RefundData }
     *     
     */
    public RefundData getRefundData() {
        return refundData;
    }

    /**
     * Sets the value of the refundData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundData }
     *     
     */
    public void setRefundData(RefundData value) {
        this.refundData = value;
    }

}
