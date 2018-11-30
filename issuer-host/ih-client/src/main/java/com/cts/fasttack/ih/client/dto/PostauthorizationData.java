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
 *         &lt;element ref="{}PreauthorizationRef"/>
 *         &lt;element ref="{}PostauthorizationAmount" minOccurs="0"/>
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
    "preauthorizationRef",
    "postauthorizationAmount",
    "airlineAddendumData",
    "ref3"
})
@XmlRootElement(name = "PostauthorizationData")
public class PostauthorizationData {

    @XmlElement(name = "Invoice", required = true)
    protected Invoice invoice;
    @XmlElement(name = "PreauthorizationRef", required = true)
    protected PreauthorizationRef preauthorizationRef;
    @XmlElement(name = "PostauthorizationAmount")
    protected String postauthorizationAmount;
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
     * Gets the value of the preauthorizationRef property.
     * 
     * @return
     *     possible object is
     *     {@link PreauthorizationRef }
     *     
     */
    public PreauthorizationRef getPreauthorizationRef() {
        return preauthorizationRef;
    }

    /**
     * Sets the value of the preauthorizationRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreauthorizationRef }
     *     
     */
    public void setPreauthorizationRef(PreauthorizationRef value) {
        this.preauthorizationRef = value;
    }

    /**
     * Gets the value of the postauthorizationAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostauthorizationAmount() {
        return postauthorizationAmount;
    }

    /**
     * Sets the value of the postauthorizationAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostauthorizationAmount(String value) {
        this.postauthorizationAmount = value;
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
