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
 *         &lt;element ref="{}VISACheckout"/>
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
    "visaCheckout"
})
@XmlRootElement(name = "Wallet")
public class Wallet {

    @XmlElement(name = "VISACheckout", required = true)
    protected VISACheckout visaCheckout;

    /**
     * Gets the value of the visaCheckout property.
     * 
     * @return
     *     possible object is
     *     {@link VISACheckout }
     *     
     */
    public VISACheckout getVISACheckout() {
        return visaCheckout;
    }

    /**
     * Sets the value of the visaCheckout property.
     * 
     * @param value
     *     allowed object is
     *     {@link VISACheckout }
     *     
     */
    public void setVISACheckout(VISACheckout value) {
        this.visaCheckout = value;
    }

}
