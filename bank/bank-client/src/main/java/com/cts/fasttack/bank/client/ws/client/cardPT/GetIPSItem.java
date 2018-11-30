
package com.cts.fasttack.bank.client.ws.client.cardPT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getIPSItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getIPSItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeIPS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameIPS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getIPSItem", propOrder = {
    "codeIPS",
    "nameIPS"
})
public class GetIPSItem {

    @XmlElementRef(name = "codeIPS", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codeIPS;
    @XmlElementRef(name = "nameIPS", namespace = "http://sab/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nameIPS;

    /**
     * Gets the value of the codeIPS property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodeIPS() {
        return codeIPS;
    }

    /**
     * Sets the value of the codeIPS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodeIPS(JAXBElement<String> value) {
        this.codeIPS = value;
    }

    /**
     * Gets the value of the nameIPS property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNameIPS() {
        return nameIPS;
    }

    /**
     * Sets the value of the nameIPS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNameIPS(JAXBElement<String> value) {
        this.nameIPS = value;
    }

}
