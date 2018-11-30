
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
 *         &lt;element name="adviceId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="subproductCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="channel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="equalAvlAmountIn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "adviceId",
    "subproductCode",
    "channel",
    "phoneNumber",
    "equalAvlAmountIn"
})
@XmlRootElement(name = "processInstallment")
public class ProcessInstallment {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer adviceId;
    @XmlElement(required = true, nillable = true)
    protected String subproductCode;
    @XmlElement(required = true, nillable = true)
    protected String channel;
    @XmlElement(required = true, nillable = true)
    protected String phoneNumber;
    @XmlElement(required = true, nillable = true)
    protected String equalAvlAmountIn;

    /**
     * Gets the value of the adviceId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAdviceId() {
        return adviceId;
    }

    /**
     * Sets the value of the adviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAdviceId(Integer value) {
        this.adviceId = value;
    }

    /**
     * Gets the value of the subproductCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubproductCode() {
        return subproductCode;
    }

    /**
     * Sets the value of the subproductCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubproductCode(String value) {
        this.subproductCode = value;
    }

    /**
     * Gets the value of the channel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Sets the value of the channel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannel(String value) {
        this.channel = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the equalAvlAmountIn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEqualAvlAmountIn() {
        return equalAvlAmountIn;
    }

    /**
     * Sets the value of the equalAvlAmountIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEqualAvlAmountIn(String value) {
        this.equalAvlAmountIn = value;
    }

}
