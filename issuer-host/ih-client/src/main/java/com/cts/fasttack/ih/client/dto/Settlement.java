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
 *       &lt;choice>
 *         &lt;element ref="{}SettlementRefundData"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "settlementRefundData"
})
@XmlRootElement(name = "Settlement")
public class Settlement {

    @XmlElement(name = "SettlementRefundData")
    protected SettlementRefundData settlementRefundData;

    /**
     * Gets the value of the settlementRefundData property.
     * 
     * @return
     *     possible object is
     *     {@link SettlementRefundData }
     *     
     */
    public SettlementRefundData getSettlementRefundData() {
        return settlementRefundData;
    }

    /**
     * Sets the value of the settlementRefundData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementRefundData }
     *     
     */
    public void setSettlementRefundData(SettlementRefundData value) {
        this.settlementRefundData = value;
    }

}
