
package com.cts.fasttack.bank.client.ws.contragent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerProfileFull complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerProfileFull">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contragentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="getCustomerProfileByTaxIdResponce" type="{http://sab/}getCustomerProfileByTaxIdResponce" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerProfileFull", propOrder = {
    "contragentId",
    "taxId",
    "getCustomerProfileByTaxIdResponce"
})
public class CustomerProfileFull {

    @XmlElementRef(name = "contragentId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contragentId;
    @XmlElementRef(name = "taxId", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxId;
    @XmlElementRef(name = "getCustomerProfileByTaxIdResponce", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<GetCustomerProfileByTaxIdResponce> getCustomerProfileByTaxIdResponce;

    /**
     * Gets the value of the contragentId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContragentId() {
        return contragentId;
    }

    /**
     * Sets the value of the contragentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContragentId(JAXBElement<String> value) {
        this.contragentId = value;
    }

    /**
     * Gets the value of the taxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxId() {
        return taxId;
    }

    /**
     * Sets the value of the taxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxId(JAXBElement<String> value) {
        this.taxId = value;
    }

    /**
     * Gets the value of the getCustomerProfileByTaxIdResponce property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GetCustomerProfileByTaxIdResponce }{@code >}
     *     
     */
    public JAXBElement<GetCustomerProfileByTaxIdResponce> getGetCustomerProfileByTaxIdResponce() {
        return getCustomerProfileByTaxIdResponce;
    }

    /**
     * Sets the value of the getCustomerProfileByTaxIdResponce property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GetCustomerProfileByTaxIdResponce }{@code >}
     *     
     */
    public void setGetCustomerProfileByTaxIdResponce(JAXBElement<GetCustomerProfileByTaxIdResponce> value) {
        this.getCustomerProfileByTaxIdResponce = value;
    }

}
