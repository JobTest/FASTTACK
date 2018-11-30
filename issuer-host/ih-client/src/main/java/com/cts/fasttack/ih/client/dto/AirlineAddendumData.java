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
 *         &lt;choice>
 *           &lt;element ref="{}MasterCard"/>
 *           &lt;element ref="{}VISA"/>
 *         &lt;/choice>
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
    "masterCard",
    "visa"
})
@XmlRootElement(name = "AirlineAddendumData")
public class AirlineAddendumData {

    @XmlElement(name = "MasterCard")
    protected MasterCard masterCard;
    @XmlElement(name = "VISA")
    protected VISA visa;

    /**
     * Gets the value of the masterCard property.
     * 
     * @return
     *     possible object is
     *     {@link MasterCard }
     *     
     */
    public MasterCard getMasterCard() {
        return masterCard;
    }

    /**
     * Sets the value of the masterCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link MasterCard }
     *     
     */
    public void setMasterCard(MasterCard value) {
        this.masterCard = value;
    }

    /**
     * Gets the value of the visa property.
     * 
     * @return
     *     possible object is
     *     {@link VISA }
     *     
     */
    public VISA getVISA() {
        return visa;
    }

    /**
     * Sets the value of the visa property.
     * 
     * @param value
     *     allowed object is
     *     {@link VISA }
     *     
     */
    public void setVISA(VISA value) {
        this.visa = value;
    }

}
