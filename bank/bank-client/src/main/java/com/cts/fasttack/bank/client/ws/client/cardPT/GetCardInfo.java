
package com.cts.fasttack.bank.client.ws.client.cardPT;

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
 *         &lt;element name="iCardHashNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iCardid" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "iCardHashNumber",
    "iCardid"
})
@XmlRootElement(name = "getCardInfo")
public class GetCardInfo {

    @XmlElement(required = true, nillable = true)
    protected String iCardHashNumber;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer iCardid;

    /**
     * Gets the value of the iCardHashNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICardHashNumber() {
        return iCardHashNumber;
    }

    /**
     * Sets the value of the iCardHashNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICardHashNumber(String value) {
        this.iCardHashNumber = value;
    }

    /**
     * Gets the value of the iCardid property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getICardid() {
        return iCardid;
    }

    /**
     * Sets the value of the iCardid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setICardid(Integer value) {
        this.iCardid = value;
    }

}
