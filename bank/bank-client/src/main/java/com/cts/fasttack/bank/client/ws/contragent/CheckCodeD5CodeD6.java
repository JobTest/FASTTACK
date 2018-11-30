
package com.cts.fasttack.bank.client.ws.contragent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="residence" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="k070" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="k050" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="k110_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="balanceAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "residence",
    "k070",
    "k050",
    "k1101",
    "balanceAccount"
})
@XmlRootElement(name = "checkCodeD5CodeD6")
public class CheckCodeD5CodeD6 {

    @XmlElement(required = true)
    protected String residence;
    @XmlElement(required = true)
    protected String k070;
    @XmlElement(required = true)
    protected String k050;
    @XmlElement(name = "k110_1", required = true)
    protected String k1101;
    @XmlElementRef(name = "balanceAccount", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> balanceAccount;

    /**
     * Gets the value of the residence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResidence() {
        return residence;
    }

    /**
     * Sets the value of the residence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResidence(String value) {
        this.residence = value;
    }

    /**
     * Gets the value of the k070 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getK070() {
        return k070;
    }

    /**
     * Sets the value of the k070 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setK070(String value) {
        this.k070 = value;
    }

    /**
     * Gets the value of the k050 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getK050() {
        return k050;
    }

    /**
     * Sets the value of the k050 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setK050(String value) {
        this.k050 = value;
    }

    /**
     * Gets the value of the k1101 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getK1101() {
        return k1101;
    }

    /**
     * Sets the value of the k1101 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setK1101(String value) {
        this.k1101 = value;
    }

    /**
     * Gets the value of the balanceAccount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBalanceAccount() {
        return balanceAccount;
    }

    /**
     * Sets the value of the balanceAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBalanceAccount(JAXBElement<String> value) {
        this.balanceAccount = value;
    }

}
