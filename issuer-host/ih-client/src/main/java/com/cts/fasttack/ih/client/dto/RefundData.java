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
 *         &lt;element ref="{}Invoice"/>
 *         &lt;element ref="{}AuthorizationRef"/>
 *         &lt;element ref="{}RefundAmount" minOccurs="0"/>
 *         &lt;element ref="{}AirlineAddendumData" minOccurs="0"/>
 *         &lt;element ref="{}Ref3" minOccurs="0"/>
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
    "invoice",
    "authorizationRef",
    "refundAmount",
    "airlineAddendumData",
    "ref3"
})
@XmlRootElement(name = "RefundData")
public class RefundData {

    @XmlElement(name = "Invoice", required = true)
    protected Invoice invoice;
    @XmlElement(name = "AuthorizationRef", required = true)
    protected AuthorizationRef authorizationRef;
    @XmlElement(name = "RefundAmount")
    protected String refundAmount;
    @XmlElement(name = "AirlineAddendumData")
    protected AirlineAddendumData airlineAddendumData;
    @XmlElement(name = "Ref3")
    protected String ref3;

    /**
     * Gets the value of the invoice property.
     * 
     * @return
     *     possible object is
     *     {@link Invoice }
     *     
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * Sets the value of the invoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Invoice }
     *     
     */
    public void setInvoice(Invoice value) {
        this.invoice = value;
    }

    /**
     * Gets the value of the authorizationRef property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizationRef }
     *     
     */
    public AuthorizationRef getAuthorizationRef() {
        return authorizationRef;
    }

    /**
     * Sets the value of the authorizationRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizationRef }
     *     
     */
    public void setAuthorizationRef(AuthorizationRef value) {
        this.authorizationRef = value;
    }

    /**
     * Gets the value of the refundAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundAmount() {
        return refundAmount;
    }

    /**
     * Sets the value of the refundAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundAmount(String value) {
        this.refundAmount = value;
    }

    /**
     * Gets the value of the airlineAddendumData property.
     * 
     * @return
     *     possible object is
     *     {@link AirlineAddendumData }
     *     
     */
    public AirlineAddendumData getAirlineAddendumData() {
        return airlineAddendumData;
    }

    /**
     * Sets the value of the airlineAddendumData property.
     * 
     * @param value
     *     allowed object is
     *     {@link AirlineAddendumData }
     *     
     */
    public void setAirlineAddendumData(AirlineAddendumData value) {
        this.airlineAddendumData = value;
    }

    /**
     * Gets the value of the ref3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRef3() {
        return ref3;
    }

    /**
     * Sets the value of the ref3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRef3(String value) {
        this.ref3 = value;
    }

}
