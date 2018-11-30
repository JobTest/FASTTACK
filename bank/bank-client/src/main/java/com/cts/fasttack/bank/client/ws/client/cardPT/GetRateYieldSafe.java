
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
 *         &lt;element name="iContractId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iPerccondId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iPercfeeClassId" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "iContractId",
    "iPerccondId",
    "iPercfeeClassId"
})
@XmlRootElement(name = "getRateYieldSafe")
public class GetRateYieldSafe {

    @XmlElement(required = true, nillable = true)
    protected String iContractId;
    @XmlElement(required = true, nillable = true)
    protected String iPerccondId;
    @XmlElement(required = true, nillable = true)
    protected String iPercfeeClassId;

    /**
     * Gets the value of the iContractId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIContractId() {
        return iContractId;
    }

    /**
     * Sets the value of the iContractId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIContractId(String value) {
        this.iContractId = value;
    }

    /**
     * Gets the value of the iPerccondId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPerccondId() {
        return iPerccondId;
    }

    /**
     * Sets the value of the iPerccondId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPerccondId(String value) {
        this.iPerccondId = value;
    }

    /**
     * Gets the value of the iPercfeeClassId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPercfeeClassId() {
        return iPercfeeClassId;
    }

    /**
     * Sets the value of the iPercfeeClassId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPercfeeClassId(String value) {
        this.iPercfeeClassId = value;
    }

}
