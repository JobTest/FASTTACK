
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
 *         &lt;element name="iTag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="val" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "iTag",
    "val"
})
@XmlRootElement(name = "getAvailIdArray")
public class GetAvailIdArray {

    @XmlElement(required = true, nillable = true)
    protected String iTag;
    @XmlElement(required = true, nillable = true)
    protected String val;

    /**
     * Gets the value of the iTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITag() {
        return iTag;
    }

    /**
     * Sets the value of the iTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITag(String value) {
        this.iTag = value;
    }

    /**
     * Gets the value of the val property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVal() {
        return val;
    }

    /**
     * Sets the value of the val property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVal(String value) {
        this.val = value;
    }

}
